class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> res = new ArrayList<String>();
        recurse(s, result, res, 0);
        return result;
    }

    public void recurse(String s, List<List<String>> result, List<String> res, int idx){
        if(idx == s.length()){
            result.add(new ArrayList<String>(res));
            return;
        }
        for(int i = idx + 1; i <= s.length(); i++){
            if(checkPalindrome(s.substring(idx, i))){
                res.add(s.substring(idx, i));
                recurse(s, result, res, i);
                res.remove(res.size() - 1);
            }
        }
        return;
    }

    public boolean checkPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}