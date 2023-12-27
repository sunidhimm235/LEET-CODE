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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null && list2 == null)
            return null;
        
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        
        ListNode result;
        
        if (list1.val <= list2.val)
        {
            result = new ListNode(list1.val);
            list1 = list1.next;
        }
        else
        {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }
        
        ListNode temp = result;
        
        while (list1 != null && list2 != null)
        {
            System.out.println(list1.val + " " + list2.val);
            
            if (list1.val <= list2.val)
            {
                System.out.println("First Condition");
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else if (list2 != null)
            {
                System.out.println("Second Condition");
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            
            temp = temp.next;
        }
        
        while (list1 != null)
        {
            System.out.println("First Loop");
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }
        
        while (list2 != null)
        {
            System.out.println("Second Loop: " + list2.val);
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }
        
        return result;
    }
}