/**
 * A tester class for the SinglyLinkedList class.
 * 
 * @author George Leonidou
 * @version 1.0
 */

import java.util.NoSuchElementException;

public class LinkedListTester<E extends Comparable<E>> {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> intlist = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Double> doublelist = new SinglyLinkedList<Double>();
        SinglyLinkedList<String> stringlist = new SinglyLinkedList<String>();
        SinglyLinkedList<Character> charlist = new SinglyLinkedList<Character>();
        Integer[] intData = { 5, 4, 3, 2, 1 };
        Double[] doubleData = { 3.8, 3.5, 2.9, 2.0, 1.7 };
        String[] stringData = { "Distribution", "Combination", "Calendar", "Banana", "Apple" };
        Character[] charData = { 'E', 'D', 'C', 'B', 'A' };
        runTest("Integer Test", intlist, intData, "1 -> 2 -> 3 -> 4 -> 5 -> null");
        runTest("Double Test", doublelist, doubleData, "1.7 -> 2,0 -> 2.9 -> 3.5 -> 3.8 -> null");
        runTest("String Test", stringlist, stringData, "Apple -> Banana -> Calendar -> Combination -> Distribution -> null");
        runTest("Character test", charlist, charData, "A -> B -> C -> D -> E -> null");
    }
    
    public static <E extends Comparable<E>> void runTest(String testName, SinglyLinkedList<E> list, E[] data, String dataToString) {

        System.out.println("----- Starting test: " + testName + " -----");
        //checking isEmpty
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.isEmpty());
        list.insertLast(data[0]);
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(list.isEmpty());
        //checking getSize
        System.out.println();
        System.out.println("Expected: 1");
        System.out.println(list.getSize()); //if wrong then error with inserLast
        list.insertFront(data[0]);
        System.out.println();
        System.out.println("Expected: 2");
        System.out.println(list.getSize());
        System.out.println();
        list.insertSorted(data[0]);
        System.out.println("Expected: 3");
        System.out.println(list.getSize());
        System.out.println();
        list.removeElement(data[0]);
        System.out.println("Expected: 2");
        System.out.println(list.getSize());
        System.out.println();
        list.removeIndex(1);
        System.out.println("Expected: 1");
        System.out.println(list.getSize());
        //checking clear
        System.out.println();
        System.out.println("Expected: " + data[0] + " -> null");
        System.out.println(list.toString());
        list.clear();
        System.out.println();
        System.out.println("Expected: empty");
        System.out.println(list.toString());
        //checking insertFront
        list.insertFront(data[0]);
        list.insertFront(data[1]);
        System.out.println();
        System.out.println("Expected: " + data[1] + " -> " + data[0] + " -> null");
        System.out.println(list.toString());
        System.out.println();
        System.out.println("Expected: class java.lang.IllegalArgumentException: Cannot insert null element");
        try{
            list.insertFront(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //cheking insertLas
        System.out.println();
        System.out.println("Expected: " + data[0] + " -> " + data[1] + " -> null");
        list.clear();
        list.insertLast(data[0]);
        list.insertLast(data[1]);
        System.out.println(list.toString());
        System.out.println();
        System.out.println("Expected: class java.lang.IllegalArgumentException: Cannot insert null element");
        try{
            list.insertLast(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking insertSorted
        System.out.println();
        System.out.println("Expected: " + dataToString);
        list.clear();
        for (E item : data)
            list.insertSorted(item);
        System.out.println(list.toString());
        System.out.println();
        System.out.println("Expected: class java.lang.IllegalArgumentException: Cannot insert null element");
        try{
            list.insertLast(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking removeIndex(int index)
        System.out.println();
        list.removeIndex(0);
        list.removeIndex(1);
        list.removeIndex(2);
        System.out.println("Exprected: " + data[3] + " -> " + data[1] + " -> null");
        System.out.println(list.toString());
        System.out.println();
        System.out.println("Expected: class java.util.NoSuchElementException: Index out of bounds");
        try{
            list.removeIndex(100);
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking removeElement(E element)
        System.out.println();
        list.removeElement(data[1]);
        list.removeElement(data[3]);
        System.out.println("Expected: true");
        System.out.println(list.isEmpty());
        list.insertFront(data[0]);
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.removeElement(data[0]));
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(list.removeElement(data[0]));
        //checking findNode
        System.out.println();
        list.insertFront(data[0]);
        list.insertLast(data[1]);
        list.insertFront(data[2]);
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(list.findNode(data[3]));
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(list.findNode(data[4]));
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.findNode(data[0]));
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.findNode(data[1]));
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.findNode(data[2]));
        //checking get(int index)
        System.out.println();
        System.out.println("Expected: class java.util.NoSuchElementException: Index out of bounds");
        try{
            list.get(100);
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.get(0).equals(data[2]));
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.get(1).equals(data[0]));
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(list.get(2).equals(data[1]));
        //checking clone
        System.out.println();
        SinglyLinkedList<E> copy = list.clone();
        System.out.println();
        System.out.println("Expected: " + list.toString());
        System.out.println(copy.toString());
        System.out.println();
        System.out.println("Expected: " + list.getSize());
        System.out.println(copy.getSize());
        System.out.println();
        System.out.println("-------------------- End of test " + testName + "--------------------");
    }
}
