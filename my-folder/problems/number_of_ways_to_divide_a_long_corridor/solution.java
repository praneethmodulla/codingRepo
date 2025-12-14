class Solution {
    public int numberOfWays(String corridor) {
        int mod = (int)1e9 + 7;
        int lastSeat = -1;
        long countSeat = 0;
        long numPlants = 0;
        long ans = 1;
        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                countSeat++;
                if(countSeat > 2){
                    countSeat = 1;
                    if(numPlants > 0){
                        ans = (ans * (numPlants + 1))%mod;
                    }
                    numPlants = 0;
                }
            } else if(countSeat == 2 && corridor.charAt(i) == 'P'){
                numPlants++;
            }
        }
        if(countSeat <= 1){
            return 0;
        }
        return (int)ans;
    }
}