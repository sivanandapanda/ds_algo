package algo.external.udemy;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {2,3,1,4,2,3,4};
        new DuplicatesInArray().findWhenValuesAreSmallerThanLengthOfTheArray(arr);
    }

    public void findWhenValuesAreSmallerThanLengthOfTheArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[Math.abs(array[i])] > 0) {
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            } else {
                System.out.println(Math.abs(array[i]) + " is repetition");
            }
        }
    }

}
