package challenge.gfg.bit_masking;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

//https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/
public class ReversingBits {

    public static void main(String[] args) {
        var input = 11;

        //method 1
        //System.out.println(convertToBinaryString(input));
        //System.out.println(reverseString(convertToBinaryString(input)));
        System.out.println(convertToInt(reverseString(convertToBinaryString(input))));

        //method 2
        System.out.println(reverseBits(input));
        /*var binaryString = Integer.toBinaryString(input);

        System.out.println(binaryString);

        //System.out.println(input >> 1);
        //System.out.println(input << 1);

        var reversedInput = convertToInt(reverseString(binaryString));
        System.out.println(reversedInput);

        System.out.println(Integer.toBinaryString(input >> 1));
        System.out.println(Integer.toBinaryString(input << 1));
        System.out.println(input >> 1);
        System.out.println(input << 1);
        System.out.println(input >> 2);
        System.out.println(input << 2);*/
        //System.out.println(Integer.toBinaryString(input >> 2));
        //System.out.println(Integer.toBinaryString(input << 1));
        //System.out.println(Integer.toBinaryString(input << 2));


        //System.out.println(binaryString);
        //System.out.println(reverseString(binaryString));
        //System.out.println(convertToInt(reverseString(binaryString)));
    }

    public static int reverseBits(int n){
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        while (n > 0)
        {
            // bitwise left shift
            // 'rev' by 1
            rev <<= 1;

            // if current bit is '1'
            if ((n & 1) == 1)
                rev ^= 1;

            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
    }

    private static String reverseString(String inputStr) {

        var startIndex = 0;
        var endIndex = inputStr.length()-1;

        var charArray = inputStr.toCharArray();

        while (startIndex < endIndex) {
            var temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return new String(charArray);
    }

    private static String convertToBinaryString(int input) {
        StringBuilder binaryRepresentation = new StringBuilder();

        int n = input;

        while (n > 0) {
            var remainder = n % 2;

            binaryRepresentation.insert(0, remainder + "");

            n = n / 2;
        }


        return binaryRepresentation.toString();
    }

    private static int convertToInt(String input) {
        var result = 0;

        for (int i = input.length()-1; i >= 0; i--) {
            result += parseInt(valueOf(input.charAt(i))) * Math.pow(2, input.length()-1 - i);
        }

        return result;
    }

}
