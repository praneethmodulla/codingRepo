class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i = 0;
        int j = s1.length - 1;
        int k = 0;
        int l = s2.length - 1;
        int lenToAdd = Math.abs(s1.length - s2.length);
        int maxLen = Math.max(s1.length, s2.length);
        int minLen = Math.min(s1.length, s2.length);
        while(i <= j && k <= l){
            if(s1[i].equals(s2[k])){
                i++;
                k++;
            }
            if(i <= j && k <= l && s1[j].equals(s2[l])){
                j--;
                l--;
            }
            if(i <= j && k <= l && !s1[i].equals(s2[k]) && !s1[j].equals(s2[l])){
                break;
            }
        }
        if(i > j){
            if(lenToAdd == l - k + 1){
                return true;
            }
        }
        if(k > l){
            if(lenToAdd == j - i + 1){
                return true;
            }
        }
        if(i > j && k > l){
            return true;
        }
        return false;
    }
}