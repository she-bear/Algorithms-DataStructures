package LinkedList;

public class MyLinkedList<T> {

    private Node<T> head;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public T getFirst() {
        return get(0);
    }

    // get element by index
    public T get(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<T> cursor = head;
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

    public T popFirst() {
        return pop(0);
    }

    public T pop(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            T pop = head.value;
            head = head.next;
            return pop;
        }

        Node<T> cursor = head;
        int indexCursor = 1;
        while (cursor.next != null) {
            if (indexCursor == index) {
                T pop = cursor.next.value;
                cursor.next = cursor.next.next;
                return pop;
            }

            cursor = cursor.next;
            indexCursor++;
        }
        
        throw new IndexOutOfBoundsException(index);
    }

    public void add(T value) {
        Node<T> last = findLast();

        if (last == null) {
            head = new Node<T>(value);
        } else {
            last.next = new Node<T>(value);
        }
    }

    private Node<T> findLast(){
        if (head == null) {
            return null;
        }

        Node<T> cursor = head;
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
