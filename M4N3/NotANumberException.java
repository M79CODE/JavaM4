package restaurantM4N3;

import java.util.InputMismatchException;

public class NotANumberException extends InputMismatchException{
	public NotANumberException() {
		super ("No has introdu�t un n�mero.\nPer favor torna a introdu�r el n�mero del plat que vols demanar.");
	}
}
