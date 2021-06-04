package dp.burgler;

public class BurglarsNightOut {

    public int maxMoneyRobbed(int[] houses) {
        int n = houses.length;

        if(n==0) return 0;

        int[] maxMoney = new int[n+1];
        maxMoney[n] = 0;
        maxMoney[n-1] = houses[n-1];

        for (int i = n-2; i >= 0; i--) {
            maxMoney[i] = Math.max(houses[i] + maxMoney[i+2], maxMoney[i+1]);
        }

        return maxMoney[0];
    }

}
