package fr.epsi.b32223g1.ihm;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.bo.Utilisateur;
import fr.epsi.b32223g1.dal.DAOFactory;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.UtilisateurDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		authentification();
		
		authentificationSecurisee();
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
	
	private static void authentificationSecurisee() {
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("********** Bienvenue dans mon App Sécurisée ****");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentificationSecurisee( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void authentification() {
		
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("************ Bienvenue dans mon App ************");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentification( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
}