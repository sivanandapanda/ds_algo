package algo.external.gfg.lcs;

public class MemoLcs {
    public static void main(String[] args) {
        String str1 = "BATD";
        String str2 = "ABACD";

        //String str1 = "AGGTAB";
        //String str2 = "GXTXAYB";

        int[][] cache = new int[str1.length()][str2.length()];

        System.out.println(lcs(str1, str2, str1.length(), str2.length(), cache));
    }

    private static int lcs(String str1, String str2, int n, int m, int[][] cache) {
        int result = 0;

        boolean isNotLastIndex = n != str1.length() || m != str2.length();

        if(n == 0 || m == 0) {
            result = 0;
        } else if(isNotLastIndex && cache[n][m] > 0) {
            return cache[n][m];
        } else if (str1.charAt(n-1) == str2.charAt(m-1)) {
            result = 1 + lcs(str1, str2, n-1, m-1, cache);
        } else if (str1.charAt(n-1) != str2.charAt(m-1)) {
            int temp1 = lcs(str1, str2, n-1, m, cache);
            int temp2 = lcs(str1, str2, n, m-1, cache);
            result = Math.max(temp1, temp2);
        }

        if(isNotLastIndex) {
            cache[n][m] = result;
        }
        return result;
    }
}
