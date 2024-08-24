class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(k > bloomDay.length){
            return -1;
        }
        if(m > bloomDay.length){
            return -1;
        }
        int minDays = Integer.MAX_VALUE;
        int maxDays = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(maxDays < bloomDay[i]){
                maxDays = bloomDay[i];
            }
            if(minDays > bloomDay[i]){
                minDays = bloomDay[i];
            }
        }
        if(m == bloomDay.length && k == 1){
            return maxDays;
        }
        int low = minDays;
        int high = maxDays;
        int mid = 0;
        int ans = -1;
        while(low <= high){
            mid = (low + high)/2;
            int num = reqBo(mid, bloomDay, k);
            if(num >= m){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int reqBo(int mid, int[] bloomDay, int k){
        int totalBoquets = 0;
        int[] cons = new int[bloomDay.length];
        for(int i = 0; i < bloomDay.length; i++){
            if(mid >= bloomDay[i]){
                cons[i] = 1;
            }
        }
        int left = 0;
        int right = 0;
        for(right = 0; right < cons.length; right++){
            if(cons[right] != 1){
                int len = 0;
                if(left == 0){
                    len = right;
                } else {
                    len = right - left - 1;
                }
                totalBoquets += len/k;
                left = right;
            }
        }
        int len = 0;
        if(left == 0){
            len = right;
        } else {
            len = right - left - 1;
        }
        totalBoquets += len/k;
        return totalBoquets;
    }
}