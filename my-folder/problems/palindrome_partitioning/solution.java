class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        res = recurse(res, path, s, 0);
        return res;
    }

    public List<List<String>> recurse(List<List<String>> res, List<String> path, String s, int idx){
        if(idx == s.length()){
            res.add(new ArrayList<String>(path));
            return res;
        }
        for(int i = idx; i < s.length(); i++){
            if(checkPalindrome(s.substring(idx, i + 1))){
                path.add(s.substring(idx, i + 1));
                res = recurse(res, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
        return res;
    }

    public boolean checkPalindrome(String str){
        if(str.length() == 1){
            return true;
        }
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}