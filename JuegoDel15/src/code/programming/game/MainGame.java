package code.programming.game;

import java.util.Scanner;


public class MainGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try (Scanner in = new Scanner(System.in)) {
				System.out.println("Bienvenido al juego del 15 donde tendrás como objetivo organizar los números del 1 al 15\n"
						+ "en orden ascendente en la matriz");
				var finish = "";
				var game = new GameOf15();
				System.out.println(game.matrixToString(game.matrix()));
				System.out.println("Escribe el número que quieres mover de posición:");
				String guess = in.nextLine();
				while (finish != "JUEGO COMPLETADO") {
					System.out.println(game.foundIfSelectNumberCanUse(guess));
					System.out.println("Escribe el número que quieres mover de posición:");
					guess = in.nextLine();
					if (game.foundIfSelectNumberCanUse(guess).equals(game.ascendingOrderMatrix())) {
						finish = "JUEGO COMPLETADO";
						System.out.println(finish);
					}
					System.out.println(game.foundIfSelectNumberCanUse(guess));
				}
			}
		}

}
