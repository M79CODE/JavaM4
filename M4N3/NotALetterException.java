package restaurantM4N3;

import java.util.InputMismatchException;

public class NotALetterException extends InputMismatchException{
	public NotALetterException () {
		super ("No has introdu�t una lletra.\nPer favor torna a introdu�r S (si) o N (no),\nper saber si vols seguir demanant. Gr�cies.");
	}
}
