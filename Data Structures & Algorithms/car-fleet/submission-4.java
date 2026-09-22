class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeToTarget = new double[target + 1];

        for (int i = 0; i < position.length; i++) {
            timeToTarget[position[i]] = (double) (target - position[i]) / speed[i];
        }

        int fleetCount = 0;
        double maxTime = 0.0;

        for (int i = target; i >= 0; i--) {
            if (timeToTarget[i] > maxTime) {
                maxTime = timeToTarget[i];
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
