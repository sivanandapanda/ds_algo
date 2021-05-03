package algo.external.leetcode.pair_with_sum;

public class PairSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 7, 11, 15};

        int sum = 15;

        System.out.println(find2P(arr, sum));

        //System.out.println(binarySearch(arr, 0, arr.length, 7));
    }

    private static String find2P(int[] arr, int sum) {
        int i = 0, r = arr.length-1;

        while ( i < r) {
            int temp = arr[i] + arr[r];

            if(temp == sum) {
                return arr[i] + " - " + arr[r];
            } else if(temp < sum) {
                i++;
            } else {
                r--;
            }
        }

        return "none";
    }

    private static String find(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            int residual = sum - arr[i];
            if(residual > 0) {
                int find = binarySearch(arr, 0, arr.length, residual);
                if(find != -1) {
                    return arr[i] + " - " + residual;
                }
            }
        }

        return "none";
    }

    private static int binarySearch(int[] arr, int startI, int endI, int find) {
        //System.out.printf("Start: %s End: %s%n", startI, endI);
        int index = (endI + startI) / 2;

        if (arr[index] == find) {
            return index;
        } else if (startI >= endI) {
            return -1;
        } else if (arr[index] > find && index != endI) {
            return binarySearch(arr, startI, index, find);
        } else if (arr[index] < find && index != startI) {
            return binarySearch(arr, index, endI, find);
        }

        return -1;
    }

}
