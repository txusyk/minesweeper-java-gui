import java.util.Scanner;

public class Teclado {

	private static Teclado miTeclado;
	private Scanner scan;
	
	public Teclado(){
		scan = new Scanner(System.in);
	}
	
	public static Teclado getMiTeclado(){
		if (miTeclado==null){
			miTeclado = new Teclado();
		}
		return miTeclado;
	}

	/*
	 * Recoge un int. En caso de que no sea valido, vuelve a solicitarlo hasta que
	 * reciba un int valido.
	 */
	public int recogerInt(){
		String auxS = null;
		int resul = 0;
		
		auxS = scan.nextLine();
		while(!this.esNumerico(auxS)){
			try{
				Integer.parseInt(auxS);
			}
			catch (NumberFormatException nfe){
				System.out.println("Inserte un numero valido");
				auxS = scan.nextLine();
			}
		}
		resul = Integer.parseInt(auxS);
		return resul;
	}
	
	/*
	 * Comprueba si el String que se recibe es parseable a int
	 */
	private boolean esNumerico(String cadena){
		try{
			Integer.parseInt(cadena);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}
	
	/*
	 * Recoge por teclado un String
	 */
	public String recogerString(){
		String auxS = null;
		auxS = scan.nextLine();
		return auxS.toUpperCase();
	}

	/*
	 * Cierra la recepcion del scanner
	 */
	public void cerrarScanner(){
		this.scan.close();
	}
	
	/*
	 * Recoge por teclado un 'si' o un 'no'. Unicamente.
	 * En caso de que se equivoque, coge otro.
	 */
	public boolean recogerSiOno(){
		System.out.println("Introduzca SI/NO");

		String auxS = null;
		auxS = scan.nextLine();
		boolean flag = false;
		if (auxS.equalsIgnoreCase("si")){
			flag = true;
		}
		else if (auxS.equalsIgnoreCase("no")){
			flag = false;
		}
		else{
			while(!auxS.equalsIgnoreCase("si") && !auxS.equalsIgnoreCase("no")){
				System.out.println("Caracter invalido. Introduzca SI/NO");
				auxS = scan.nextLine();
			}
			if (auxS.equalsIgnoreCase("si")){
				flag = true;
			}
		}
		return flag;
	}
}
