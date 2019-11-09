import java.util.Iterator;

public class CLL implements Iterator<Object> {

    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    public Node currentPos;

    public CLL() {
        head = null;
        tail = null;
        currentPos = null;
    }

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            currentPos = head;
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

    @Override
    public boolean hasNext() {
        return currentPos != null && currentPos.next != null;
    }

    @Override
    public Object next() {
        currentPos = currentPos.next; //move up one, 'dispense' previous
        return currentPos.data;
    }

    public static void main(String[] args) {
        CLL circular = new CLL();
        circular.add(1);
        circular.add(2);
        circular.add(99);
        // circular.printElements();

        while (circular.hasNext()) {
            System.out.println(circular.next());
        }
    }
}