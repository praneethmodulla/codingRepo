/** 
 * Definition of commonSetBits API (defined in the parent class Problem).
 * int commonSetBits(int num);
 */

public class Solution extends Problem {
    public int findNumber() {
        int res = 0;
        int max = (int)(Math.pow(2, 30)) - 1;
        int j = 0;
        for(int i = 1; i <= max; i <<= 1){
            if(commonSetBits(i) == 1){
                res += (int)(Math.pow(2, j));
            }
            j++;
        }
        return res;
    }
}