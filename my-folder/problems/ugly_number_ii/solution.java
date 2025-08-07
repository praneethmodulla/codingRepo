class Solution {
    public int nthUglyNumber(int n) {
        int idxmultiple2 = 0;
        int idxmultiple3 = 0;
        int idxmultiple5 = 0;
        int nextmultiple2 = 2;
        int nextmultiple3 = 3;
        int nextmultiple5 = 5;

        int[] uglynumbers = new int[n];
        uglynumbers[0] = 1;
        for(int i = 1; i < n ;i++){
            uglynumbers[i] = Math.min(nextmultiple2, Math.min(nextmultiple5, nextmultiple3));
            if(uglynumbers[i] == nextmultiple2){
                idxmultiple2++;
                nextmultiple2 = uglynumbers[idxmultiple2] * 2;
            }
            if(uglynumbers[i] == nextmultiple3){
                idxmultiple3++;
                nextmultiple3 = uglynumbers[idxmultiple3] * 3;
            }
            if(uglynumbers[i] == nextmultiple5){
                idxmultiple5++;
                nextmultiple5 = uglynumbers[idxmultiple5] * 5;
            }
        }
        return uglynumbers[n - 1];
    }
}