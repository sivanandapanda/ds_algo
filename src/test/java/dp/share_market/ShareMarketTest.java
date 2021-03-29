package dp.share_market;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShareMarketTest {

    @Test
    void test() {
        int[] priceArray = {8, 1, 2, 4, 6, 3};

        ShareMarket shareMarket = new ShareMarket(priceArray);

        assertEquals(5, shareMarket.maxProfit());
    }

}