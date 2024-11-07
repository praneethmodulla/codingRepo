class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return recurse(nums, nums.length - 1, k, new ArrayList<Integer>());
    }

    public int recurse(int[] nums, int idx, int k, ArrayList<Integer> set){
        if(idx < 0 && set.size() != 0){
            return 1;
        } else if(idx < 0 && set.size() == 0){
            return 0;
        }
        int notTake = recurse(nums, idx - 1, k, set);
        int take = 0;
        if(set.size() == 0 || checkTake(nums[idx], set, k)){
            set.add(nums[idx]);
            take = recurse(nums, idx - 1, k, set);
            set.remove(set.size() - 1);
        }
        return take + notTake;
    }

    public boolean checkTake(int num, ArrayList<Integer> set, int k){
        for(int i = 0; i < set.size(); i++){
            if(Math.abs(num - set.get(i)) == k){
                return false;
            }
        }
        return true;
    }
}