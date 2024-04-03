import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        String input = "";
        String[] books;
        LinkList k = new LinkList();

        //Get number of read books
        n = scanner.nextInt();
        scanner.nextLine();
        input = scanner.nextLine();
        books = input.split(" ");

        //Add books to the linked list
        for (String book : books) {
            if (!book.isEmpty()) {
                k.add(Integer.parseInt(book));
            }
        }

        //Update list
        for (int i = 0; i < n; i++) {
            int book = k.getEnd();
            k.removeEnd();
            k.addBeginning(book);
        }

        k.printList();
    }
}

//Link List Classes
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkList {
    Node head;

    public LinkList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            this.head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int getEnd() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void removeEnd() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void addBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.print(current.data);
                break;
            }
            System.out.print(current.data + " ");
            current = current.next;

        }
    }
}