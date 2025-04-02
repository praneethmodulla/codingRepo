class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        boolean up = true;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(j != mat[0].length && i != mat.length){
            ans[cnt] = mat[i][j];
            cnt++;
            if(up){
                if(i > 0 && j < mat[0].length - 1){
                    i--;
                    j++;
                } else {
                    up = false;
                    if(i == 0 && j == mat[0].length - 1){
                        i++;
                    } else if(i == 0 && j < mat[0].length - 1){
                        j++;
                    } else if(j == mat[0].length - 1 && i > 0){
                        i++;
                    }
                }
            } else {
                if(i < mat.length - 1 && j > 0){
                    i++;
                    j--;
                } else {
                    up = true;
                    if(j == 0 && i == mat.length - 1){
                        j++;
                    } else if(j == 0 && i < mat.length - 1){
                        i++;
                    } else if(i == mat.length - 1 && j > 0){
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}