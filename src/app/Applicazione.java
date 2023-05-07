package app;
import entità.Audio;
import entità.Video;
import entità.Immagine;
import entità.OggettoMultimediale;
import java.util.Scanner;

public class Applicazione {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        OggettoMultimediale[] oggettiMultimediali = new OggettoMultimediale[5];

	        for (int i = 0; i < oggettiMultimediali.length; i++) {
	            System.out.println("Inserisci il titolo dell'oggetto multimediale n." + (i + 1) + " che vuoi creare:");
	            String titolo = scanner.nextLine();

	            System.out.println("L'oggetto multimediale n." + (i + 1) + " è un audio o un video o un immagine? (a/v/i)");
	            String tipo = scanner.nextLine();

	            switch (tipo) {
	                case "a":
	                    System.out.println("Imposta il volume dell'audio (inserisci un numero intero):");
	                    int volume = scanner.nextInt();

	                    System.out.println("Imposta la durata dell'audio (inserisci un numero intero):");
	                    int durata = scanner.nextInt();

	                    oggettiMultimediali[i] = new Audio(titolo, volume, durata);
	                    break;

	                case "v":
	                    System.out.println("Imposta il volume del video (inserisci un numero intero):");
	                    volume = scanner.nextInt();

	                    System.out.println("Imposta la durata del video (inserisci un numero intero):");
	                    durata = scanner.nextInt();

	                    System.out.println("Imposta la luminosità del video (inserisci un numero intero):");
	                    int luminosita = scanner.nextInt();

	                    oggettiMultimediali[i] = new Video(titolo, volume, durata, luminosita);
	                    break;

	                case "i":
	                    System.out.println("Imposta la luminosità dell'immagine (inserisci un numero intero):");
	                    luminosita = scanner.nextInt();
	                    oggettiMultimediali[i] = new Immagine(titolo, luminosita);
	                    break;

	                default:
	                    System.out.println("Tipo non valido. Riprova.");
	                    i--;
	                    continue;
	            }
	            scanner.nextLine();
	        }
	        int scelta = -1;

	        while (scelta != 0) {
	            System.out.println("Quale oggetto multimediale vuoi riprodurre? (1-2-3-4-5?, digita 0 per uscire)");
	            scelta = scanner.nextInt();
	            
	            if (scelta >= 1 && scelta <= 5) {
	                OggettoMultimediale oggetto = oggettiMultimediali[scelta - 1];

	                if (oggetto instanceof Audio) {
	                    ((Audio) oggetto).play();
	                } else if (oggetto instanceof Video) {
	                    ((Video) oggetto).play();
	                } else if (oggetto instanceof Immagine) {
	                    ((Immagine) oggetto).show();
	                }
	            } else if (scelta == 0) {
	            	System.out.println("riproduzione interrotta");
	            } else {
	            	System.out.println("Scelta non valida riprova!");
	            }
	        }
	        scanner.close();
	    }
}
	        
	        

	       