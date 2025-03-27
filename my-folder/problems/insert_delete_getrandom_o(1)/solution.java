class RandomizedSet {
    HashMap<Integer, Integer> hMap;
    List<Integer> array;
    public RandomizedSet() {
        hMap = new HashMap<Integer, Integer>();
        array = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(hMap.containsKey(val)){
            return false;
        } else {
            array.add(val);
            hMap.put(val, array.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(hMap.containsKey(val)){
            int idx = hMap.get(val);
            int temp = array.get(array.size() - 1);
            array.set(idx, temp);
            hMap.put(temp, idx);
            array.remove(array.size() - 1);
            hMap.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        return array.get(random.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */