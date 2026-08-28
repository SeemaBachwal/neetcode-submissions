class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currProfit = 0, buyingPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (buyingPrice > prices[i]) {
                buyingPrice = prices[i];
            }

            currProfit = prices[i] - buyingPrice;

            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }

        return maxProfit;
    }
}
