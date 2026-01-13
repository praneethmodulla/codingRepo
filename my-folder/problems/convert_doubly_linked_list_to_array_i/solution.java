/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int[] ans = new int[length];
        temp = head;
        int i = 0;
        while(temp != null){
            ans[i] = temp.val;
            i++;
            temp = temp.next;
        }
        return ans;
    }
}