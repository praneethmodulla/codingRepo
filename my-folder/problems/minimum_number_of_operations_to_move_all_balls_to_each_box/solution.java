class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                set.add(i);
            }
        }
        for(int i = 0; i < ans.length; i++){
            for(int idx : set){
                ans[i] += Math.abs(i - idx);
            }
        }
        return ans;
    }
}