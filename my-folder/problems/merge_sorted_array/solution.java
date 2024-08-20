class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = 0;
        int j = 0;
        int[] ans = new int[m + n]; 
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                ans[k] = nums1[i];
                i++;
            } else if(nums1[i] > nums2[j]){
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(j < n){
            ans[k] = nums2[j];
            j++;
            k++;
        }
        while(i < m){
            ans[k] = nums1[i];
            i++;
            k++;
        }
        for(int z = 0; z < nums1.length; z++){
            nums1[z] = ans[z];
        }
        return;
    }
}