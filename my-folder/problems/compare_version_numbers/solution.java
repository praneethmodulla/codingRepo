class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        int j = 0;
        while(i < v1.length && j < v2.length){
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[j]);
            if(ver1 > ver2){
                return 1;
            } else if(ver1 < ver2){
                return -1;
            }
            i++;
            j++;
        }
        while(i < v1.length){
            int ver = Integer.parseInt(v1[i]);
            if(ver > 0){
                return 1;
            }
            i++;
        }

        while(j < v2.length){
            int ver = Integer.parseInt(v2[j]);
            if(ver > 0){
                return -1;
            }
            j++;
        }
        return 0;
    }
}