package dp.share_market;

public class ShareMarket {

    private final int days;
    private final int[] price;

    public ShareMarket(int[] price) {
        this.price = price;
        this.days = this.price.length;
    }

    public int maxProfit() {
        int[] profit = new int[days];
        int[] minUptil = new int[days];

        int highestProfit = Integer.MIN_VALUE;
        minUptil[0] = price[0];

        for (int i = 1; i < days; i++) {
            minUptil[i] = Math.min(minUptil[i-1], price[i]);
        }

        for (int i = 1; i < days; i++) {
            profit[i] = price[i] - minUptil[i];

            highestProfit = Math.max(highestProfit, profit[i]);
        }

        return highestProfit;
    }
}
