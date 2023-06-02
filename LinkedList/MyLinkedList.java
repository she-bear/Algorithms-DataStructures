package LinkedList;

public class MyLinkedList {

    private Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public void add(int value) {
        Node last = findLast();

        if (last == null) {
            head = new Node(value);
        } else {
            last.next = new Node(value);
        }
    }

    private Node findLast(){
        if (head == null) {
            return null;
        }

        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor;
    }

    @Override
    public String toString() {
        // [1 -> 2 -> 3]
        StringBuilder result = new StringBuilder("[");
        Node cursor = head;
        while(cursor != null) {
            result.append(cursor.value).append(" -> ");
            cursor = cursor.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }
}
