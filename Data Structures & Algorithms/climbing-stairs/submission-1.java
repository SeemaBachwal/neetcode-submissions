class Solution {
    public int climbStairs(int n) {

        if(n == 1) return n;

        int[] climbWays = new int[n+1];

        climbWays[0] = 1;
        climbWays[1] = 1;


        for(int idx = 2; idx <= n; idx++){

            climbWays[idx] = climbWays[idx-1] + climbWays[idx-2];
        }

        return climbWays[n];
        
    }
}
