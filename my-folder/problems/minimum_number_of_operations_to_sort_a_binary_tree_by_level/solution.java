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
    public int minimumOperations(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int minOps = 0;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelArray = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    levelArray.add(node.left.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                    levelArray.add(node.right.val);
                }
            }
            level++;
            minOps += minSwaps(levelArray);
        }
        return minOps;
    }

    public int minSwaps(List<Integer> level){
        List<Integer> clone = new ArrayList<>(level);
        Collections.sort(clone);
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < level.size(); i++){
            hMap.put(level.get(i), i);
        }
        int swaps = 0;
        for(int i = 0; i < level.size(); i++){
            if(clone.get(i) != level.get(i)){
                swaps++;
                int temp = clone.get(i);
                int pos = hMap.get(temp);
                level.set(pos, level.get(i));
                hMap.put(level.get(pos), pos);
                hMap.put(temp, i);
                level.set(i, temp);
            }
        }
        return swaps;
    }
}