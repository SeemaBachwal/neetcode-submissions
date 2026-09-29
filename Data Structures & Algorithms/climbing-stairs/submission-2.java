class Solution {
    public int climbStairs(int n) {

        if(n == 1) return n;

        int stepOne = 1;
        int stepTwo = 1;

        for(int idx = 2; idx <= n; idx++){

            int sum = stepOne + stepTwo;
            stepOne = stepTwo;
            stepTwo = sum;
        }

        return stepTwo;
        
    }
}
