package restaurantM4N3;

import java.util.InputMismatchException;

public class NotALetterException extends InputMismatchException{
	public NotALetterException () {
		super ("No has introduït una lletra.\nPer favor torna a introduïr S (si) o N (no),\nper saber si vols seguir demanant. Gràcies.");
	}
}
