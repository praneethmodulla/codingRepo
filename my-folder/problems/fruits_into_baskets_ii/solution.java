class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int numTypes = 0;
        boolean placed = false;
        for(int i = 0; i < fruits.length; i++){
            placed = false;
            for(int j = 0; j < baskets.length; j++){
                if(fruits[i] <= baskets[j]){
                    placed = true;
                    baskets[j] = 0;
                    break;
                }
            }
            if(!placed){
                numTypes++;
            }
        }
        return numTypes;
    }
}