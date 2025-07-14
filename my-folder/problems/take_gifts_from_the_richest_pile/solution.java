class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        for(int i = 0; i < gifts.length; i++){
            heap.add(gifts[i]);
        }
        while(k != 0 && !heap.isEmpty()){
            int pile = heap.poll();
            double num = Math.sqrt(pile);
            int left = (int)Math.floor(num);
            heap.add(left);
            k--;
        }
        long total = 0;
        while(!heap.isEmpty()){
            total += heap.poll();
        }
        return total;
    }
}