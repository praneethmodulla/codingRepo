class Solution {
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length;
        int n = skill.length; 
        long[] store = new long[n];
        long now = 0;
        for(int i = 0; i < m; i++){
            now = 0;
            for(int j = 0; j < n; j++){
                now = Math.max(now, store[j]) + skill[j] * mana[i];
            }
            store[n - 1] = now;
            for(int j = n - 2; j >= 0; j--){
                store[j]= store[j + 1] - skill[j + 1] * mana[i];
            }
        }
        return store[n - 1];
    }
}