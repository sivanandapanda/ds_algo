package algo.external.gfg.bit_masking;

//https://practice.geeksforgeeks.org/problems/set-bits0143/1
public class NumberOfSetBits {

    public static void main(String[] args) {
        int input = 11;
        System.out.println("Answer: " + countSetBits(input));
        System.out.println(500 & (1 << 3));
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
