class Pair{
    String s;
    int steps;
    int idx;
    public Pair(String str, int step, int index){
        this.s = str;
        this.steps = step;
        this.idx = index;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> Integer.compare(a.steps, b.steps));
        int[] vis = new int[bank.length + 1];
        Arrays.fill(vis, 0);
        queue.add(new Pair(startGene, 0, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String str = p.s;
            int stepCount = p.steps;
            vis[p.idx]++;
            if(str.equals(endGene)){
                return stepCount;
            }
            for(int i = 0; i < bank.length; i++){
                if(check(str, bank[i]) && vis[i + 1] != 1){
                    queue.add(new Pair(bank[i], stepCount + 1, i + 1));
                }
            }
        }
        return -1; 
    }

    public boolean check(String strGene, String endGene){
        int count = 0;
        for(int i = 0; i < 8; i++){
            if(strGene.charAt(i) != endGene.charAt(i)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        if(count < 1){
            return false;
        }
        return true;
    }
}