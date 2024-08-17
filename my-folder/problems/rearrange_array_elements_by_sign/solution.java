class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> arrPositive = new ArrayList<Integer>();
        List<Integer> arrNegative = new ArrayList<Integer>();
        int[] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                arrPositive.add(nums[i]);
            } else if(nums[i] < 0){
                arrNegative.add(nums[i]);
            }
        }
        boolean start = true;
        int i = 0; 
        int j = 0;
        int k = 0;
        answer[0] = arrPositive.get(j);
        j++;
        i++;
        while(i < nums.length){
            if(answer[i - 1] > 0){
                answer[i] = arrNegative.get(k);
                k++;
            } else if(answer[i - 1] < 0){
                answer[i] = arrPositive.get(j);
                j++;
            }
            i++;
        }
        return answer;
    }
}