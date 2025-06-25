package fr.eni.demo.td4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.eni.demo.bo.Cours;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestIdentity {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	// Insertion d'un cours avec un NamedParameterJdbcTemplate
	int insertIDENTITY(Cours cours) {
//		 Manipulation de la clef primaire auto-générée : IDENTIY
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		if (keyHolder != null && keyHolder.getKey() != null) {
//			// Mise à jour de l'identifiant du film auto-généré par la base
//			FIXME: doesnt work, insertedvalue is 0
//			cours.setId(keyHolder.getKey().longValue());
//		}

		// utilisation d"un paramètre ?
		String sql = "INSERT INTO COURS_ENI (titre, duree, id) VALUES (:titre, :duree, :id)";

		// Manipulation d"une Map <nom_paramètre, valeur>
		// l'ordre n'est pas imposé
		// le nom_parametre qui est important
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("titre", cours.getTitre());
		namedParameters.addValue("duree", cours.getDuree());
		namedParameters.addValue("id", cours.getId());

		return jdbcTemplate.update(sql, namedParameters);
	}

	@Test
	void init() {
		ClassPathResource resource = new ClassPathResource("static/demo_script_mssql.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(jdbcTemplate.getJdbcTemplate().getDataSource());
	}

	@Test
	void test01_Identity() {
		Cours c = new Cours();
		c.setDuree(15);
		c.setTitre("Développement Web côté serveur en Java");
		c.setId(1);
		int nbEnregistrement = insertIDENTITY(c);
		assertEquals(1, nbEnregistrement);
		assertTrue(c.getId() > 0);

		logger.info("Identity");
		logger.info(c.getId());
	}

}
