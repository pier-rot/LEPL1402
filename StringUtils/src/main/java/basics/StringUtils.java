package basics;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtils {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(split("A.bcd.e.", '.')));
        System.out.println(Arrays.toString(split("Abcdef", '.')));
    }

    /**
     * Split a string according to a delimiter
     *
     * @param str       The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     * between two consecutive occurence of the delimiter.
     * If there is no occurence of the delimiter, it should
     * return an array of size 1 with the string at element 0
     */
    public static String[] split(String str, char delimiter) {
        int strLength = str.length();
        ArrayList<String> words = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) != delimiter) {
                temp += str.charAt(i);
            } else {
                words.add(temp);
                temp = "";
            }

        }
        words.add(temp);

        int size = words.size();
        String [] result = new String[size];
        result = words.toArray(result);

        return result;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     * the substring in str or -1 if sub does not appear
     * in str
     */
    public static int indexOf(String str, String sub) {
        int index = -1;
        int strLen = str.length();
        int subLen = sub.length();

        for (int i = 0; i < strLen - subLen; i++) {
            boolean found = false;
            for (int j = 0; j < subLen; j++) {

            }

            if (found) {
                break;
            }


        }

        return index;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     * character put to lower case.
     */
    public static String toLowerCase(String str) {
        return null;
    }


    /**
     * Check if a string is a palyndrome
     * <p>
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str) {
        boolean pal = true;
        int halfStrLen = str.length()/2;
        for (int i = 0; i < halfStrLen; i++) {
            if (str.charAt(i) != str.charAt(str.length()-(i+1) )) {
                pal = false;
                break;
            }
        }
        return pal;
    }

}