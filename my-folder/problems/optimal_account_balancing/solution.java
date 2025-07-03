class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < transactions.length; i++){
            if(map.containsKey(transactions[i][0])){
                int balance = map.get(transactions[i][0]);
                balance = balance - transactions[i][2];
                map.put(transactions[i][0], balance);
            } else {
                map.put(transactions[i][0], -1 * transactions[i][2]);
            }

            if(map.containsKey(transactions[i][1])){
                map.put(transactions[i][1], map.get(transactions[i][1]) + transactions[i][2]);
            } else {
                map.put(transactions[i][1], transactions[i][2]);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i : map.keySet()){
            if(map.get(i) != 0){
                list.add(map.get(i));
            }
        }
        return recurse(list, list.size(), 0);
    }

    public int recurse(ArrayList<Integer> list, int n, int curr){
        while(curr < n && list.get(curr) == 0){
            curr++;
        }
        if(curr == n){
            return 0;
        }
        int steps = Integer.MAX_VALUE;
        for(int i = curr + 1; i < n; i++){
            if(list.get(i) * list.get(curr) < 0){
                list.set(i, list.get(i) + list.get(curr));
                steps = Math.min(steps, 1 + recurse(list, n, curr + 1));
                list.set(i, list.get(i) - list.get(curr));
            }
        }
        return steps;
    }
}