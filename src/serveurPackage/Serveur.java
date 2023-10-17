package serveurPackage;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Serveur {
	public static void main(String[]args) 
	
	{
		
		try {
			 // Affiche un message indiquant que le programme est un serveur
			System.out.println("Je suis un serveur");
			//localisation de serveur dans un port
			ServerSocket ss =new ServerSocket(4000);
			// Affiche un message indiquant qu'il attend un client
			System.out.println("j'attend un client");
			//creation un objet Socket et attend la connexion du client 
			Socket s=ss.accept();
			// Affiche un message indiquant qu'un client est connecté
			System.out.println("un client est connecté");
			// Récupère les flux d'entrée et de sortie du socket pour communiquer avec le client
			OutputStream os=s.getOutputStream();
			InputStream is=s.getInputStream();
			// Lit une valeur du flux d'entrée (venant du client)
			int nb=is.read();//3
			 // Affiche la valeur reçue du client
			System.out.println("J ai recu la valeur"+nb);
			// Effectue des opérations somme et fois sur la valeur reçue
			int rep=nb*5;//4
			//int som=nb+5;
			// Envoie les résultats au client via le flux de sortie
			os.write(rep);//5
			//os.write(som);
			// Affiche un message de déconnexion du serveur
			System.out.println("Déconnexion Serveur");
			// Ferme le socket (déconnexion de la communication entre le serveur et le client)
			s.close();
			//déconnexion et Fermeture de ServerSocket
			ss.close();
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
