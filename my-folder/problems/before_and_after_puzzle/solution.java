class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int n = phrases.length;
        String[][] sp = new String[n][2];
        for(int i = 0; i < n; i++){
            String[] str = phrases[i].split(" ");
            sp[i][0] = str[0];
            sp[i][1] = str[str.length - 1];
        }

        HashSet<String> m = new HashSet<String>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(sp[i][0].equals(sp[j][1])){
                    String combined = phrases[j] + phrases[i].substring(sp[i][0].length());
                    m.add(combined);
                }
            }
        }
        List<String> result = new ArrayList<String>(m);
        Collections.sort(result);
        return result;
    }
}