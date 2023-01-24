package fr.epsi.b32223g1.ihm;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.DAOFactory;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.util.List;

public class Main {
	
	public static void main( String[] args ) {
		
		try {
			FournisseurDAO dao = DAOFactory.getFournisseurDAO();
			
			//Ajout d'un nouveau fournisseur
			dao.insert( new Fournisseur( "L''espace création" ) );
			
			//Extraction
			List<Fournisseur> fournisseurs = dao.extraire();
		
			for ( Fournisseur item : fournisseurs ) {
				System.out.println( item );
			}
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
}