class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Arrays.sort(deck);
        for(int i = 0; i < deck.length; i++){
            queue.add(i);
        }
        int[] result = new int[deck.length];
        int i = 0;
        while(!queue.isEmpty()){
            int process = queue.poll();
            result[process] = deck[i];
            if(!queue.isEmpty()){
                int skip = queue.poll();
                queue.add(skip);
            }
            i++;
        }
        return result;
    }
}