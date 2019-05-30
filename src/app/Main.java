package app;

import modelos.*;

public class Main {
	public static void main(String[] args) {
		Advinhar a1 = new Advinhar();
		System.out.println("Vamos Jogar Forca!!");
		System.out.println("0000000000000\n"
				+ "0           0\n"
				+ "0           1\n"
				+ "0          1 1\n"
				+ "0           1\n"
				+ "0          324\n"
				+ "0         3 2 4\n"
				+ "0        3  2  4\n"
				+ "0          5 6\n"
				+ "0         5   6\n"
				+ "0        5     6\n"
				+ "0       5       6\n"
				+ "0\n"
				+ "0"
				+ "0");
		a1.inicio();
	}
}
