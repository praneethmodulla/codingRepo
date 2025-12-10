class Solution {
    public int countPermutations(int[] complexity) {
        int rootComplexity = complexity[0];
        Arrays.sort(complexity);
        if(complexity[0] == rootComplexity && complexity[0] < complexity[1]){
            return (int)factorial(complexity.length - 1);
        }
        return 0;
    }

    public long factorial(int num){
        if(num == 1){
            return 1;
        }
        int mod = (int)1e9 + 7;
        return ((long)num * factorial(num - 1)) % mod;
    }
}