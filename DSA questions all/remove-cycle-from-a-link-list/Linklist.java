public class Linklist {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    public static Node head;
    public static Node tail;
    public static int size;

    void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (tail == null) {
            head = tail = newNode;
            return;
        }

        //step - 2
        tail.next = newNode;

        //step - 3
        tail = newNode;
    }

    void removeCycle(Node head) {
        if (head == null) {
            return;
        }

        //Detect cycle
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        //if no cycle exist 
        if (!isCycle) {
            return;
        }

        //if cycle exist
        Node prev = null;
        slow = head;

        //For a case when cycle is happend with head node 
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }

        //For normal cycles
        else {
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }

    public static void main(String args[]) {
        Linklist ll = new Linklist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        tail.next = head;
        ll.removeCycle(head);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}