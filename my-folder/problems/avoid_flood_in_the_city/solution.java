class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> set = new TreeSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < rains.length; i++){
            if(rains[i] > 0){
                if(map.containsKey(rains[i])){
                    Integer idx = set.ceiling(map.get(rains[i]));
                    if(idx == null){
                        return new int[0];
                    }
                    ans[idx] = rains[i];
                    set.remove(idx);
                }
                map.put(rains[i], i);
                ans[i] = -1;
            } else if(rains[i] == 0){
                set.add(i);
            }
        }
        
        return ans;
    }
}