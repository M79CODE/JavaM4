package restaurantM4N3;

import java.util.InputMismatchException;

public class NotANumberException extends InputMismatchException{
	public NotANumberException() {
		super ("No has introduït un número.\nPer favor torna a introduïr el número del plat que vols demanar.");
	}
}
