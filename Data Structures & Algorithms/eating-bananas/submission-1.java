class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            if (high < pile) {
                high = pile;
            }
        }

        int minRate = high;

        while (low <= high) {
            int k = low + (high - low) / 2;

            long totalTime = 0;

            for (int pile : piles) {
                totalTime += (pile + k - 1) / k;
            }

            if (totalTime <= h) {
                minRate = k;
                high = k - 1;

            } else {
                low = k + 1;
            }
        }

        return minRate;
    }
}
