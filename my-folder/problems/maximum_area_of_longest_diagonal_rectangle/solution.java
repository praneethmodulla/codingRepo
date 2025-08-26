class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiag = 0;
        for(int i = 0; i < dimensions.length; i++){
            double diag = Math.sqrt(Math.pow(dimensions[i][0], 2) + Math.pow(dimensions[i][1], 2));
            if(diag > maxDiag){
                maxDiag = diag;
                maxArea = dimensions[i][0] * dimensions[i][1];
            } else if(maxDiag == diag){
                maxArea = Math.max(maxArea, dimensions[i][0] * dimensions[i][1]);
            }
        }
        return maxArea;
    }
}