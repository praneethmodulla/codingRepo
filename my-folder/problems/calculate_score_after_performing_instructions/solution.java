class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i = 0;
        while(i < instructions.length){
            if(instructions[i].equals("add")){
                score += values[i];
                instructions[i] = "executed";
                i++;
            } else if(instructions[i].equals("jump")){
                int newIdx = i + values[i];
                if(newIdx >= instructions.length || newIdx < 0){
                    break;
                }
                instructions[i] = "executed";
                i = newIdx;
            } else if(instructions[i].equals("executed")){
                break;
            }
        }
        return score;
    }
}