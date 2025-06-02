class Solution {
    public int maxDistToClosest(int[] seats) {
        int prevOne = -1;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0 && prevOne != -1){
                seats[i] = i - prevOne;
            } else if(seats[i] == 1){
                prevOne = i;
                seats[i] = -1;
            }
        }
        prevOne = seats.length;
        for(int i = seats.length - 1; i >= 0; i--){
            if(seats[i] != -1 && prevOne != seats.length){
                if(seats[i] == 0){
                    seats[i] = prevOne - i;
                } else {
                    seats[i] = Math.min(seats[i], prevOne - i);
                }
            } else if(seats[i] == -1){
                prevOne = i;
            }
        }
        int max = 0;
        for(int i = 0; i < seats.length; i++){
            max = Math.max(max, seats[i]);
        }
        return max;
    }
}