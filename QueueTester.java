import java.util.NoSuchElementException;

public class QueueTester {
    public static void main(String[] args) {
        System.out.println("Integer Tester");
        CircularQueue<Integer> q = new CircularQueue<Integer>(5);
        System.out.println("Expected: true");
        System.out.println(q.isEmpty());
        q.enqueue(10);
        q.enqueue(1);
        q.offer(169);
        q.enqueue(5);
        System.out.println("Expected: 4");
        System.out.println(q.getSize());
        System.out.println("Expected: IllegalArgumentException: Cannot enqueue the element as it's null");
        try {
            q.enqueue(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        System.out.println("Expected: false");
        System.out.println(q.offer(null));
        q.enqueue(3);
        try {
            q.enqueue(11);
        }
        catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }
        System.out.println("Expected: false");
        System.out.println(q.offer(67));
        System.out.println("Expected: ( 10 , 1 ,169 , 5 , 3 )");
        System.out.println(q.toString());
        System.out.println("Expected: true");
        System.out.println(q.isFull());
        System.out.println("Expected: ( 1 , 3 , 5 , 10 , 169 )");
        System.out.println(q.toString());
        q.clear();
        System.out.println("Expected: ( )");
        System.out.println(q.toString());
        System.out.println("Expected: false");
        System.out.println(q.poll());
        System.out.println("Expected: NoSuchElementException: Can't return element because Queue is empty");
        try {
            System.out.println(q.element());
        }
        catch (NoSuchElementException e) {
           System.out.println("NoSuchElementException:" +  e.getMessage());
        }
        q.enqueue(69);
        System.out.println("Expected: 69");
        System.out.println(q.dequeue());
        System.out.println("Expect: NoSuchElementException: Cannot dequeue front element as the queue is Empty");
        try {
            System.out.println(q.dequeue());
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
        }
        System.out.println("Expected: null");
        System.out.println(q.poll());
        q.offer(77);
        System.out.println("Expected: 77");
        System.out.println(q.poll());
        System.out.println("Expected: 77");
        System.out.println(q.peek());
        System.out.println("Expected: 77");
        System.out.println(q.rear());
        q.dequeue();
        System.out.println("Expected: null");
        System.out.println(q.peek());
        System.out.println("Expected: null");
        System.out.println(q.rear());
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        System.out.println("Expected: ( 5 , 10 , 15 )");
        System.out.println(q.toString());
        q.insertSorted(7);
        System.out.println("Expected: ( 5 , 7 , 10 , 15 )");
        q.insertSorted(12);
        System.out.println("Expected: ( 5 , 7 , 10 , 12 , 15 )");
        System.out.println(q.toString());
        q.clear();
        q.enqueue(80);
        q.enqueue(55);
        q.enqueue(47);
        q.enqueue(32);
        q.enqueue(3);
        q.sortQueue();
        System.out.println("Expected: (3 , 32 , 47 , 55 , 80)");
        System.out.println(q.toString());
    }
}
