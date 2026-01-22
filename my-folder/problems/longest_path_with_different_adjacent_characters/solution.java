class Solution {
    int longestPath = 1;
    public int longestPath(int[] parent, String s) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i < parent.length; i++){
            if(map.containsKey(parent[i])){
                map.get(parent[i]).add(i);
            } else {
                List<Integer> childNodes = new ArrayList<Integer>();
                childNodes.add(i);
                map.put(parent[i], childNodes);
            }
        }
        dfs(0, map, s);
        return longestPath;
    }

    public int dfs(int currentNode, HashMap<Integer, List<Integer>> map, String s){
        if(!map.containsKey(currentNode)){
            return 1;
        }
        int firstLongest = 0;
        int secondLongest = 0;
        for(int child : map.get(currentNode)){
            int longestPathfromChild = dfs(child, map, s);
            if(s.charAt(currentNode) != s.charAt(child)){
                if(longestPathfromChild > firstLongest){
                    secondLongest = firstLongest;
                    firstLongest = longestPathfromChild;
                } else if(longestPathfromChild > secondLongest){
                    secondLongest = longestPathfromChild;
                }
            } 
        }
        longestPath = Math.max(longestPath, 1 + firstLongest + secondLongest);
        return 1 + firstLongest;
    }

}