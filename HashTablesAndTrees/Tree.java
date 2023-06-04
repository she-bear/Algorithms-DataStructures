package HashTablesAndTrees;

public class Tree {
    
    // 1. Вставка значения
    // 2. Поиск значения (есть или нет)
    // 3. Удаление значения

    private class Node {
        
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        return addNode(root, value);
    }

    private boolean addNode(Node current, int value) {

        // такой узел уже есть
        if (value == current.value) {
            return false;
        } else if (value < current.value) {
            // вставляем в левое поддерево
            if (current.left == null) {
                // левый узел пуст - просто вставка
                current.left = new Node(value);
                return true;
            } else {
                // левый узел занят - опять нужны все проверки (рекурсия)
                return addNode(current.left, value);
            }
        } else {
            // вставляем в правое поддерево
            if (current.right == null) {
                current.right = new Node(value);
                return true;
            } else {
                return addNode(current.right, value);
            }
        }
    }

    public boolean contains(int value) {
        return findNode(root, value) != null;    
    }

    private Node findNode(Node current, int value) {
        if (current == null) 
            return null;

        // найти узел current, значение которого равно value
        if (value == current.value) {
            return current;
        } else if (value < current.value){
            // проверяем левого потомка
            return findNode(current.left, value);
        } else {
            // проверяем правого потомка
            return findNode(current.right, value);
        }
    }
}
