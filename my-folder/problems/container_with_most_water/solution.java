class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            int minHeight = Math.min(height[i], height[j]);
            int len = j - i;
            if(maxArea < minHeight * len){
                maxArea = minHeight * len;
            }
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}