/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert new nodes after each node in the original list
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Set the random pointers of the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original list and the new list
        Node newHead = head.next;
        current = head;
        Node newCurrent = newHead;
        while (current != null) {
            current.next = current.next.next;
            current = current.next;
            if (newCurrent.next != null) {
                newCurrent.next = newCurrent.next.next;
            }
            newCurrent = newCurrent.next;
        }

        return newHead;
    }
}