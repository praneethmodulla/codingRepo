class Solution {
    public boolean canChange(String start, String target) {
        if(start.equals(target)){
            return true;
        }
        int i = 0;
        int j = 0;
        int nextL = 0;
        int prevR = 0;
        while(i < start.length() && j < target.length()){
            if(start.charAt(i) == '_' && target.charAt(j) == '_'){
                i++;
                j++;
            } else {
                if(start.charAt(i) == '_' && target.charAt(j) != '_'){
                    if(prevR == 0 && target.charAt(j) == 'L'){
                        nextL++;
                    } else if(prevR != 0 && target.charAt(j) == 'L'){
                        return false;
                    } else if(target.charAt(j) == 'R'){
                        if(prevR == 0){
                            return false;
                        }
                        prevR--;
                    }
                } else if(start.charAt(i) != '_' && target.charAt(j) == '_'){
                    if(start.charAt(i) == 'L'){
                        if(nextL == 0){
                            return false;
                        }
                        nextL--;
                    } else if(nextL == 0 && start.charAt(i) == 'R'){
                        prevR++;
                    } else if(nextL != 0 && start.charAt(i) == 'R'){
                        return false;
                    }
                } else {
                    if(nextL == 0 && prevR == 0){
                        if(start.charAt(i) != target.charAt(j)){
                            return false;
                        }
                    } else {
                        if(prevR == 0 && target.charAt(j) == 'L'){
                            nextL++;
                        } else if(prevR != 0 && target.charAt(j) == 'L'){
                            return false;
                        } else if(target.charAt(j) == 'R'){
                           if(prevR == 0){
                            return false;
                           }
                           prevR--;
                        }
                        if(start.charAt(i) == 'L'){
                            if(nextL == 0){
                             return false;
                            }
                            nextL--;
                        } else if(nextL == 0 && start.charAt(i) == 'R'){
                            prevR++;
                        } else if(nextL != 0 && start.charAt(i) == 'R'){
                            return false;
                        }
                    }
                    
                }
            i++;
            j++;
        }
    }
    if(nextL == 0 && prevR == 0){
        return true;
    }
    return false;
    }
}