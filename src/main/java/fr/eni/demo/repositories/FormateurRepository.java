package fr.eni.demo.repositories;

import fr.eni.demo.entities.Formateur;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormateurRepository {

	private NamedParameterJdbcTemplate jdbc;

	public FormateurRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
		jdbc.getJdbcOperations().execute("""
			CREATE TABLE IF NOT EXISTS FORMATEURS (
				email NVARCHAR(200) PRIMARY KEY,
				prenom NVARCHAR(250) NOT NULL,
				nom NVARCHAR(250) NOT NULL);
			""");
	}

	public void insert(Formateur contact) {
		String sqlInsert = " INSERT INTO formateurs (email, prenom, nom ) VALUES ( :email, :prenom, :nom ) ";
		jdbc.update( sqlInsert, new BeanPropertySqlParameterSource(contact) );
	}

	public List<Formateur> findAll() {
		String sqlSelectAll = " SELECT email, prenom, nom FROM formateurs ";
		return jdbc.getJdbcOperations().query( sqlSelectAll, new BeanPropertyRowMapper<>(Formateur.class) );
	}

}
