package restaurantM4N3;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class RestaurantM4N3 {

	static boolean check1 = true; // Declarem la variable boolean global per poguer accedir-hi des de tots els mètodes
	
	public static void main(String[] args) throws PlatNotFound, Exception {
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
		
		// FASE 3
		
		Integer platsComanda = 0; // Declarem i iniciem la variable per guardar la quantitat de plats total de la comanda
		System.out.println("\nAquesta és la teva comanda:\n");
		
		for(int platCom : comanda.keySet()) {
			System.out.println(plats[platCom] + " (" + comanda.get(platCom) + " un.) " + " ......... " + (preus[platCom]*comanda.get(platCom)) + "€");
			preuTotal += preus[platCom]*comanda.get(platCom);
			platsComanda += comanda.get(platCom);
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
	
	/* NIVELL 3
	Crea excepcions personalitzades amb fitxers nous e implementa-les al codi actual. 
	Has de crear Excepcions personalitzades per:  Revisió de tipus, introducció de plats, revisió de plats de la comanda. 
	El text ha de ser personalitzat. No cal que propaguis l’excepció.
	Rodeja amb un try/catch cada part que has de revisar amb una excepció.
	*/
	
	// Nou métode per demanar comanda fent servir les classes PlatNotFound i CheckDemanMes de control d'excepcions
	public static LinkedHashMap<Integer, Integer> demanarCom(LinkedHashMap<Integer, Integer> comanda2) {
		
		// Creem la variable int platNext per enmagatzemar el número del plat demanat
		int platNext = 0;
		
		// Creem la variable booleana demanar per preguntar si es vol demanar més o no
		boolean demanar = true;
		do {
			triarPlat(platNext, comanda2);
			demanar = continuaDem();
		} while(demanar);
		
		return comanda2;
	}
	
	public static void triarPlat(int platNext, LinkedHashMap<Integer, Integer> comanda2) {
		boolean check = true;
		do {
			try {
				System.out.println("Què vols demanar? Introdueix el número del plat (0-9).");
				platNext = getIntegerInput();
				getPlatNext(platNext, comanda2);
				check = false;
			} catch (PlatNotFound e) {
				System.out.println(e.getMessage());
			} catch (NotANumberException e) {
				System.out.println(e.getMessage());
			}
		} while(check);
	}
	
	public static boolean continuaDem() {
		check1 = true;
		boolean check2 = true;
		do{
			try {
				System.out.println("\nVols demanar alguna cosa més? (S/N): ");
				check2 = getSiNoInput();
			} catch (CheckDemanaMes e) {
				System.out.println(e.getMessage());
			}
		} while(check1);
		return check2;
	}
	
	public static boolean getSiNoInput() throws CheckDemanaMes {
		Scanner inputString = new Scanner(System.in);
		boolean check2 = true;
		String checkDemanar = inputString.nextLine();
		
		if(checkDemanar.equals("n")){
			check1 = false;
			check2 = false;
		} else if(checkDemanar.equals("s")) {
			check1 = false;
			check2 = true;
		} else {
			throw new CheckDemanaMes();	
		}
		return check2;
	}
	
	public static int getIntegerInput() throws NotANumberException{
		Scanner inputInt = new Scanner(System.in);
		try {
			return inputInt.nextInt();
		} catch (InputMismatchException e){
			throw new NotANumberException();
		}
	}
	
	public static LinkedHashMap<Integer, Integer> getPlatNext(int platNext, LinkedHashMap<Integer, Integer> comanda2) throws  PlatNotFound{
		
			if(platNext >= 0 && platNext <= 9) {
				if(comanda2.containsKey(platNext)) {
					comanda2.put(platNext, comanda2.get(platNext)+1);
				} else {
					comanda2.put(platNext, 1);
				}
				
			} else {
				throw new PlatNotFound();
			}
			return comanda2;
	}
	
}
