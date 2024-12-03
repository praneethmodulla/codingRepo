class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int prevIdx = 0;
        for(int i = 0; i < spaces.length; i++){
            sb.append(s.substring(prevIdx, spaces[i]));
            sb.append(" ");
            prevIdx = spaces[i];
        }
        sb.append(s.substring(prevIdx, s.length()));
        return sb.toString();
    }
}