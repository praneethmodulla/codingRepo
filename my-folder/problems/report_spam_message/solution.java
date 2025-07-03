class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<String>();
        for(int i =0 ; i < bannedWords.length; i++){
            banned.add(bannedWords[i]);
        }
        int count = 0;
        for(int i = 0; i < message.length; i++){
            if(banned.contains(message[i])){
                count++;
            }
            if(count >= 2){
                return true;
            }
        }
        return false;
    }
}