package algo.external.gfg.bit_masking;

public class CheckSquareNumber {

    public static void main(String[] args) {
        System.out.println(isSquareNumber(63));
        System.out.println(isSquareNumber(64));
    }

    private static boolean isSquareNumber(int number) {
        return (number & (number - 1)) == 0;
    }
}
