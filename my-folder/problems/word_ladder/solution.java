class Pair{
    String str;
    int pathLen;
    public Pair(String s, int len){
        str = s;
        pathLen = len;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        HashMap<String, Integer> vis = new HashMap<String, Integer>();
        graph.put(beginWord, new ArrayList<String>());
        vis.put(beginWord, 1);
        boolean checkEndWord = false;
        for(int i = 0; i < wordList.size(); i++){
            if(wordList.get(i).equals(endWord)){
                checkEndWord = true;
            }
            graph.put(wordList.get(i), new ArrayList<String>());
            vis.put(wordList.get(i), 0);
        }
        if(!checkEndWord){
            return 0;
        }
        for(String key : graph.keySet()){
            for(int i = 0; i < wordList.size(); i++){
                if((!key.equals(wordList.get(i))) && checkWords(key, wordList.get(i))){
                    List<String> grp = graph.get(key);
                    grp.add(wordList.get(i));
                    graph.put(key, grp);
                }
            }
        }
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(beginWord, 1));
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pair unit = queue.poll();
            String word = unit.str;
            int len = unit.pathLen;
            if(word.equals(endWord)){
                ans = Math.min(ans, len);
            }
            for(int i =0; i < graph.get(word).size(); i++){
                if(vis.get(graph.get(word).get(i)) == 0){
                    queue.add(new Pair(graph.get(word).get(i), len + 1));
                    vis.put(graph.get(word).get(i), 1);
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
    public boolean checkWords(String str1, String str2){
        int i = 0;
        int j = 0;
        int k = 1;
        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            } else {
                k--;
                if(k < 0){
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}