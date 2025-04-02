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

    boolean checkCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }


    public static void main(String args[]) {
        Linklist ll = new Linklist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        System.out.println(ll.checkCycle(head));
    }
}