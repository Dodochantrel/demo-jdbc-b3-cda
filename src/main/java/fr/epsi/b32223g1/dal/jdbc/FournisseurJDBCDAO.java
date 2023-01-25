package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurJDBCDAO implements FournisseurDAO {
	
	private static final String FIND_ALL_QUERY = "SELECT * FROM fournisseur";
	private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES ('%s')";
	
	
	
	@Override
	public List<Fournisseur> extraire() throws SQLException {
		
		List<Fournisseur> list = new ArrayList<>();
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try ( Statement st = connection.createStatement();
			  ResultSet rs = st.executeQuery( FIND_ALL_QUERY ) ) {
			
			while ( rs.next() ) {
				int id = rs.getInt( "ID" );
				String nom = rs.getString( "NOM" );
				Fournisseur fournisseur = new Fournisseur( id, nom );
				list.add( fournisseur );
			}
		}
		return list;
	}
	
	@Override
	public void insert( Fournisseur fournisseur ) throws SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try ( Statement st = connection.createStatement(); ) {
			st.executeUpdate( String.format( INSERT_QUERY, fournisseur.getName() ) );
		}
	}
	
	@Override
	public int update( String ancienNom, String nouveauNom ) {
		//TODO à coder
		return 0;
	}
	
	@Override
	public boolean delete( Fournisseur fournisseur ) {
		//TODO à coder
		return false;
	}
}
