/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        return recurse(root, hMap);
    }

    public int recurse(TreeNode root, HashMap<Integer, Integer> hMap){
        if(root.left == null && root.right == null){
            hMap.put(root.val, hMap.getOrDefault(root.val, 0) + 1);
            if(check(hMap)){
                hMap.put(root.val, hMap.getOrDefault(root.val, 0) - 1);
                if(hMap.get(root.val) == 0){
                    hMap.remove(root.val);
                }
                return 1;
            }
            hMap.put(root.val, hMap.getOrDefault(root.val, 0) - 1);
            if(hMap.get(root.val) == 0){
                hMap.remove(root.val);
            }
            return 0;
        }
        int left = 0;
        int right = 0;
        hMap.put(root.val, hMap.getOrDefault(root.val, 0) + 1);
        if(root.left != null){
            left = recurse(root.left, hMap);
        }
        if(root.right != null){
            right = recurse(root.right, hMap);
        }
        hMap.put(root.val, hMap.getOrDefault(root.val, 0) - 1);
        if(hMap.get(root.val) == 0){
            hMap.remove(root.val);
        }
        return left + right;
    }

    public boolean check(HashMap<Integer, Integer> hMap){
        int cntOdd = 0;
        for(int i : hMap.keySet()){
            if(hMap.get(i)%2 == 1){
                cntOdd += 1;
            }
            if(cntOdd > 1){
                return false;
            }
        }
        return true;
    }
}