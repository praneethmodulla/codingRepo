class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < bills.length; i++){
            int change = bills[i] - 5;
            hMap.put(bills[i], hMap.getOrDefault(bills[i], 0) + 1);
            if(change > 0){
                if(change == 5){
                    if(!hMap.containsKey(5)){
                        return false;
                    } else if(hMap.get(5) >= 1){
                        int num = hMap.get(5);
                        num--;
                        hMap.put(5, num);
                    } else {
                        return false;
                    }
                } else if(change == 15){
                    if(hMap.containsKey(10) || hMap.containsKey(5)){
                        if(hMap.containsKey(10) && hMap.get(10) >= 1 && hMap.containsKey(5) && hMap.get(5) >= 1){
                            int num1 = hMap.get(10);
                            int num2 = hMap.get(5);
                            num1--;
                            num2--;
                            hMap.put(10, num1);
                            hMap.put(5, num2);
                        } else if (hMap.containsKey(5) && hMap.get(5) >= 3){
                            int num = hMap.get(5);
                            num = num - 3;
                            hMap.put(5, num); 
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}