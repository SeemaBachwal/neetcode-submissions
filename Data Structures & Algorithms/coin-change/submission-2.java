class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int minCoins[] = new int[amount + 1];

        int max = amount + 1;

        Arrays.fill(minCoins, max);

        minCoins[0] = 0;

        for (int actualAmount = 1; actualAmount <= amount; actualAmount++) {
            for (int coin : coins) {
                int remAmount = actualAmount - coin;

                if (remAmount >= 0 && minCoins[remAmount] != max) {
                    minCoins[actualAmount] =
                        Math.min(1 + minCoins[remAmount], minCoins[actualAmount]);
                }
            }
        }

        

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }
}
