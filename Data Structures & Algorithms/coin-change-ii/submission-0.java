class Solution {
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];

        combinations[0] = 1;

        for (int coin : coins) {
            for (int curr = coin; curr <= amount; curr++) {
                combinations[curr] += combinations[curr - coin];
            }
        }

        return combinations[amount];
    }
}
