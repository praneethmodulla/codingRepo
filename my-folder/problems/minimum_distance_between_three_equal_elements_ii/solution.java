class Solution {
    public int minimumDistance(int[] nums) {
        int ans = -1;
        HashMap<Integer, List<Integer>> hMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(hMap.containsKey(nums[i])){
                hMap.get(nums[i]).add(i);
            } else {
                List<Integer> heap = new ArrayList<Integer>();
                heap.add(i);
                hMap.put(nums[i], heap);
            }
        }
        for(int i : hMap.keySet()){
            if(hMap.get(i).size() < 3){
                continue;
            } else {
                int dist = Integer.MAX_VALUE;
                for(int j = 0; j < hMap.get(i).size() - 2; j++){
                    dist = Math.min(Math.abs(hMap.get(i).get(j) - hMap.get(i).get(j + 1)) + Math.abs(hMap.get(i).get(j + 1) - hMap.get(i).get(j + 2)) + Math.abs(hMap.get(i).get(j + 2) - hMap.get(i).get(j)), dist);
                }
                if(ans == -1 || ans > dist){
                    ans = dist;
                }
            }
        }
        return ans;
    }
}