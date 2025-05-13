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

    Node findMid() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    boolean isPalidrom() {
        Node mid = findMid();
        Node prev = mid;
        Node curr = mid.next;
        mid.next = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            curr = next;
            prev = curr;
        }
        Node temp1 = head;
        Node temp2 = prev;
        while (temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String args[]) {
        Linklist ll = new Linklist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        System.out.println(ll.isPalidrom());
    }
}