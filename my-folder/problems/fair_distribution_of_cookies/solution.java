class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        return recurse(0, distribute, cookies, k, k);
    }

    public int recurse(int idx, int[] distribute, int[] cookies, int k, int zeroCount){
        if(cookies.length - idx < zeroCount){
            return Integer.MAX_VALUE;
        }
        if(idx == cookies.length){
            int unfairness = Integer.MIN_VALUE;
            for(int i : distribute){
                unfairness = Math.max(unfairness, i);
            }
            return unfairness;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            if(distribute[i] == 0){
                zeroCount -= 1;
            }
            distribute[i] += cookies[idx];
            ans = Math.min(ans, recurse(idx + 1, distribute, cookies, k, zeroCount));

            distribute[i] -= cookies[idx];
            if(distribute[i] == 0){
                zeroCount += 1;
            }
        }
        return ans;
    }
}