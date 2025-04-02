class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxCount = 0;
        int maximum = 0;
        for(int i = 0; i < tasks.length; i++){
            freq[tasks[i] - 'A']++;
            if(maximum < freq[tasks[i] - 'A']){
                maximum = freq[tasks[i] - 'A'];
                maxCount = 1;
            } else if(maximum == freq[tasks[i] - 'A']){
                maxCount++;
            }
        }
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maximum * maxCount); 
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}