class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefixSum = new int[words.length];
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i < words.length; i++){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                if(i == 0){
                    prefixSum[i] = 1;
                } else {
                    prefixSum[i] = prefixSum[i - 1] + 1;
                }
            } else {
                if(i == 0){
                    prefixSum[i] = 0;
                } else {
                    prefixSum[i] = prefixSum[i - 1];
                }
            }
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 0){
                ans[i] = prefixSum[queries[i][1]];
            } else if(queries[i][0] == queries[i][1]){
                if(set.contains(words[queries[i][0]].charAt(0)) && set.contains(words[queries[i][0]].charAt(words[queries[i][0]].length() - 1))){
                    ans[i] = 1;
                } else {
                    ans[i] = 0;
                }
            } else {
                ans[i] = prefixSum[queries[i][1]] - prefixSum[queries[i][0] - 1];
            }
        }
        return ans;
    }
}