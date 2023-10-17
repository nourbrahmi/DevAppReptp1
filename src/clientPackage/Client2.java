package clientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
//Client sur cette machine et le serveur dans une autre machine
public class Client2 {
    public static void main(String[] args) {
        try {
            // Affiche un message indiquant que le client n'est pas encore connecté
            System.out.println("Je suis un client pas encore connecté");

            // Crée un socket client pour se connecter au serveur sur le localhost et le port 1234
            InetAddress inetAddress= InetAddress.getByName("192.168.110.1");//ipv4
            InetSocketAddress inetSocketAdress=new InetSocketAddress(inetAddress,500);
            Socket s=new Socket();
            // Affiche un message indiquant que le client est connecté au serveur
            System.out.println("Je suis connecté au serveur");
         // Récupère les flux d'entrée et de sortie du socket pour communiquer avec le serveur
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            
            // Lit un nombre depuis la console en utilisant un objet Scanner
            int nb;
            System.out.println("Écrire un nombre : ");
            Scanner scanner = new Scanner(System.in);//1
            //system.in hedhi bch na9ra beha l valeur
            
            nb = scanner.nextInt();

            

            // Envoie le nombre au serveur via le flux de sortie
            os.write(nb);//2

            // Lit la réponse du serveur depuis le flux d'entrée
            int rep = is.read();

            // Affiche la réponse du serveur
            System.out.println("Le produit de " + nb + "*5 = " + rep);

            // Affiche un message de déconnexion du client
            System.out.println("Déconnexion client");

            // Ferme le socket du client (déconnexion)
            s.close();

        } catch (IOException e) {
            // En cas d'erreur d'entrée/sortie
            e.printStackTrace();
        }
    }
}

