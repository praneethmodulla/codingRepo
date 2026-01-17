class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2]; 
        h[0] = 1; 
        h[1] = m;
        int[] v = new int[vFences.length + 2]; 
        v[0] = 1; 
        v[1] = n;
        for(int i = 0; i < hFences.length; i++){
            h[i + 2] = hFences[i];
        }
        for(int i = 0; i < vFences.length; i++){
            v[i + 2] = vFences[i];
        }
        Arrays.sort(h);
        Arrays.sort(v);
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i < h.length; i++){
            for(int j = i + 1; j < h.length; j++){
                set.add((long)(h[j] - h[i]));
            }
        }
        long maxSide = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < v.length; i++){
            for(int j = i + 1; j < v.length; j++){
                long side = v[j] - v[i];
                if(set.contains(side)){
                    maxSide = Math.max(maxSide, side);
                }
            }
        }
        if(maxSide == 0){
            return -1;
        }
        return (int)((maxSide * maxSide) % mod);
    }
}