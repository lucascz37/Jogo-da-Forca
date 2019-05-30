package modelos;

import java.util.Scanner;
public class DadosTeclado {

static Scanner entrada = new Scanner(System.in);

	public static String pegaString() {
		String saida = entrada.nextLine();
		return saida;
	}
	public static int pegaInt() {
		int saida = 0;
		boolean errado = true;
		while (errado) {
			try{
				saida = Integer.parseInt(entrada.nextLine());
				errado = false;
			}catch(NumberFormatException e) {
				System.out.print("VOCÊ SABE O QUE É UM NÚMERO?!Digite Novamente:");
			}
		}
		return saida;
	}

}

