class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lowRow = 0;
        int highRow = matrix.length - 1;
        int midRow = 0;
        while(lowRow <= highRow){
            midRow = (lowRow + highRow)/2;
            if(matrix[midRow][0] == target){
                return true;
            }
            if(matrix[midRow][0] > target){
                highRow = midRow - 1;
            }
            if(matrix[midRow][0] < target && matrix[highRow][0] > target){
                lowRow = midRow;
                highRow = highRow - 1;
            }
            if(matrix[midRow][0] < target && matrix[highRow][0] <= target){
                midRow = highRow;
                break;
            }
        }
        int low = 0;
        int high = matrix[0].length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(matrix[midRow][mid] == target){
                return true;
            }
            if(matrix[midRow][mid] > target){
                high = mid - 1;
            }
            if(matrix[midRow][mid] < target){
                low = mid + 1;
            }
        } 
        return false;
    }
}