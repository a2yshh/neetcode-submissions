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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=l1;
        ListNode curr2=l2;
        int carry=0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(curr1!=null||curr2!=null){
            ListNode sum = new ListNode();
            int total = carry;
            if (curr1 != null) {
                total += curr1.val;
                }
            if (curr2 != null) {
                total += curr2.val;
                }
            sum.val=total%10;
            tail.next=sum;
            tail=tail.next;
            carry = total/10;
            if(curr1!=null){
                curr1=curr1.next;
            }
            if(curr2!=null){
                curr2=curr2.next;
            }
            
        }
        if(carry!=0){
                ListNode finalNode = new ListNode(carry);
                tail.next=finalNode;
            }
        return dummy.next;
    }
}
