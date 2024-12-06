class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] numChosen = new int[1];
        HashSet<Integer> ban = new HashSet<Integer>();
        for(int i = 0; i < banned.length; i++){
            ban.add(banned[i]);
        }
        recurse(ban, n, maxSum, 0, numChosen, 0, 1);
        return numChosen[0];
    }

    public void recurse(HashSet<Integer> banned, int n, int maxSum, int sumSoFar, int[] numChosen, int chosenSoFar, int num){
        if(num <= n && !banned.contains(num)){
            if(sumSoFar + num <= maxSum){
                recurse(banned, n, maxSum, sumSoFar + num, numChosen, chosenSoFar + 1, num + 1);
            } else {
                if(numChosen[0] < chosenSoFar){
                    numChosen[0] = chosenSoFar;
                }
                return;
            }
        } else if(num <= n && sumSoFar < maxSum && banned.contains(num)){
            recurse(banned, n, maxSum, sumSoFar, numChosen, chosenSoFar, num + 1);
        } else {
            if(numChosen[0] < chosenSoFar){
                numChosen[0] = chosenSoFar;
            }
            return;
        }
    }
}