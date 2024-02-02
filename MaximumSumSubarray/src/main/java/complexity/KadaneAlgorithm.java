package complexity;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] array = {1, 1, 3, -10, 3, 4, -5, -3, 2, 1};
        int localMax = 0;
        int globalMax = 0;
        int tempStartIndex = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i] + localMax) {
                localMax = array[i];
                tempStartIndex = i;
            } else {
                localMax += array[i];
            }

            if (localMax > globalMax) {
                globalMax = localMax;
                startIndex = tempStartIndex;
                endIndex = i;
            }

//            localMax = Math.max(array[i], array[i] + localMax);
//            globalMax = Math.max(localMax, globalMax);
        }
        System.out.println(globalMax + "\nStart : " + startIndex + "\nEnd : " + endIndex);
    }
}
