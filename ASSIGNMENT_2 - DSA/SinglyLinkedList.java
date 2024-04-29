class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SinglyLinkedList {
    private ListNode head;

    // Insert element at the beginning of the linked list
    public void insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Insert element at the end of the linked list
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete element from the linked list
    public void delete(int val) {
        if (head == null) return;
        if (head.val == val) {
            head = head.next;
            return;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.val != val) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        }
    }

    // Search for an element in the linked list
    public boolean search(int val) {
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reverse the linked list
    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Find the middle element of the linked list
    public ListNode findMiddle() {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }

    // Print the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        System.out.println("Original list:");
        list.printList();

        list.reverse();
        System.out.println("Reversed list:");
        list.printList();

        System.out.println("Middle element: " + list.findMiddle().val);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        System.out.println("Second list:");
        list2.printList();

        ListNode mergedList = mergeSortedLists(list.head, list2.head);
        System.out.println("Merged list:");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

