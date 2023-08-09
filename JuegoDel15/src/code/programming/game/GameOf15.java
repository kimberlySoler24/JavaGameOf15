package code.programming.game;

import java.util.Arrays;
import java.util.Random;

public class GameOf15 {

	
	//JUEGO DEL 15
	// ATRIBUTO
	private String[][] matrix;

	public String[][] matrix() {
		return this.matrix;
	}

	// CONSTRUCTOR
	public GameOf15() {
		Random random = new Random();
		this.matrix = new String[][] { { "01", "02", "03", "04" }, 
			                           { "05", "06", "07", "08" },
				                       { "09", "10", "11", "12" }, 
				                       { "13", "14", "15", "  " } };
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

	public String foundIfSelectNumberCanUse(String number) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == "  ") {
					var beforeI = i - 1;
					var afterI = i + 1;
					var beforeJ = j - 1;
					var afterJ = j + 1;
					if (beforeI >= 0) {
						if (matrix[beforeI][j].equals(number)){
							return changeSpaceToNumberSelect(number);
						}
					}
					if (afterI <= matrix.length - 1) {
						if (matrix[afterI][j].equals(number)){
							return changeSpaceToNumberSelect(number);
						}
					}
					if (beforeJ >= 0) {
						if (matrix[i][beforeJ].equals(number)){
							return changeSpaceToNumberSelect( number);
						}
					}
					if (afterJ <= matrix.length - 1) {
						if (matrix[i][afterJ].equals(number)){
							return changeSpaceToNumberSelect(number);
						}
					}
				}
			}
		}
		return "El numero invalido, intente nuevamente";
	}

	public String changeSpaceToNumberSelect(String number) {
		var copyOfMatrix = Arrays.copyOf(matrix, matrix.length);
		for (int i = 0; i < copyOfMatrix.length; i++) {
			for (int j = 0; j < copyOfMatrix[i].length; j++) {
				if (copyOfMatrix[i][j].equals("  ")) {
					copyOfMatrix[i][j] = number;
				} else {
					if (copyOfMatrix[i][j].equals(number)) {
						copyOfMatrix[i][j] = "  ";
					}
				}
			}
		}
		return matrixToString(copyOfMatrix);
	}
	
	public String ascendingOrderMatrix() {
		var ascendingOrderMatrix = new String[][] { { "01", "02", "03", "04" }, 
            { "05", "06", "07", "08" },
            { "09", "10", "11", "12" }, 
            { "13", "14", "15", "  " } };
        return matrixToString(ascendingOrderMatrix);
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
