class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder finalString = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--){
            if(!str[i].isBlank()){
                finalString.append(str[i] + " ");
            }
        }
        return finalString.toString().trim();
    }
}