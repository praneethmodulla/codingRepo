class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < trust.length; i++){
            adjList.get(trust[i][0]).add(trust[i][1]);
        }
        List<Integer> possibleJudges = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            if(adjList.get(i).size() == 0){
                possibleJudges.add(i);
            }
        }
        if(possibleJudges.size() == 0){
            return -1;
        }
        int townJudge = -1;
        for(int i = 0; i < possibleJudges.size(); i++){
            townJudge = possibleJudges.get(i);
            for(int j = 1; j <=n ; j++){
                if(j != townJudge && !adjList.get(j).contains(townJudge)){
                    townJudge = -1;
                    break;
                }
            }
            if(townJudge != -1){
                break;
            }
        }
        return townJudge;
    }
}