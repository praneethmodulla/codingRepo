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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        recurse(root);
    }

    public void recurse(TreeNode node){
        if(node == null){
            return;
        }
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        if(top.right != null){
            stack.push(top.right);
            TreeNode node = stack.peek().left;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */