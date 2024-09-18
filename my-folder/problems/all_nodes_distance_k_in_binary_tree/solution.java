/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);
        Queue<TreeNode> queue = new ArrayDeque<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        queue.add(target);
        visited.put(target, true);
        int dist = 0;
        while(dist < k){
            int size = queue.size();
            dist++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null && visited.get(node.left) == null){
                    queue.add(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    queue.add(node.right);
                    visited.put(node.right, true);
                }
                if(parentMap.get(node) != null && visited.get(parentMap.get(node)) == null){
                    queue.add(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        int size = queue.size();
        for(int i = 0; i < size; i++){
            result.add(queue.poll().val);
        }
        return result;
    }

    public void markParent(TreeNode node, HashMap<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode tree = queue.poll();
            if(tree.left != null){
                parentMap.put(tree.left, tree);
                queue.add(tree.left);
            }
            if(tree.right != null){
                parentMap.put(tree.right, tree);
                queue.add(tree.right);
            }
        }
        return;
    }
}