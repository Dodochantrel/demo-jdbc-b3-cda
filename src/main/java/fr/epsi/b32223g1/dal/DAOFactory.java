package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;
import fr.epsi.b32223g1.dal.jpa.FournisseurJPADAO;
import fr.epsi.b32223g1.dal.xml.FournisseurXMLDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.util.ResourceBundle;

public class DAOFactory {
	
	private static final String STORE_MODE;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle( "app-config" );
		STORE_MODE = bundle.getString( "store.mode" );
	}
	
	private DAOFactory() {}
	
	
	public static FournisseurDAO getFournisseurDAO() throws Exception {
		
		FournisseurDAO dao;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new FournisseurJDBCDAO();
				break;
			case "XML" :
				dao = new FournisseurXMLDAO();
				break;
			case "JPA":
				dao = new FournisseurJPADAO();
				break;
			default:
				throw new StoreModeNotFoundException(STORE_MODE);
				
		}
		return dao;
	}
}
