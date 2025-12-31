import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTester {
    public static void main(String[] args) {
        System.out.println("Integer Tester");
        CircularQueue<Integer> q = new CircularQueue<Integer>(5);
        System.out.println("Expected: true");
        System.out.println(q.isEmpty());
        q.enqueue(10);
        q.enqueue(1);
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(7);
        assertThrows(IllegalArgumentException.class, () -> ){
            q.enqueue();
        });
        System.out.println("Expected: ( 1 , 3 , 5 , 7 , 10 ");
        System.out.println(q.toString());
        System.out.println("Expected: true");
        System.out.println(q.isFull());
    }
}
