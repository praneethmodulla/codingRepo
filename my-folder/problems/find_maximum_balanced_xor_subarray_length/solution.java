class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int xor = 0;
        int balance = 0;
        int len = 0;
        map.put(xor + " " + balance, -1);
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
            if(nums[i] % 2 == 0){
                balance++;
            } else {
                balance--;
            }
            String key = xor + " " + balance;
            if(map.containsKey(key)){
                len = Math.max(len, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return len;
    }
}