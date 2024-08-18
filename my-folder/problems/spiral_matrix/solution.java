class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int T =0;
        int B = matrix.length - 1;
        int L = 0;
        int R = matrix[0].length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while(T <=B && L <= R){
            for(int i = L; i <= R; i++){
                result.add(matrix[T][i]);
            }
            T++;
            if(T > B){
                break;
            }
            for(int i = T; i <= B; i++){
                result.add(matrix[i][R]);
            }
            R--;
            
            for(int i = R; i >= L; i--){
                result.add(matrix[B][i]);
            }
            B--;
            if(L > R){
                break;
            }
            for(int i = B; i >= T; i--){
                result.add(matrix[i][L]);
            }
            L++;
        }
        return result;
    }
}