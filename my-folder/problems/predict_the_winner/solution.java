class Solution {
    public boolean predictTheWinner(int[] nums) {
        return recurse(0, nums.length - 1, 0, 0, 0, nums);
    }

    public boolean recurse(int i, int j, int p1Score, int p2Score, int play, int[] nums){
        if(i > j){
            if(p1Score >= p2Score){
                return true;
            }
            return false;
        }
        if(play == 0){
            return recurse(i + 1, j, p1Score + nums[i], p2Score, 1, nums) || recurse(i, j - 1, p1Score + nums[j], p2Score, 1, nums);
        } else {
            return recurse(i + 1, j, p1Score, p2Score + nums[i], 0, nums) && recurse(i, j - 1, p1Score, p2Score + nums[j], 0, nums);
        }
    }
}