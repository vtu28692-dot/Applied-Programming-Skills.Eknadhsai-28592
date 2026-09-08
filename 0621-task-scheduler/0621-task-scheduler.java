class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        int maxFreqCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        // Calculate intervals needed based on max frequency task frame
        int intervals = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // If tasks exceed the calculated frame size, total tasks size is the lower bound
        return Math.max(intervals, tasks.length);
    }
}