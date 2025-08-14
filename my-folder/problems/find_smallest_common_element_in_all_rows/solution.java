class Solution {
    public int smallestCommonElement(int[][] mat) {
        int min = -1;
        for(int i = 0; i < mat[0].length; i++){
            int minNum = mat[0][i];
            boolean flag = true;
            for(int j = 1; j < mat.length; j++){
                if(!check(mat, minNum, j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(min == -1){
                    min = minNum;
                } else {
                    min = Math.min(min, minNum);
                }
            }
        }
        return min;
    }

    public boolean check(int[][] mat, int minNum, int j){
        int high = mat[j].length - 1;
        int low = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(mat[j][mid] == minNum){
                return true;
            } else if(mat[j][mid] > minNum){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}