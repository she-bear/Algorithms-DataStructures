package LinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
         // Linked List
         // head <-> ... <-> ... <-> tail 
         
         // head[value, second] - значение и ссылка на следующий
         // second[value, third] ...

         // LinkedList in java
         LinkedList<Integer> javaLinkedList = new LinkedList<>();
         javaLinkedList.add(1);
         javaLinkedList.add(2);
         javaLinkedList.add(3);

         // с помощью собственного объекта 
         MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
         System.out.println(myLinkedList.size());
         myLinkedList.add("str1");
         myLinkedList.add("str2");
         myLinkedList.add("str3");

         System.out.println(myLinkedList.size());
         myLinkedList.pop(1);
         System.out.println(myLinkedList); 
         System.out.println(myLinkedList.size());  
    }
}