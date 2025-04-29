class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;
        long total = 0;
        for(int i = 0; i < nums.length; i++){
            maxElement = Math.max(nums[i], maxElement);
            total += i + 1;
        }
        int left = 0;
        int right = 0;
        long count = 0;
        int cnt = 0;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == maxElement){
                cnt += 1;
            }
            while(cnt >= k){
                if(nums[left] == maxElement){
                    cnt--;
                }
                left++;
            }
            if(cnt < k){
                count += right - left + 1;
            }
        }
        return total - count;
    }
}