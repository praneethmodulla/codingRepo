class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int completeTasks = 0;
        int low = 1;
        int high = Math.min(tasks.length, workers.length);
        while(low <= high){
            int mid = (low + high)/2;
            if(check(workers, tasks, pills, strength, mid)){
                completeTasks = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return completeTasks;
    }

    public boolean check(int[] workers, int[] tasks, int pills, int strength, int mid){
        TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>();
        for(int i = workers.length - mid; i < workers.length; i++){
            tMap.put(workers[i], tMap.getOrDefault(workers[i], 0) + 1);
        }
        for(int i = mid - 1; i >= 0; i--){
            Integer key = tMap.lastKey();
            if(key >= tasks[i]){
                tMap.put(key, tMap.get(key) - 1);
                if(tMap.get(key) == 0){
                    tMap.remove(key);
                }
            } else {
                if(pills == 0){
                    return false;
                }
                key = tMap.ceilingKey(tasks[i] - strength);
                if(key == null){
                    return false;
                }
                tMap.put(key,tMap.get(key) - 1);
                if(tMap.get(key) == 0){
                    tMap.remove(key);
                }
                pills--;
            }
        }
        return true;
    }
}