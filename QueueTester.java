/**
 * A tester class for the CircularQueue class.
 * 
 * @author George Leonidou
 * @version 1.0
 */

import java.util.NoSuchElementException;

public class QueueTester {
    
    public static void main(String[] args) {
        Integer[] intData = { 5, 4, 3, 2, 1 };
        Double[] doubleData = { 3.8, 3.5, 2.9, 2.0, 1.7 };
        String[] stringData = { "Distribution", "Combination", "Calendar", "Banana", "Apple" };
        Character[] charData = { 'E', 'D', 'C', 'B', 'A' };
        CircularQueue<Integer> intQueue = new CircularQueue<Integer>(5);
        CircularQueue<Double> doubleQueue = new CircularQueue<Double>(5);
        CircularQueue<String> stringQueue = new CircularQueue<String>(5);
        CircularQueue<Character> charQueue = new CircularQueue<Character>(5);
        runTest("Integer Test", intQueue, intData, "( 1 , 2 , 3 , 4 , 5 )");
        runTest("Double Test", doubleQueue, doubleData, "( 1.7 , 2,0 , 2.9 , 3.5 , 3.8 )");
        runTest("String Test", stringQueue, stringData, "( Apple , Banana , Calendar , Combination , Distribution )");
        runTest("Character test", charQueue, charData, "( A , B , C , D , E )");
    }

    public static <E extends Comparable<E>> void runTest(String testName, CircularQueue<E> q, E[] data, String dataToString) {
        System.out.println("-----Starting test: " + testName + "-----");        
        //checking isEmpty()
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(q.isEmpty());
        q.enqueue(data[0]);
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(q.isEmpty());
        //checking is Full
        System.out.println();
        System.out.println("Expexted: false");
        System.out.println(q.isFull());
        q.dequeue();
        for (E item : data) {
            q.enqueue(item);
        }
        System.out.println();
        System.out.println("Expected: true");
        System.out.println(q.isFull());
        //checking getSize
        System.out.println();
        System.out.println("Expected: " + data.length);
        System.out.println(q.getSize());
        int prevSize = q.getSize();
        q.dequeue();
        q.dequeue();
        System.out.println();
        System.out.println("Expected: " + (prevSize - 2));
        System.out.println(q.getSize());
        System.out.println();
        System.out.println("Expected: " + (prevSize - 1));
        q.enqueue(data[0]);
        System.out.println(q.getSize());
        System.out.println();
        q.insertSorted(data[0]);
        System.out.println("Expected: " + prevSize);
        System.out.println(q.getSize());
        System.out.println();
        q.poll();
        System.out.println("Expected: " + (prevSize - 1));
        System.out.println(q.getSize());
        System.out.println();
        q.offer(data[0]);
        System.out.println("Expected: " + prevSize);
        System.out.println(q.getSize());
        //checking clear
        q.clear();
        System.out.println();
        System.out.println("Expected: ( )");
        System.out.println(q.toString());
        //checking enqueue and getCapacity
        q.enqueue(data[0]);
        System.out.println();
        System.out.println("Expected: ( " + data[0] + " )");
        System.out.println(q.toString());
        System.out.println();
        System.out.println("Expected: class java.lang.IllegalArgumentException: Cannot enqueue the element as it's null");
        try {
            q.enqueue(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        System.out.println();
        System.out.println("Expected: class java.lang.IllegalStateException: " + "Cannot enqueue " + data[data.length-1] + " because the queue only has a capacity of " + q.getCapacity());
        try {
            for (E item : data) 
                q.enqueue(item);
        }
        catch (IllegalStateException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking offer
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(q.offer(null));
        System.out.println();
        System.out.println("Expected: false");
        System.out.println(q.offer(data[data.length - 1]));
        System.out.println();
        System.out.println("Expected: true");
        q.dequeue();
        System.out.println(q.offer(data[data.length - 1]));
        //checking dequeue
        System.out.println();
        System.out.println("Expected: " + data[0]);
        System.out.println(q.dequeue());
        System.out.println();
        System.out.println("Expected: class java.util.NoSuchElementException: Cannot dequeue front element as the queue is Empty");
        q.clear();
        try {
            q.dequeue();
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking poll
        System.out.println();
        System.out.println("Expected: null");
        System.out.println(q.poll());
        q.enqueue(data[0]);
        q.enqueue(data[1]);
        System.out.println();
        System.out.println("Expected: " + data[0]);
        System.out.println(q.poll());
        //checking element
        System.out.println();
        System.out.println("Expected: " + data[1]);
        System.out.println(q.element());
        q.clear();
        System.out.println();
        System.out.println("Expected: class java.util.NoSuchElementException: Can't return element because Queue is empty");
        try {
            q.element();
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        //checking peek
        q.enqueue(data[0]);
        q.enqueue(data[1]);
        System.out.println();
        System.out.println("Expected: " + data[0]);
        System.out.println(q.peek());
        System.out.println();
        System.out.println("Expected: null");
        q.clear();
        System.out.println(q.peek());
        //checking rear
        for (E items : data) {
            q.enqueue(items);
        }
        System.out.println();
        System.out.println("Expected: " + data[data.length - 1]);
        System.out.println(q.rear());
        //checking clone
        CircularQueue<E> queue = q.clone();
        System.out.println();
        System.out.println("Expected: " + q.toString());
        System.out.println(queue.toString());
        System.out.println();
        System.out.println("Expected: " + q.getSize());
        System.out.println(queue.getSize());
        System.out.println();
        System.out.println("Expected: " + q.getCapacity());
        System.out.println(queue.getCapacity());
        //checking insertSorted
        q.clear();
        for (E item : data) {
            q.insertSorted(item);
        }
        System.out.println();
        System.out.println("Expected: " + dataToString);
        System.out.println(q.toString());
        //checking sortQueue
        q.clear();
        for (E item : data) {
            q.enqueue(item);
        }
        q.sortQueue();
        System.out.println();
        System.out.println("Expected: " + dataToString);
        System.out.println(q.toString());
        System.out.println();
        System.out.println("------------------------------ END OF TEST " + testName + " ------------------------------");
        System.out.println();
        System.out.println();
    }
}
