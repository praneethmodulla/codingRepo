class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[][] board = new char[numRows][s.length()];
        for(char[] row : board){
            Arrays.fill(row, '1');
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int k = 0;
        boolean down = true;
        for(int i = 0; i < s.length(); i++){
            if(down && j < numRows){
                board[j][k] = s.charAt(i);
                j++;
            } else if((!down) && j > 0){
                board[j][k] = s.charAt(i);
                j--;
                k++;
            } else if(j == numRows){
                k++;
                j = numRows - 2;
                if(j == 0){
                    board[j][k] = s.charAt(i);
                    j++;
                } else {
                    board[j][k] = s.charAt(i);
                    k++;
                    j--;
                    down = false;
                }
            } else if(j == 0){
                down = true;
                board[j][k] = s.charAt(i);
                j++;
            }
        }
        for(int i = 0; i < numRows; i++){
            for(int l = 0; l < s.length(); l++){
                if(board[i][l] != '1'){
                    sb.append(board[i][l]);
                }
            }
        }
        return sb.toString();
    }
}