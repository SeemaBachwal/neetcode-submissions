class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int pile : piles) {
            if (high < pile) {
                high = pile;
            }
        }

        int minRate = high;

        while (low <= high) {
            int k = (low + high) / 2;

            long totalTime = 0;

            for (int pile : piles) {
                totalTime += Math.ceil((double) pile / k);
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
