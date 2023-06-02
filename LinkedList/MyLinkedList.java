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
    
    public int getFirst() {
        return get(0);
    }

    // get element by index
    public int get(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node cursor = head;
        int indexCursor = 0;
        while (cursor != null) {
            if (indexCursor == index) {
                return cursor.value;
            }

            cursor = cursor.next;
            indexCursor++;
        }
        
        throw new IndexOutOfBoundsException(index);
    }

    public int pop(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            return pop;
        }

        Node cursor = head;
        int indexCursor = 1;
        while (cursor.next != null) {
            if (indexCursor == index) {
                int pop = cursor.next.value;
                cursor.next = cursor.next.next;
                return pop;
            }

            cursor = cursor.next;
            indexCursor++;
        }
        
        throw new IndexOutOfBoundsException(index);
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
