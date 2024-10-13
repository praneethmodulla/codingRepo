class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        } 
        String concat = s + s;
        int found = concat.indexOf(goal);
        if(found != -1){
            return true;
        }
        return false;
    }
}