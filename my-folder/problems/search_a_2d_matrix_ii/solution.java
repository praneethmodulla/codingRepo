class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int low = 0;
            int high = matrix[0].length - 1;
            int mid = 0;
            while(low <= high){
                mid = (low + high)/2;
                if(matrix[i][mid] == target){
                    return true;
                }
                if(matrix[i][mid] > target){
                    high = mid - 1;
                }
                if(matrix[i][mid] < target){
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}