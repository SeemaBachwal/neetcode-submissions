class Solution {
    int max = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int minCoins[] = new int[amount + 1];

        Arrays.fill(minCoins, Integer.MAX_VALUE);

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

        if (minCoins[amount] == max) {
            return -1;
        }

        return minCoins[amount];
    }
}
