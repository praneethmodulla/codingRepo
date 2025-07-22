/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode curr = temp.next;
        int[] result = new int[]{-1, -1};
        int minDist = Integer.MAX_VALUE;
        int maxDist = 0;
        boolean start = false;
        int ptr = 0;
        int prevPtr = -1;
        int startPtr = -1;
        while(temp != null){
            if(prev == null || curr == null){
                prev = temp;
                temp = temp.next;
                ptr++;
                if(temp != null){
                    curr = temp.next;
                }
            } else {
                if(prev.val > temp.val && temp.val < curr.val){
                    if(prevPtr == -1){
                        prevPtr = ptr;
                        startPtr = ptr;
                    } else {
                        minDist = Math.min(minDist, ptr - prevPtr);
                        maxDist = Math.max(maxDist, ptr - startPtr);
                        prevPtr = ptr;
                    }
                } else if(prev.val < temp.val && temp.val > curr.val){
                    if(prevPtr == -1){
                        prevPtr = ptr;
                        startPtr = ptr;
                    } else {
                        minDist = Math.min(minDist, ptr - prevPtr);
                        maxDist = Math.max(maxDist, ptr - startPtr);
                        prevPtr = ptr;
                    }
                }
                prev = temp;
                temp = temp.next;
                if(temp != null){
                    curr = temp.next;
                }
                ptr++;
            }
        }
        if(minDist < Integer.MAX_VALUE && maxDist > 0){
            result[1] = maxDist;
            result[0] = minDist;
        }
        return result;
    }
}