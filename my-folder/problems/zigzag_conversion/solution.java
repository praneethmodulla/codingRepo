class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int row = 1;
        while(row <= numRows){
            int i = row - 1;
            boolean down = true;
            while(i < s.length()){
                sb.append(s.charAt(i));
                if(down && row != numRows){
                    i += 2 * (numRows - row);
                    if(row != 1){
                        down = false;
                    }
                } else {
                    i += 2 * (row - 1);
                    down = true;
                }
            }
            row++;
        }
        return sb.toString();
    }
}