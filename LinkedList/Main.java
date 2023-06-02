package LinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[100];

        int a = array[76]; // перебора массива НЕ БУДЕТ, сразу обращение к нужному элементу
        
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
         myLinkedList.add("str1");
         myLinkedList.add("str2");
         myLinkedList.add("str3");

         System.out.println(myLinkedList);    
    }
}