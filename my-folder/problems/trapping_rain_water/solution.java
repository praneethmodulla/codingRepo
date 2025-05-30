class Solution {
    public int trap(int[] height) {
        int[] nge = new int[height.length];
        int[] pge = new int[height.length];
        pge[0] = height[0];
        for(int i = 1; i < height.length; i++){
            pge[i] = Math.max(pge[i - 1], height[i]);
        }
        nge[height.length - 1] = height[height.length - 1];
        for(int j = height.length - 2; j >= 0; j--){
            nge[j] = Math.max(nge[j + 1], height[j]);
        } 
        int area = 0;
        for(int i = 1; i < height.length - 1; i++){
            area += Math.min(pge[i], nge[i]) - height[i];
        }
        return area;
    }
}