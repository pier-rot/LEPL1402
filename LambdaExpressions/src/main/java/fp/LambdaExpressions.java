package fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class LambdaExpressions {
    /**
     * Return a binary operator that computes the sum of two Integer objects.
     */
    public static Object sumOfIntegers() {
        return (BinaryOperator<Integer>) (a, b) -> a + b;
    }

    /**
     * Return a predicate that tests whether a String is empty.
     */
    public static Object isEmptyString() {
        Predicate<String> f = s -> (s.length() == 0 ? true : false);
        return f;
    }

    /**
     * Return a predicate that tests whether an Integer is an odd number.
     */
    public static Object isOddNumber() {
        Predicate<Integer> f = s -> (s % 2 == 0 ? false : true);
        return f;
    }

    /**
     * Return a function that computes the mean of a List of Double objects.
     * If the list is empty, an IllegalArgumentException must be thrown.
     */
    public static Object computeMeanOfListOfDoubles() {

        Function<List<Double>, Double> f = l -> {
            double sum = 0;
            int count = 0;
            for (Double elem : l) {
                sum += elem;
                count++;
            }
            if (count == 0) {
                throw new IllegalArgumentException();
            }
            return (sum / ((double) count));
        };
        return f;
    }

    /**
     * Remove the even numbers from a list of Integer objects.
     */
    public static void removeEvenNumbers(List<Integer> lst) {
        lst.removeIf(x -> x % 2 == 0);
    }

    /**
     * Return a function that computes the factorial of an Integer.
     * If the number is zero, the factorial equals 1 by convention.
     * If the number is negative, an IllegalArgumentException must be thrown.
     */
    public static Object computeFactorial() {
        Function<Integer, Integer> f = x -> {


            if (x < 0) {
                throw new IllegalArgumentException();
            }
            if (x == 0) {
                return 1;
            }

            int y = 1;
            for (int i = 2; i < x + 1; i++) {
                y *= i;
            }
            return y;
        };
        return f;
    }

    /**
     * Return a function that converts a list of String objects to lower case.
     */
    public static Object listOfStringsToLowerCase() {
        Function<List<String>, List<String>> f = l -> {
            List<String> lst = new ArrayList<>();

            for (String s : l) {
                lst.add(s.toLowerCase());
            }

            return lst;
        };
        return f;
    }

    /**
     * Return a function that concatenates two String objects.
     */
    public static Object concatenateStrings() {
        BinaryOperator<String> f = (s1, s2) -> s1 + s2;
        return f;
    }

    public static class MinMaxResult {
        private int minValue;
        private int maxValue;

        MinMaxResult(int minValue,
                     int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        int getMinValue() {
            return minValue;
        }

        int getMaxValue() {
            return maxValue;
        }
    }

    /**
     * Return a function that computes the minimum and maximum values in a list.
     * The content of the Optional must be present if and only if the list is non-empty.
     */
    public static Function<List<Integer>, Optional<MinMaxResult>> computeMinMax() {
        Function<List<Integer>, Optional<MinMaxResult>> f = l -> {

            if (l.isEmpty()) {
                return Optional.empty();
            }
            int min = l.get(0);
            int max = l.get(0);
            for (Integer i :
                    l) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }

            return Optional.of(new MinMaxResult(min, max));
        };
        return f;
    }

    /**
     * Return a function that, given a String object and a character, counts
     * the number of occurrences of the character inside the string.
     */
    public static Object countInstancesOfLetter() {

        BiFunction<String, Character, Integer> f = (s, c) -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
            return count;
        };
        return f;
    }
}
