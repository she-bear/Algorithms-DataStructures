package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
    
    // 1. Вставка значения
    // 2. Поиск значения (есть или нет)
    // 3. Удаление значения
    // 4. DFS (Depth-first-search) и BFS (Breath-first-search)

    private class Node<T> {
        
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root;

    public boolean add(T value) {
        if (root == null) {
            root = new Node<T>(value);
            return true;
        }

        return addNode(root, value);
    }

    private boolean addNode(Node<T> current, T value) {

        // такой узел уже есть
        if (value.compareTo(current.value) == 0) {
            return false;
        } else if (value.compareTo(current.value) < 0) {
            // вставляем в левое поддерево
            if (current.left == null) {
                // левый узел пуст - просто вставка
                current.left = new Node<T>(value);
                return true;
            } else {
                // левый узел занят - опять нужны все проверки (рекурсия)
                return addNode(current.left, value);
            }
        } else {
            // вставляем в правое поддерево
            if (current.right == null) {
                current.right = new Node<T>(value);
                return true;
            } else {
                return addNode(current.right, value);
            }
        }
    }

    public boolean contains(T value) {
        return findNode(root, value) != null;    
    }

    private Node<T> findNode(Node<T> current, T value) {
        if (current == null) 
            return null;

        // найти узел current, значение которого равно value
        if (value.compareTo(current.value) == 0) {
            return current;
        } else if (value.compareTo(current.value) < 0){
            // проверяем левого потомка
            return findNode(current.left, value);
        } else {
            // проверяем правого потомка
            return findNode(current.right, value);
        }
    }

    public void  remove (T value) {
        root = removeNode(root, value);
    }

    private Node<T> removeNode(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.value) < 0) {
            // нужно удалить в левом поддереве
            current.left = removeNode(current.left, value);
           return current; 
        } else if (value.compareTo(current.value) > 0) {
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
        Node<T> smallestNodeOnTheRight = findFirst(current.right);
        T smallestValueOnTheRight = smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight;
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    private Node<T> findFirst(Node<T> current) {
        if (current.left == null)
            return current;

        return findFirst(current.left);
    }

    public T findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }

    // DFS (Depth-first-search)
    public List<T> dfs() {
        if (root == null)
            return List.of();

        List<T> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // частные случаи поиска в глубину

    // InOrder (see image)
    // возрастающий порядок
    private void dfs(Node<T> current, List<T> result) {
        if (current.left != null) {
            dfs(current.left, result);
        }

        result.add(current.value);
        if (current.right != null) {
            dfs(current.right, result);
        }
    }

    // PreOrder (see image)
    private void preOrder(Node<T> current, List<T> result) {
        result.add(current.value);
        if (current.left != null) {
            preOrder(current.left, result);
        }

        if (current.right != null) {
            preOrder(current.right, result);
        }
    }

    // PostOrder (see image)
    private void postOrder(Node<T> current, List<T> result) {
        if (current.left != null) {
            postOrder(current.left, result);
        }

        if (current.right != null) {
            postOrder(current.right, result);
        }
        result.add(current.value);
    }

    
    // BFS (Breath-first-search)
    public List<T> bfs() {
        if (root == null)
            return List.of();

        List<T> result = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // достать текущий из очереди
            Node<T> next = queue.poll();

            // сохранить в результат
            result.add(next.value);

            // положить в очередь детей
            if (next.left != null)
                queue.add(next.left);
            if (next.right != null)
                queue.add(next.right);
        }

        return result;
    }
}
