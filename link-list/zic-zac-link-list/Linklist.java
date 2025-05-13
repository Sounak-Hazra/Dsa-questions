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

    void printLL() {
        if (head == null) {
            System.out.println("Link list is Empty ");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

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

    void ziczacLinkedlist(Node head) {

        //* Step 1 --> find last node of first half
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //* Step 2 --> Reverse the second half
        Node prev = null;
        Node curr = slow.next;
        slow.next = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //* Step 3 --> make the list zic zca 
        Node leftHead = head;
        Node rightHead = prev;

        while (leftHead != null && rightHead != null) {
            Node ln = leftHead.next;
            Node rn = rightHead.next;
            leftHead.next = rightHead;
            rightHead.next = ln;
            leftHead = ln;
            rightHead = rn;
        }
    }

    public static void main(String args[]) {
        Linklist ll = new Linklist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.ziczacLinkedlist(head);
        ll.printLL();
    }
}