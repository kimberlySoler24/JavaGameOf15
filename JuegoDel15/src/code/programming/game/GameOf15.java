package code.programming.game;

import java.util.Arrays;
import java.util.Random;

public class GameOf15 {

	// ATRIBUTO
	private String[][] matrix;

	public String[][] matrix() {
		return this.matrix;
	}

	// CONSTRUCTOR
	public GameOf15() {
		Random random = new Random();
		this.matrix = new String[][] { { "01", "02", "03", "04" }, { "05", "06", "07", "08" },
				{ "09", "10", "11", "12" }, { "13", "14", "15", "  " } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int row = random.nextInt(3);
				int col = random.nextInt(3);
				String valueMatrix = matrix[row][col];
				matrix[row][col] = matrix[i][j];
				matrix[i][j] = valueMatrix;

			}
		}
	}

	public String matrixToString(String[][] showMatrix) {
		var builder = new StringBuilder();
		for (String[] fila : showMatrix) {
			for (String columna : fila) {
				builder.append('[');
				builder.append(columna);
				builder.append(']');
			}
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

	public boolean foundIfSelectNumberCanUse(String number) {
		var correctNumber = false;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == "  ") {
					if (row - 1 >= 0 && matrix[row - 1][col].equals(number) 
						|| row + 1 <= matrix.length - 1 && matrix[row + 1][col].equals(number)
						|| col - 1 >= 0 && matrix[row][col - 1].equals(number)
						|| col + 1 <= matrix.length - 1 && matrix[row][col + 1].equals(number)) {
						correctNumber = true;
					}
				}
			}
		}
		return correctNumber;
	}

	public void changeSpaceToNumberSelect(String number) {
		var copyOfMatrix = Arrays.copyOf(matrix, matrix.length);
		for (int row = 0; row < copyOfMatrix.length; row++) {
			for (int col = 0; col < copyOfMatrix[row].length; col++) {
				if (copyOfMatrix[row][col].equals("  ")) {
					copyOfMatrix[row][col] = number;
				} else {
					if (copyOfMatrix[row][col].equals(number)) {
						copyOfMatrix[row][col] = "  ";
					}
				}
			}
		}
		System.out.println(matrixToString(copyOfMatrix));
	}

	public boolean ascendingOrderMatrix() {
		var correctOrder = false;
		var orderMatrix = new String[][] { { "01", "02", "03", "04" }, 
													{ "05", "06", "07", "08" },
													{ "09", "10", "11", "12" }, 
													{ "13", "14", "15", "  " } };
		if (orderMatrix.equals(matrix)) {
			correctOrder = true;
		} 
		return correctOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameOf15 other = (GameOf15) obj;
		return Arrays.deepEquals(matrix, other.matrix);
	}

}
