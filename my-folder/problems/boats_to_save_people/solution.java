class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int numBoats = 0;
        while(i <= j){
            if(i != j){
                if(people[i] + people[j] <= limit){
                    numBoats++;
                    i++;
                    j--;
                } else {
                    numBoats++;
                    j--;
                }
            } else {
                numBoats++;
                i++;
            }
        }
        return numBoats;
    }
}