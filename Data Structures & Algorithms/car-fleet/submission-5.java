class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairArr = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairArr[i][0] = position[i];
            pairArr[i][1] = speed[i];
        }

        Arrays.sort(pairArr, (a, b) -> b[0] - a[0]);

        int fleetCount = 0;
        double maxTime = 0.0;

        for (int[] pair : pairArr) {

            double time = (double) (target - pair[0])/pair[1];

            if(time > maxTime){
                maxTime = time;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
