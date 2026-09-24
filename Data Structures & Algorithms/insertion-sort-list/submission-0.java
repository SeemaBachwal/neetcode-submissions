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
    public ListNode insertionSortList(ListNode head) {

        List<Integer> data = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){

            data.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(data);

        curr = head;

        for(int val : data){
            curr.val = val;
            curr = curr.next;
        }

        return head;
        
    }
}