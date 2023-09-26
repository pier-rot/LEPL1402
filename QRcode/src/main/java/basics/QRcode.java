package basics;

import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 * <p>
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 * <p>
 * boolean [][] t0 = new boolean[][] {
 * {false,true,false,false},
 * {false,false,true,true},
 * {true,false,false,true},
 * {true,true,false,true}
 * };
 * <p>
 * // t2 is a version of t2 with two quarter rotations
 * boolean [][] t2 = new boolean[][] {
 * {true,false,true,true},
 * {true,false,false,true},
 * {true,true,false,false},
 * {false,false,true,false}
 * };
 */
public class QRcode {
    protected boolean[][] data;

    /**
     * Create a QR code object
     *
     * @param data is a n x n square matrix
     */
    public QRcode(boolean[][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     *
     * @param o the other matrix to compare to
     * @return
     */
    // @Override
    public boolean equals(QRcode o) {
        boolean isEqual = false;
        boolean[] unwrapedThis = unwrap(this.data);
        boolean[] unwrapedOther = unwrap(o.data);
        boolean[][] unwrapedThisTab = new boolean[4][unwrapedThis.length];

        unwrapedThisTab[0] = unwrapedThis;

        for (int i = 1; i < unwrapedThisTab.length; i++) {
            unwrapedThisTab[i] = rotate(unwrapedThisTab[i - 1]);
        }

        for (int i = 0; i < unwrapedThisTab.length; i++) {
            boolean same = false;
            for (int j = 0; j < unwrapedThisTab[i].length; j++) {
                if (unwrapedThisTab[i][j] == unwrapedOther[j]) {
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }

            if (same) {
                isEqual = true;
            }

        }
        return isEqual;
    }

    public static boolean[] unwrap(boolean[][] data) {
        int n = data.length;
        boolean[] unwraped = new boolean[n * n];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                unwraped[i * n + j] = data[i][j];
            }
        }
        return unwraped;
    }

    public static boolean[] rotate(boolean[] tab) {
        boolean[] rotated = new boolean[tab.length];
        int n = Math.round((int) Math.sqrt(tab.length));
        for (int i = 0; i < tab.length; i++) {
            rotated[i] = tab[(i % n + 1) * n - i / n - 1];
        }

        return rotated;
    }

}

