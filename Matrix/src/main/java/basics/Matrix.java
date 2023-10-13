package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     * <p>
     * The string if formatted as follow:
     * - Each row of the matrix is separated by a newline
     * character \n
     * - Each element of the rows are separated by a space
     *
     * @param s The input String
     * @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] row = s.split("\n");
        int[][] result = new int[row.length][];
        for (int i = 0; i < row.length; i++) {
            String[] numb = row[i].split(" ");
            result[i] = new int[numb.length];
            for (int j = 0; j < numb.length; j++) {
                result[i][j] = Integer.parseInt(numb[j]);
            }
        }
        return result;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int m = matrix1[0].length;
        int k = matrix2[0].length;

        int[][] matrix3 = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int h = 0; h < m; h++) {
                    matrix3[i][j] += matrix1[i][h] * matrix2[h][j];
                }
            }
        }
        return matrix3;
    }
}