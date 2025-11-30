class Solution {
    public int minSubarray(int[] nums, int p) {
        if(p == 1){
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i]) % p;
        }
        int target = sum % p;
        if(target == 0){
            return 0;
        }
        int modSum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remSum = 0;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            remSum = (remSum + nums[i]) % p;
            int needed = (remSum - target + p) % p;
            if(map.containsKey(needed)){
                len = Math.min(len, i - map.get(needed));
            }
            map.put(remSum, i);
        }
        if(len == nums.length){
            return -1;
        }
        return len;
    }
}