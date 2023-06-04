package Trees;

public class Main {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<String>(); 
        System.out.println(tree.add("ghb"));
        System.out.println(tree.add("abc"));
        System.out.println(tree.add("gmb"));
        System.out.println(tree.add("xyz"));
        System.out.println(tree.add("klm"));
        System.out.println(tree.add("klm"));

        System.out.println();

        System.out.println(tree.contains("gmb"));
        System.out.println(tree.contains("gmg"));
        
        System.out.println(tree.dfs());
        System.out.println(tree.bfs());
    }
}
 