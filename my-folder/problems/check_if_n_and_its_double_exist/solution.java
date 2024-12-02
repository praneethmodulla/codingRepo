class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            hmap.put(arr[i], i);
        }
        for(int i = 0; i < arr.length; i++){
            if(hmap.containsKey(2 * arr[i])){
                if(hmap.get(2 * arr[i]) != i){
                    return true;
                }
            }
        }
        return false;  
    }
}