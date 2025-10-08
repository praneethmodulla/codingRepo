class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            long minPotion = (long)Math.ceil((1.0 * success)/spells[i]);
            if(minPotion > potions[potions.length - 1]){
                pairs[i] = 0;
                continue;
            }
            int low = check(potions, minPotion);
            pairs[i] = potions.length - low;
        }
        return pairs;
    }

    public int check(int[] potions, long minPotion){
        int low = 0;
        int high = potions.length;
        int mid = 0;
        while(low < high){
            mid = low + (high - low)/2;
            if(potions[mid] < minPotion){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}