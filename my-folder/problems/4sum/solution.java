class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                long sum = nums[i] + nums[j];
                int l = j + 1;
                int k = nums.length - 1;
                while(l < k){
                    long totalSum = sum + nums[l] + nums[k];
                    if(totalSum > target){
                        k--;
                    } else if(totalSum < target){
                        l++;
                    } else {
                        List<Integer> res= new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[l]);
                        res.add(nums[k]);
                        if(!result.contains(res)){
                            result.add(res); 
                        }
                        l++;
                        k--;
                        while(l < k && nums[l] == nums[l - 1]){
                            l++;
                        }
                        while(l < k && nums[k] == nums[k + 1]){
                            k--;
                        }
                    }
                }
            }
        }
        return result;
    }
}