package restaurantM4;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class RestaurantM4N1F3 {
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
		
		// Fem servir un LinkedHashMap preuPlat, per tal de conservar l'ordre d'introducció dels elements, ja que un HashMap no conserva l'ordre, i perquè els keys han de ser únics
		LinkedHashMap<String, Integer> preuPlat = new LinkedHashMap<String, Integer>();
		
		// FASE 2 (modificada): 
		
		//Omplim el LinkedHashMap per paràmetres per evitar demanar la introducció de plats cada cop que executem el programa
		preuPlat.put("Sopa Bullabesa", 9);
		preuPlat.put("Crema de boletus", 8);
		preuPlat.put("Amanida Cèsar", 7);
		preuPlat.put("Entrecot al gust", 12);
		preuPlat.put("Bacallà a la llauna", 10);
		preuPlat.put("Remenat d'alls i gambes", 9);
		preuPlat.put("Parrillada de verdures", 11);
		preuPlat.put("Sorbet de llimona", 6);
		preuPlat.put("Tiramisú", 7);
		preuPlat.put("Fruita del temps", 5);
		
		int countMenu = 0;
		
		// Omplim els arrays plats i preus amb un for each
		for (Entry<String, Integer> preuPlatElem : preuPlat.entrySet()) {
			plats[countMenu] = preuPlatElem.getKey();
			preus[countMenu] = preuPlatElem.getValue();
			countMenu++;
		}
		
		// Ensenyem el menú recorrent el LinkedHashMap
		System.out.println("Menú de Ca la Lluna");
		System.out.println("*******************\n");
		int i=0;
		
		for (String plat : preuPlat.keySet()) {
	      System.out.println((i++) + " - " + plat + " ......... " + preuPlat.get(plat) + "€");
	    }
		
		System.out.println();
		
		// Definim un LinkedHashMap comanda per anar guardant els plats que es vagin demanant
		LinkedHashMap<Integer, Integer> comanda = new LinkedHashMap<Integer, Integer>();
		
		System.out.println("Bon dia. Benvingut a Ca la Lluna!");
		
		demanarCom(comanda); // Cridem al mètode demanarCom per demanar els plats
		
		/* FASE 3
		Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi. En el cas que la informació que hem introduït a la 
		List coincideixi amb la del array, haurem de sumar el preu del producte demanat; en el cas contrari haurem de mostrar un missatge que digui que el producte 
		que hem demanat no existeix.
		Finalment mostrarem el preu total de la comanda i els bitllets/monedes amb les quals s'hauria de pagar.
		*/
		Integer platsComanda = 0; // Declarem i iniciem la variable per guardar la quantitat de plats total de la comanda
		System.out.println("\nAquesta és la teva comanda:\n");
		
		for(int platCom : comanda.keySet()) {
			if(platCom >=0 && platCom <=9) {
			System.out.println(plats[platCom] + " (" + comanda.get(platCom) + " un.) " + " ......... " + (preus[platCom]*comanda.get(platCom)) + "€");
			preuTotal += preus[platCom]*comanda.get(platCom);
			platsComanda += comanda.get(platCom);
			} else {
				System.out.println("El plat número " + platCom + " no existeix.");
			}
		}
		
		System.out.println("\nTotal comanda: " + preuTotal + "€ - " + platsComanda + " plats");
		
		System.out.println("\nHauries de pagar amb el següents bitllets i monedes:");
		preuTotal = preuTotal * 100;
		bitllet500 = preuTotal/50000;
		if(bitllet500 >= 1) System.out.println(bitllet500 + " bitllet(s) de 500€");
		preuTotal = preuTotal % 50000;
		bitllet200 = preuTotal/20000;
		if(bitllet200 >= 1) System.out.println(bitllet200 + " bitllet(s) de 200€");
		preuTotal = preuTotal % 20000;
		bitllet100 = preuTotal/10000;
		if(bitllet100 >= 1) System.out.println(bitllet100 + " bitllet(s) de 100€");
		preuTotal = preuTotal % 10000;
		bitllet50 = preuTotal/5000;
		if(bitllet50 >= 1) System.out.println(bitllet50 + " bitllet(s) de 50€");
		preuTotal = preuTotal % 5000;
		bitllet20 = preuTotal/2000;
		if(bitllet20 >= 1) System.out.println(bitllet20 + " bitllet(s) de 20€");
		preuTotal = preuTotal % 2000;
		bitllet10 = preuTotal/1000;
		if(bitllet10 >= 1) System.out.println(bitllet10 + " bitllet(s) de 10€");
		preuTotal = preuTotal % 1000;
		bitllet5 = preuTotal/500;
		if(bitllet5 >= 1) System.out.println(bitllet5 + " bitllet(s) de 5€");
		preuTotal = preuTotal % 500;
		moneda2 = preuTotal/200;
		if(moneda2 >=1) System.out.println(moneda2 + " moneda(es) de 2€");
		preuTotal = preuTotal % 200;
		moneda1 = preuTotal/100;
		if(moneda1 >=1) System.out.println(moneda1 + " moneda(es) de 1€");
		preuTotal = preuTotal % 100;
		
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
				System.out.println("\nEl plat número " + platNext + " no existeix.");
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
