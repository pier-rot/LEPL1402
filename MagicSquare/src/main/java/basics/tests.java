package basics;

import java.util.Arrays;

public class tests {
    public static void main(String[] args) {
        int [][] matrix = {
                {1, 3, 2, 34, 35, 36},
                {4, 19, 28, 26, 5, 29},
                {10, 30, 27, 6, 24, 14},
                {31, 23, 15, 22, 13, 7},
                {32, 16, 18, 12, 25, 8},
                {33, 21, 20, 11, 9, 17}};

        System.out.println(MagicSquare.isMagicSquare(matrix));
        int [] content = new int[matrix.length * matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                content[i*matrix.length + j] = matrix[i][j];
            }

        }
        Arrays.sort(content);
        System.out.println(Arrays.toString(content));
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(MagicSquare.arraySum(matrix[i]));
        }
        int [][] transpose = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
        for (int i = 0; i < transpose.length; i++) {
            System.out.println(MagicSquare.arraySum(transpose[i]));
        }
    }

}
