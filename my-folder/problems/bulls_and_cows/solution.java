class Solution {
    public String getHint(String secret, String guess) {
        int numBulls = 0;
        int numCows = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                numBulls++;
                set.add(i);
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for(int i = 0; i < guess.length(); i++){
            if((!set.contains(i)) && (map.containsKey(guess.charAt(i)))){
                numCows++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                if(map.get(guess.charAt(i)) == 0){
                    map.remove(guess.charAt(i));
                }
            }
        }
        String ans = numBulls + "A" + numCows + "B";
        return ans;
    }
}