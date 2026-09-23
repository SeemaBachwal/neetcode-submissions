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
    ListNode ansNode;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode returnNode = helper(head);
        returnNode.next = null;
        
        return ansNode;
    }

    public ListNode helper(ListNode head) {
        if (head.next == null) {
            ansNode = head;
            return ansNode;
        }

        ListNode nextNode = helper(head.next);
        nextNode.next = head;

        return head;
    }
}
