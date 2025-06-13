class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(i < nums.length){
            if(nums[i] < pivot){
                res[j] = nums[i];
                j++;
            }
            if(nums[i] == pivot){
                cnt++;
            }
            i++;
        }
        while(cnt > 0 && j < nums.length){
            res[j] = pivot;
            j++;
            cnt--;
        }
        i = 0;
        while(i < nums.length && j <nums.length){
            if(nums[i] > pivot){
                res[j] = nums[i];
                i++;
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}