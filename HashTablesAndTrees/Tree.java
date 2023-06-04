package HashTablesAndTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree {
    
    // 1. Вставка значения
    // 2. Поиск значения (есть или нет)
    // 3. Удаление значения
    // 4. DFS (Depth-first-search) и BFS (Breath-first-search)

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

    public void  remove (int value) {
        root = removeNode(root, value);
    }

    private Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            // нужно удалить в левом поддереве
            current.left = removeNode(current.left, value);
           return current; 
        } else if (value > current.value) {
            // нужно удалить в правом поддереве
            current.right = removeNode(current.right, value);
            return current;
        }

        // удаление узла current
        // 1. дочерних узлов нет
        if (current.left == null && current.right == null)
            return null;

        // 2. есть только один дочерний узел
        if (current.left == null && current.right != null) {
            return current.right;
        }
        if (current.left != null && current.right == null) {
            return current.left;
        }

        // 3. есть оба дочерних узла
        // нужно найти минимальный элемент справа (или - по другому алгоритму - максимальный слева)
        Node smallestNodeOnTheRight = findFirst(current.right);
        int smallestValueOnTheRight = smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight;
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    private Node findFirst(Node current) {
        if (current.left == null)
            return current;

        return findFirst(current.left);
    }

    public int findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }

    public List<Integer> dfs() {
        if (root == null)
            return List.of();

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // частные случаи поиска в глубину

    // InOrder (see image)
    // возрастающий порядок
    private void dfs(Node current, List<Integer> result) {
        if (current.left != null) {
            dfs(current.left, result);
        }

        result.add(current.value);
        if (current.right != null) {
            dfs(current.right, result);
        }
    }

    // PreOrder (see image)
    private void preOrder(Node current, List<Integer> result) {
        result.add(current.value);
        if (current.left != null) {
            preOrder(current.left, result);
        }

        if (current.right != null) {
            preOrder(current.right, result);
        }
    }

    // PostOrder (see image)
    private void postOrder(Node current, List<Integer> result) {
        if (current.left != null) {
            postOrder(current.left, result);
        }

        if (current.right != null) {
            postOrder(current.right, result);
        }
        result.add(current.value);
    }
}
