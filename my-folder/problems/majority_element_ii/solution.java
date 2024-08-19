class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && el2 != nums[i]){
                cnt1++;
                el1 = nums[i];
            } else if(cnt2 == 0 && el1 != nums[i]){
                cnt2++;
                el2 = nums[i];
            } else if(el1 == nums[i]){
                cnt1++;
            } else if(el2 == nums[i]){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        //Chekc for majority
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(el1 == nums[i]) {
                cnt1++;
            }
            if(el2 == nums[i]){
                cnt2++;
            }
        }
        if(cnt1 > nums.length/3){
            res.add(el1);
        } 
        if(cnt2 > nums.length/3){
            res.add(el2);
        }
        return res;
    }
}