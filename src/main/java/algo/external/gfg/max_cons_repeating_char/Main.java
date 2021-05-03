package algo.external.gfg.max_cons_repeating_char;

public class Main {

    public static void main(String[] args) {
        String testString = "geeekkkkeeeee";
        System.out.println(find(testString));
    }

    private static char find(String testStr) {
        char prevChar = testStr.charAt(0);

        int maxLength = 1;
        int currentLength = 1;
        char charWithMaxLength = prevChar;

        for (int i = 1; i < testStr.length(); i++) {
            var currentChar = testStr.charAt(i);
            if(currentChar == prevChar) {
                currentLength++;

                if(currentLength > maxLength) {
                    charWithMaxLength = currentChar;
                    maxLength = currentLength;
                }
            } else {
              prevChar = currentChar;
              currentLength = 1;
            }
        }

        return charWithMaxLength;
    }

}
