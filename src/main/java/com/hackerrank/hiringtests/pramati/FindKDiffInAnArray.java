public class FindKDiffInAnArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 9, 12, 10, 11};
        //int[] array = {1, 2, 3, 4, 5};
        int diff = 2;
        int matchingPairs = 0;
        for (int[] pair : generateUniquePairs(array)) {
            if (Math.abs(pair[0] - pair[1]) == diff) {
                matchingPairs++;
                System.out.println(pair[0] + ":" + pair[1]);
            }
        }
        System.out.printf("Total pairs whose diff is %d is %d", diff, matchingPairs);
    }

    /**
     * Table below is mapping from total Numbers in an array vs Total Unique pairs that could be
     * formed from that array. The formula is simply NC2 which is N * (N - 1) / 2. N being the total
     * numbers in the array and 2 being the number of numbers required to form a pair.
     * <p>
     * 2 - 1
     * 3 - 3
     * 4 - 6
     * 5 - 10
     * 6 - 15
     * 7 - 21
     * 8 - 28
     * 9 - 36
     * 10 - 45
     * 11 - 55
     * 12 - 66
     * 13 - 78
     * 14 - 91
     * 15 - 105
     * 16 - 120
     */

    private static int[][] generateUniquePairs(int[] array) {
        int totalPairCombinationCount = ((array.length) * (array.length - 1)) / 2;
        int[][] arrayOfPairs = new int[totalPairCombinationCount][2];
        int pairCounter = 0;
        for (int i = 0; i < (array.length - 1); i++) {
            for (int j = i + 1; j < array.length; j++) {
                arrayOfPairs[pairCounter][0] = array[i];
                arrayOfPairs[pairCounter][1] = array[j];
                pairCounter++;
            }
        }
        return arrayOfPairs;
    }
}
