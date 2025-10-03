class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while(i < j){
            area = Math.max(area, (j - i) * (Math.min(height[j], height[i])));
            int min = Math.min(height[i], height[j]);
            if(min == height[i]){
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}