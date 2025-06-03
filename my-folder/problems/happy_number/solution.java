class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        set.add(n);
        int sum = 0;
        while(n != 0){
            int x = n % 10;
            sum += x * x;
            n = n/10;
        }
        if(set.contains(sum)){
            return false;
        }
        return isHappy(sum);
    }
}