class Solution {
    public int countCollisions(String directions) {
        int num = 0;
        char lastSeen = '0';
        int countR = 0;
        for(int i = 0; i < directions.length(); i++){
            char ch = directions.charAt(i);
            if(lastSeen == '0'){
                lastSeen = ch;
                if(ch == 'R'){
                    countR++;
                }
                continue;
            } else if(lastSeen == 'L' && ch == 'R' || lastSeen == 'L' && ch == 'S'){
                lastSeen = ch;
                if(ch == 'R'){
                    countR++;
                }
            } else if(lastSeen == 'R' && ch == 'L'){
                num += 2;
                if(countR > 0){
                    num += countR - 1;
                }
                countR = 0;
                lastSeen = 'S';
            } else if(lastSeen == 'S' && ch == 'L'){
                num += 1;
            } else if(lastSeen == 'R' && ch == 'S'){
                num += countR;
                countR = 0;
                lastSeen = ch;
            } else {
                lastSeen = ch;
                if(ch == 'R'){
                    countR++;
                }
            }
        }
        return num;
    }
}