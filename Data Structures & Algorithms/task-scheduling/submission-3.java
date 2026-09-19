class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];

        int maxFreq = 0, maxCount = 0;

        for (char task : tasks) {
            charCount[task - 'A']++;

            if (charCount[task - 'A'] > maxFreq) {
                maxFreq = charCount[task - 'A'];
                maxCount = 1;

            } else if (charCount[task - 'A'] == maxFreq) {
                maxCount++;
            }
        }

        int totalTime = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, totalTime);
    }
}
