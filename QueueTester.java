public class QueueTester {
    public static void main(String[] args) {
        System.out.println("Integer Tester");
        CircularQueue<Integer> q = new CircularQueue<Integer>(5);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(10);
    }
}
