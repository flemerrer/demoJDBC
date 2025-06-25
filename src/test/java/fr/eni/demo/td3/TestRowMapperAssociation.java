package fr.eni.demo.td3;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.demo.entities.Formateur;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fr.eni.demo.bo.Cours;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestRowMapperAssociation {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void test01_Populate() {
		ClassPathResource resource = new ClassPathResource("static/demo_script.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(jdbcTemplate.getDataSource());
	}

	@Test
	void test02_QueryForList() {
		String sql = "SELECT email, nom, prenom, id_cours_principal FROM FORMATEURS;";
		List<Formateur> formateurs = jdbcTemplate.query(sql, new FormateurRowMapper());
		assertNotNull(formateurs);
		formateurs.forEach(e -> assertNotNull(e.getListeCours()));
		formateurs.forEach(e -> assertTrue(e.getListeCours().size() == 1));

	}

	/**
	 * Mise en place du RowMapper avec gestion de l'association 1-1
	 */
	class FormateurRowMapper implements RowMapper<Formateur> {

		@Override
		public Formateur mapRow(ResultSet rs, int rowNum) throws SQLException {
			Formateur f = new Formateur();
			f.setEmail(rs.getString("email"));
			f.setNom(rs.getString("nom"));
			f.setPrenom(rs.getString("prenom"));

			// Association
			Cours coursPrincipal = new Cours();
			coursPrincipal.setId(rs.getLong("id_cours_principal"));
			f.addCours(coursPrincipal);

			return f;
		}
	}
}
