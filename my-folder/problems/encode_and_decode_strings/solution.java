public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(String s : strs){
            sb.append(s);
            sb.append("π");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] str = s.split("π", -1);
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < str.length - 1; i++){
            res.add(str[i]);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));