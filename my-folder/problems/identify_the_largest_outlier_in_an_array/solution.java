class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int check = sum - nums[i];
            if(check%2 == 1 || check%2 == -1){
                continue;
            } else {
                check = check/2;
                if(hMap.containsKey(check)){
                    if(check == nums[i]){
                        if(hMap.get(check) - 1 != 0){
                            if(ans < nums[i]){
                                ans = nums[i];
                            }
                        }
                    } else {
                        if(ans < nums[i]){
                            ans = nums[i];
                        }
                    }
                }
            }
        }
        return ans;
    }
}