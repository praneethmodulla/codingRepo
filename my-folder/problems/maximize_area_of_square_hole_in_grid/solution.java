class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hLength = 0;
        int vLength = 0;
        int start = vBars[0] - 1;
        for(int i = 0; i < vBars.length - 1; i++){
            if(vBars[i] == vBars[i + 1] - 1){
                continue;
            } else {
                hLength = Math.max(hLength, vBars[i] + 1 - start);
                start = vBars[i + 1] - 1;
            }
        }
        hLength = Math.max(hLength, vBars[vBars.length - 1] + 1 - start);
        start = hBars[0] - 1;
        for(int i = 0; i < hBars.length - 1; i++){
            if(hBars[i] == hBars[i + 1] - 1){
                continue;
            } else {
                vLength = Math.max(vLength, hBars[i] + 1 - start);
                start = hBars[i + 1] - 1;
            }
        }
        vLength = Math.max(vLength, hBars[hBars.length - 1] + 1 - start);
        int squareLength = Math.min(hLength, vLength);
        return squareLength * squareLength;
    }
}