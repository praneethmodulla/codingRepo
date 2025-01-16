class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len2%2 == 0) && (len1%2 == 1)){
            int ans = 0;
            for(int i = 0; i < nums2.length; i++){
                ans = ans ^ nums2[i];
            }
            return ans;
        } else if((len2 % 2 == 1) && (len1 % 2 == 0)){
            int ans = 0;
            for(int i = 0; i <nums1.length; i++){
                ans = ans ^ nums1[i];
            }
            return ans;
        } else if((len2 % 2 == 0) && (len1 % 2 == 0)){
            return 0;
        } else {
            int xorVal = 0; 
            for(int i = 0; i < nums2.length; i++){
                xorVal = xorVal ^ nums2[i];
            }
            int ans = 0;
            for(int i =0; i < nums1.length; i++){
                ans = ans ^ nums1[i] ^ xorVal;
            }
            return ans;
        }
    }
}