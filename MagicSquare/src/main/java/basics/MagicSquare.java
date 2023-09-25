package basics;

import java.util.Arrays;

public class MagicSquare {
    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    public static boolean isMagicSquare(int[][] matrix) {
        // TODO Implement the body of this method, feel free to add other methods but do not change the signature of isMagiSquare
        int magicNumber = arraySum(matrix[0]);
        boolean isMagic = true;
        // Determine whether it is square or not
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }
        }

        // Determine whether the sum of numbers on both diagonals is equal to the magic number
        int[] diag1 = new int[matrix.length];
        int[] diag2 = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            diag1[i] = matrix[i][i];
            diag2[i] = matrix[matrix.length - 1 - i][i];
        }

        if (arraySum(diag1) != magicNumber || arraySum(diag2) != magicNumber) {
            return false;
        }

        // Determine whether the sum of each row and colum is equal to the magic number
        for (int i = 0; i < matrix.length; i++) {
            if (arraySum(matrix[i]) != magicNumber) {
                return false;
            }
            int[] col = new int[matrix.length];
            for (int j = 0; j < matrix[i].length; j++) {
                col[j] = matrix[j][i];
            }
            System.out.println(Arrays.toString(col));
            if (arraySum(col) != magicNumber) {
                return false;
            }
        }
        int[] content = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, content, i * matrix.length + 0, matrix[i].length);

        }
        Arrays.sort(content);

        for (int i = 0; i < content.length; i++) {
            if (content[i] != i + 1) {
                return false;
            }
        }

        return isMagic;
    }

    public static int arraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}

