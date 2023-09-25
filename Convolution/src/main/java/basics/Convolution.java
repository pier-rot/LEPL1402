package basics;

public class Convolution {

    /**
     *
     * @param input is a n1 x m1 non-null rectangular matrix with at least 3 rows and 3 cols
     * @param kernel is a 3 x 3 square matrix
     * @return a matrix M with dimension (n1-2) x (m1-2) with
     *         M[i][j] = sum_{k in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
     */
    public static int [][] convolution(int [][] input, int [][] kernel) {
        int inputRows = input.length;
        int inputCols = input[0].length;

        int kernelRows = kernel.length;
        int kernelCols = kernel[0].length;

        int [][] M = new int[inputRows - 2][inputCols - 2];

        for (int i = 0; i < inputRows - 2; i++) {
            for (int j = 0; j < inputCols - 2; j++) {
                int accumulator = 0;

                for(int k = 0; k < kernelRows; k++) {
                    for (int l = 0; l <kernelCols; l++) {
                        accumulator += input[i+k][j+l] * kernel[k][l];
                    }
                }
                M[i][j] = accumulator;
            }

        }

        return M;
    }
}
