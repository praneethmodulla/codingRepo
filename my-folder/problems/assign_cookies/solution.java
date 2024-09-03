class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int lp = 0;
        int rp = 0;
        while(lp < g.length && rp < s.length){
            if(g[lp] <= s[rp]){
                lp++;
                rp++;
            } else {
                rp++;
            }
        }
        return lp;
    }
}