class Solution {
    public int minAddToMakeValid(String s) {
        if(s.isEmpty() || s.isBlank()){
            return 0;
        }
        int openPar = 0;
        int closePar = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                openPar++;
            } else if(openPar > 0){
                openPar--;
            } else {
                closePar++;
            }
        }
        return openPar + closePar;
    }
}