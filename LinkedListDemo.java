// Node class defined
class Node {
    int nodeValue;
    Node next;

// Constructor initializes node
    public Node(int nodeValue) {
        this.nodeValue = nodeValue;
        this.next = null;
    }
}
//This defines the linked list class
class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    //Contructor initializes empty list
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Method to add new node 
    public void addNode(int nodeValue) {
        Node newNode = new Node(nodeValue);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
// Method to delete node 
    public void deleteNode(int location) {
        //Check if empty
        if (head == null) {
            System.out.println("The Linked List does not exist");
            return;
        }
        //Check for invalid location
        if (location < 0 || location >= size) {
            System.out.println("Invalid location");
            return;
        }
        //Delete first node
        if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            //Delete last node
        } else if (location == size - 1) {
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            tail = tempNode;
            tail.next = null;
            size--;
            //Delete anywhere else:middle
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.nodeValue + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Getter method 
    public int getSize() {
        return size;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        System.out.println("Original list:");
        list.printList();

        // Delete node at the beginning
        list.deleteNode(0);
        System.out.println("After deleting node at the beginning:");
        list.printList();

        // Delete node at the end
        list.deleteNode(list.getSize() - 1); 
        System.out.println("After deleting node at the end:");
        list.printList();

        // Delete node anywhere in the list such as middle
        list.deleteNode(1);
        System.out.println("After deleting node in the middle:");
        list.printList();
    }
}

    