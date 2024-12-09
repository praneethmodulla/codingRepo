class Solution {
    public int totalFruit(int[] fruits) {
        int leftPtr = 0;
        int rightPtr = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxFruits = 0;
        for(rightPtr = 0; rightPtr < fruits.length; rightPtr++){
            if(map.size() < 2){
                map.put(fruits[rightPtr], map.getOrDefault(fruits[rightPtr], 0) + 1);
            } else if(!map.containsKey(fruits[rightPtr])){
                while(map.size() >= 2){
                    if(map.get(fruits[leftPtr]) > 0){
                        map.put(fruits[leftPtr], map.get(fruits[leftPtr]) - 1);
                    }
                    if(map.get(fruits[leftPtr]) == 0){
                        map.remove(fruits[leftPtr]);
                    }
                    leftPtr++;
                }
                map.put(fruits[rightPtr], map.getOrDefault(fruits[rightPtr], 0) + 1);
            } else {
                map.put(fruits[rightPtr], map.getOrDefault(fruits[rightPtr], 0) + 1);
            }
            if(maxFruits < rightPtr - leftPtr + 1){
                maxFruits = rightPtr - leftPtr + 1;
            }
        }
        return maxFruits;
    }
}