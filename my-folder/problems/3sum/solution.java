class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int target = 0 - nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    if(nums[j] + nums[k] == target){
                        List<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        result.add(res);
                        j++;
                        k--;
                        while(j < nums.length && nums[j - 1] == nums[j]){
                            j++;
                        }
                        while(k >= 0 && nums[k + 1] == nums[k]){
                            k--;
                        }
                    } else if(nums[j] + nums[k] > target){
                        k--;
                    } else if(nums[j] + nums[k] < target){
                        j++;
                    }
                }
            }
        }
        return result;
    }
}