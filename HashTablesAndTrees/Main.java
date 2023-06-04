package HashTablesAndTrees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(); 
        System.out.println(tree.add(8));
        System.out.println(tree.add(1));
        System.out.println(tree.add(3));
        System.out.println(tree.add(12));
        System.out.println(tree.add(12));

        System.out.println(tree.contains(8));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(12));
        System.out.println(tree.contains(14));
    }
}
 