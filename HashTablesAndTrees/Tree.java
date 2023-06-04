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

    public boolean  add(int value) {
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
}
