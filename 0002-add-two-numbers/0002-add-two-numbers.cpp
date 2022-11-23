class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *ans = l1,*prev;
        int carry = 0;
        while(l1 && l2){
            int sum = l1->val+l2->val+carry;
            if(sum > 9){
                carry = 1;
                l1->val = sum-10;
            }
            else{
                carry = 0;
                l1->val = sum;
            }
            prev = l1;
            l1 = l1->next;
            l2 = l2->next;
        }
        if(carry){
            prev->next = l1 ? l1 : l2;
            while(l1){
                int sum = l1->val+carry;
                if(sum > 9){
                    carry = 1;
                    l1->val = sum-10;
                }
                else{
                    carry = 0;
                    l1->val = sum;
                }
                prev = l1;
                l1 = l1->next;
            }
            while(l2){
                int sum = l2->val+carry;
                if(sum > 9){
                    carry = 1;
                    l2->val = sum-10;
                }
                else{
                    carry = 0;
                    l2->val = sum;
                }
                prev = l2;
                l2 = l2->next;
            }
            if(carry){
                ListNode *node = new ListNode(carry);
                prev->next = node;
            }
        }
        else
            prev->next = l1 ? l1 : l2;
        return ans;
    }
};