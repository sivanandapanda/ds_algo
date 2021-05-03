package algo.external.gfg.lcs;

public class RecursiveLcs {

    public static void main(String[] args) {
        //String str1 = "BATD";
        //String str2 = "ABACD";

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }

    private static int lcs(String str1, String str2, int n, int m) {
        int result = 0;
        if(n == 0 || m == 0) {
            result = 0;
        } else if (str1.charAt(n-1) == str2.charAt(m-1)) {
            result = 1 + lcs(str1, str2, n-1, m-1);
        } else if (str1.charAt(n-1) != str2.charAt(m-1)) {
            int temp1 = lcs(str1, str2, n-1, m);
            int temp2 = lcs(str1, str2, n, m-1);
            result = Math.max(temp1, temp2);
        }

        return result;
    }
}
