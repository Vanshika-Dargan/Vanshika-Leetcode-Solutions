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
    public ListNode doubleIt(ListNode head) {
         head=reverseList(null,head);
        ListNode temp=head;
        int q=0;
        int rem=0;
        ListNode prev=null;
        while(temp!=null){
           int new_val= temp.val*2+q;
           q=new_val/10;
           temp.val=new_val%10;
           prev=temp;
           temp=temp.next;
        }
        if(q>0){
        ListNode firstNode=new ListNode(1);
        prev.next=firstNode;
        }
        return reverseList(null,head);
    }

    ListNode reverseList(ListNode prev,ListNode curr){
        if (curr == null) {
            return prev;
        }

        ListNode next = curr.next;
        curr.next = prev;
        return reverseList(curr, next);
    }
}