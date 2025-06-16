class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] circle = new int[colors.length + k - 1];
        for(int i = 0; i < colors.length; i++){
            circle[i] = colors[i];
        }
        for(int i = 0; i < k - 1; i++){
            circle[colors.length + i] = colors[i];
        }
        int right = 0;
        int left = 0;
        int num = 0;
        for(right = 0; right < circle.length - 1; right++){
            if(right - left + 1 == k){
                num++;
                left++;
            }
            if(circle[right] == circle[right + 1]){
                left = right + 1;
            }
        }
        if(right - left + 1 == k){
            num++;
        }
        return num;
    }
}