package basics;

import java.lang.reflect.Array;

public class testing {
    public static void main(String[] args) {
        String s = "1 2 3.1\n3 4 5";
        String[] lines = s.trim().split("\n");
        int rows = lines.length;
        int cols = lines[0].split(" ").length;
        int[][] matrix = new int[rows][cols];
        // System.out.println(rows + " " + cols);
        System.out.println(lines[0]);
        System.out.println(lines[1]);

        for (int i = 0; i < lines.length; i++) {

            for (int j = 0; j < lines[i].split(" ").length; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(lines[i].split(" ")[j]);
                } catch (NumberFormatException e) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{2}, {4}, {6}};

        int[][] product = product(matrix1, matrix2);
        System.out.println(product[0][0]);


    }

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
