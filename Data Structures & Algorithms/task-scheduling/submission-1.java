class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];


        int maxFreq = 0;


        // Step 1: Count frequency and find max frequency in a single pass
        for (char task : tasks) {
            charCount[task - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[task - 'A']);

        }

        System.out.println("maxFreq = : "+ maxFreq);

        // Step 2: Calculate initial idle slots based on max frequency
        int idleTime = (maxFreq - 1) * n;

        System.out.println("idleTime = : "+ idleTime);

        // Step 3: Subtract available task slots without sorting
        boolean skippedOneMax = false;
        for (int count : charCount) {
            if (count == 0) continue;

            // Skip the first task instance that matches maxFreq (it created the gaps)
            if (count == maxFreq && !skippedOneMax) {
                skippedOneMax = true;
                continue;
            }

            // Reduce idle time by the number of slots this task can fill
            idleTime -= Math.min(maxFreq - 1, count);
        }

        return tasks.length + Math.max(idleTime, 0);

    }
}
