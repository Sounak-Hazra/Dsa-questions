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

        // step - 2
        tail.next = newNode;

        // step - 3
        tail = newNode;
    }

    Node findMid(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node marge(Node leftHead, Node rightHead) {
        Node tempList = new Node(-1);
        Node temp = tempList;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                tempList.next = leftHead;
                tempList = tempList.next;
                leftHead = leftHead.next;
            } else {
                tempList.next = rightHead;
                tempList = tempList.next;
                rightHead = rightHead.next;
            }
        }
        while (leftHead != null) {
            tempList.next = leftHead;
            tempList = tempList.next;
            leftHead = leftHead.next;
        }
        while (rightHead != null) {
            tempList.next = rightHead;
            tempList = tempList.next;
            rightHead = rightHead.next;
        }
        
        return temp.next;
    }

    Node margeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        leftHead = margeSort(leftHead);
        rightHead = margeSort(rightHead);
        
        return marge(leftHead, rightHead);
    }

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

    public static void main(String args[]) {
        Linklist ll = new Linklist();
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(0);
        ll.addLast(7);
        head = ll.margeSort(head);
        ll.printLL();
    }
}