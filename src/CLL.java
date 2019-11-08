public class CLL {

    class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(Integer data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void printElements() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("list empty");
        } else {
            do {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            } while (currentNode != head);
        }
    }

    public static void main(String[] args) {
        CLL circular = new CLL();
        circular.add(1);
        circular.add(2);
        circular.add(99);
        circular.printElements();
    }
}