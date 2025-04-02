class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long time = 1;
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        for(int i = 0; i < tasks.length; i++){
            if(map.containsKey(tasks[i])){
                if(time > map.get(tasks[i]) + space){
                    map.put(tasks[i], time);
                    time++;
                } else {
                    time = map.get(tasks[i]) + space + 1;
                    map.put(tasks[i], time);
                    time++; 
                }
            } else {
                map.put(tasks[i], time);
                time++;
            }
        }
        return time - 1;
    }
}