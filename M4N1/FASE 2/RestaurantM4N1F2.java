package restaurantM4;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class RestaurantM4N1F2 {
	public static void main(String[] args) {
	/* NIVELL 1
	L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem diferents plats i després escollirem què volem per menjar. 
	Un cop fet això s’haurà de calcular el preu del menjar i el programa ens dirà amb quins bitllets hem de pagar.
	*/
		// FASE 1
		
		int moneda1;
		int moneda2;
		int bitllet5;
		int bitllet10;
		int bitllet20;
		int bitllet50;
		int bitllet100;
		int bitllet200;
		int bitllet500;
		
		int preuTotal = 0;
		
		String[] plats = new String[10];
		int[] preus = new int[10];
		
		/* FASE 2
		− Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat i després el preu.
		  Es pot fer de dues formes:  Es pot fer us d'un diccionari de dades precarregat (Java HashMap) o amb un bucle demanant les dades a l'usuari.
		− Un cop plens els dos arrays haurem de mostrar-los i preguntar què es vol per menjar, guardarem la informació en una List fent servir un bucle while.
		− Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el sistema (1:Si / 0:No), per tant haureu de crear un altre variable int per 
		  guardar la informació.
		*/
		
		LinkedHashMap<String, Integer> preuPlat = new LinkedHashMap<String, Integer>();
		// Fem servir un LinkedHashMap per tal de conservar l'ordre d'introducció dels elements, ja que un HashMap no conserva l'ordre, i perquè els keys han de ser únics
		
		// Necessitem 2 Scanner perquè recullen diferents tipus de dades, i així evitem errors de compilació
		Scanner reader4 = new Scanner(System.in);
		Scanner reader5 = new Scanner(System.in);
		
		// Omplim els arrays alhora que omplim el LinkedHashMap
		for(int i=0; i<10; i++) {
			System.out.print("Introdueix el plat nº " + (i+1) + ": ");
			plats[i] = reader4.nextLine(); // Omplim array plats
			System.out.print("Introdueix el preu del plat nº " + (i+1) + ": ");
			preus[i] = reader5.nextInt(); // Omplim array preus
			
			System.out.println();
			
			preuPlat.put(plats[i], preus[i]); // Omplim LinkedHashMap preuPlats
		}
		
		// Finalitzem els Scanner
		reader4.close();
		reader5.close();
		
		// Ensenyem el menú recorrent el LinkedHashMap
		System.out.println("Menú de Ca la Lluna");
		System.out.println("*******************\n");
		int i=0;
		
		for (String plat : preuPlat.keySet()) {
	      System.out.println((i++) + " - " + plat + " ......... " + preuPlat.get(plat) + "€");
	    }
		
		System.out.println();
		System.out.println("Bon dia. Benvingut a Ca la Lluna!");
		
		// Definim un LinkedHashMap per anar guardant els plats que es vagin demanant
		LinkedHashMap<Integer, Integer> comanda = new LinkedHashMap<Integer, Integer>();
				
		demanarCom(comanda); // Cridem al mètode demanarCom per demanar els plats
	}
	
	public static void demanarCom(LinkedHashMap<Integer, Integer> comanda)  {
		
		//Tornem a definir els Scanner per recollir les dades introduïdes per l'usuari
		Scanner reader6 = new Scanner(System.in);
		Scanner reader7 = new Scanner(System.in);
		
		// Creem la variable int platNext per enmagatzemar el número del plat demanat
		int platNext;
		
		// Creem la variable booleana demanar per preguntar si es vol demanar més o no
		boolean demanar = true;
		
		// Creem la variable String checkDemanar per enmagatzemar la resposta
		String checkDemanar;
		
		// Definim un do-while per entrar al bucle al menys una vegada
		do {
			System.out.println("Què vols demanar? Introdueix el número del plat (0-9).");
			platNext = reader7.nextInt();
			
			if(platNext >= 0 && platNext <= 9) {
				if(comanda.containsKey(platNext)) {
					comanda.put(platNext, comanda.get(platNext)+1);
				} else {
					comanda.put(platNext, 1);
				}
			} else {
				System.out.println("El plat número " + platNext + " no existeix.");
			}
			
			System.out.println("\nVols demanar alguna cosa més? (S/N): ");
			checkDemanar = reader6.next().toLowerCase();
			
			if(checkDemanar.equals("s")) {
				demanar = true;	
			} else if (checkDemanar.equals("n")){
				demanar = false;
			}
			
		} while(demanar);
	}
}
