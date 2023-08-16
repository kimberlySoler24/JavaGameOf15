package code.programming.game;

import java.util.Scanner;


public class MainGame {

	public static void main(String[] args) {
			try (Scanner in = new Scanner(System.in)) {
				System.out.println("Bienvenido al juego del 15 donde tendrás como objetivo organizar los números del 1 al 15\n"
						+ "en orden ascendente en la matriz");
				var finish = "";
				var game = new GameOf15();
				System.out.println(game.matrixToString(game.matrix()));
				System.out.println("Escribe el número que quieres mover de posición:");
				String guess = in.nextLine();
				while (finish != "JUEGO COMPLETADO") {
					if (game.foundIfSelectNumberCanUse(guess) == true) {
						game.changeSpaceToNumberSelect(guess);
						if(game.ascendingOrderMatrix() == true) {
							finish = "JUEGO COMPLETADO";
							System.out.println(finish);
						} else {
							System.out.println("Escribe el número que quieres mover de posición:");
						    guess = in.nextLine();
						}
					} else {
						System.out.println("numero invalido, intente nuevamente");
						System.lineSeparator();
						System.out.println("Escribe el número que quieres mover de posición:");
					    guess = in.nextLine();
					}

				}
			}
		}
}
