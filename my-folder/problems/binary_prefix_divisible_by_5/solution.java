class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<Boolean>();
        System.out.println(nums.length);
        long number = 0;
        for(int i = 0; i < nums.length; i++){
            number = 2 * number + nums[i];
            if(number % 5 == 0){
                result.add(true);
            } else {
                result.add(false);
            }
            number = number % 5;
        }
        return result;
    }
}