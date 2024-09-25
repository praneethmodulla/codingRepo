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
    boolean isReverse = true;
    public BSTIterator(TreeNode root, boolean reverse) {
        isReverse = reverse;
        recurse(root);
    }

    public void recurse(TreeNode node){
        if(node == null){
            return;
        }
        while(!isReverse && node != null){
            stack.push(node);
            node = node.left;
        }
        while(isReverse && node != null){
            stack.push(node);
            node = node.right;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        if(!isReverse && top.right != null){
            stack.push(top.right);
            TreeNode node = stack.peek().left;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        } else if(isReverse && top.left != null){
            stack.push(top.left);
            TreeNode node = stack.peek().right;
            while(node != null){
                stack.push(node);
                node = node.right;
            }
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}