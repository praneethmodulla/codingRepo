class Solution {
    public void reverseWords(char[] s) {
        rev(0, s.length - 1, s);
        int i = 0;
        int start = 0;
        while(i < s.length){
            if(s[i] == ' '){
                rev(start, i - 1, s);
                start = i + 1;
            }
            i++;
        }
        rev(start, s.length - 1, s);
        return;
    }

    public void rev(int i, int j, char[] s){
        while(i <= j){
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
        return;
    }
}