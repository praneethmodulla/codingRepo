class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int[][] ans = new int[m][n];
        if(len != (m * n)){
            return new int[0][0];
        }
        int r = 0;
        int c = 0; 
        for(int i = 0; i < original.length; i++){
            //System.out.println("Row : " + r + " Column : " + c);
            ans[r][c] = original[i];
            //System.out.println(ans[r][c]);
            c++;
            //System.out.println("Row : " + r + " Column : " + c);
            if((i + 1)%n == 0){
                r++;
                c = 0;
                //System.out.println("Row : " + r + " Column : " + c + " i Value : " + i);
            }
        }
        return ans;
    }
}