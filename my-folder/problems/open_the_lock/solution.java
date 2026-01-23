class Pair {
    String number;
    int steps;

    public Pair(String _num, int _steps){
        this.number = _num;
        this.steps = _steps;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < deadends.length; i++){
            set.add(deadends[i]);
        }
        String start = "0000";
        if(set.contains(start)){
            return -1;
        }
        if(start.equals(target)){
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.steps, b.steps));
        queue.add(new Pair(start, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.number.equals(target)){
                return p.steps;
            }
            //circle forward & backward
            for(int i = 0; i < 4; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(p.number.substring(0, i));
                int num = p.number.charAt(i) - '0';
                num = num + 1;
                if(num == 10){
                    num = 0;
                }
                sb.append(String.valueOf(num));
                sb.append(p.number.substring(i + 1, 4));
                if(!visited.contains(sb.toString()) && !set.contains(sb.toString())){
                    visited.add(sb.toString());
                    queue.add(new Pair(sb.toString(), p.steps + 1));
                }
                StringBuilder sbrev = new StringBuilder();
                num = p.number.charAt(i) - '0';
                sbrev.append(p.number.substring(0, i));
                num = num - 1;
                if(num == -1){
                    num = 9;
                }
                sbrev.append(String.valueOf(num));
                sbrev.append(p.number.substring(i + 1, 4));
                if(!visited.contains(sbrev.toString()) && !set.contains(sbrev.toString())){
                    visited.add(sbrev.toString());
                    queue.add(new Pair(sbrev.toString(), p.steps + 1));
                }
            }
        }
        return -1;
    }
}