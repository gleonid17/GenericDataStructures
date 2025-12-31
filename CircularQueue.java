/***
 * @author George Leonidou
 * @version 1.0
 * 
 * This class implements a Queue in Java
 */
import java.util.NoSuchElementException;

public class CircularQueue <E extends Comparable<E>> {
    private E[] array;
    private int currentlyStored;
    private int capacity;
    private int front;

    /**
     * It initializes the capacity of the Queue with the capacity parameter<p>
     * Time Complexity: O(1) <p>
     * Space Complexity: O(n)
     * 
     * @param capacity
     */
    public CircularQueue(int capacity) {
        this.front = 0;
        this.currentlyStored = 0;
        this.capacity = capacity;
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[this.capacity];
        this.array = temp;
    }

    /**
     * This method checks if the Queue is empty<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return true if the Queue is empty
     */
    public boolean isEmpty(){ 
        return this.currentlyStored == 0;
    }

    /***
     * This method checks if the Queue is Full<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return true if the Queue is full
     */
    public boolean isFull() {
        return this.currentlyStored == this.capacity;
    }
    
    /**
     * This method returns how many elements are in the queue<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return The number of elements in the queue
     */
    public int getSize() {
        return this.currentlyStored;
    }

    /**
     * This method clears the queue<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     */
    public void clear() {
        while (this.currentlyStored > 0)
            this.dequeue();
    }

    /**
     * This method inserts an element to the Queue and if it can't, throws exception<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @param element The element to be inserted
     * @throws IllegalStateException if the Queue is Full
     * @throws IllegalArgumentException if the @param element is null
     */
    public void enqueue(E element) throws IllegalStateException, IllegalArgumentException{
        if (element == null) 
            throw new IllegalArgumentException("Cannot enqueue the element as it's null");
        if (isFull())
            throw new IllegalStateException("Cannot enqueue " + element + " because the queue only has a capacity of " + this.capacity);
        int rear = (this.front + this.currentlyStored) % this.capacity;
        this.array[rear] = element;
        this.currentlyStored++;
    }

    /**
     * This method inserts an element to the Queue and if it can't, returns false<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @param element The element to be inserted 
     * @return false if the element can't be inserted
     */
    public boolean offer(E element) {
        if (isFull() || element == null)
            return false;
        int rear = (this.currentlyStored + this.front) % this.capacity;
        this.array[rear] = element;
        this.currentlyStored++;
        return true;
    }

    /**
     * This method removes the head from the Queue and if it can't, throws exception<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return the head of the Queue
     * @throws NoSuchElementException if the Queue is empty and there's no head to dequeue
     */
    public E dequeue() throws NoSuchElementException{
        if (isEmpty())
            throw new NoSuchElementException("Cannot dequeue front element as the queue is Empty");
        E head = this.array[this.front];
        this.array[this.front] = null;
        this.front = (this.front + 1) % this.capacity;
        this.currentlyStored--;
        return head;
    }

    /**
     * This method removes the head from the Queue and if it can't, returns null<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return The head of the Queue or null if the Queue is empty
     */
    public E poll() {
        if (isEmpty())
            return null;
        E head = this.array[this.front];
        this.array[this.front] = null;
        this.front = (this.front + 1) % this.capacity;
        this.currentlyStored--;
        return head;
    }
    
    /**
     * This method returns the head of the Queue and if it can't, throws exception<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return the head of the Queue
     * @throws NoSuchElementException  if the Queue is empty and there's no head to return
     */
    public E element() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Can't return element because Queue is empty");
        return this.array[this.front];
    }

    /**
     * This method returns the head of the Queue and if it can't, returns null<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return The head of the Queue or null if the Queue is empty
     */
    public E peek() {
        if (isEmpty())
            return null;
        return this.array[this.front];
    }

    /**
     * This method returns the rear element of the Queue<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return the rear element of the Queue or null if the Queue is empty
     */
    public E rear() {
        if (isEmpty()) 
            return null;
        return this.array[(this.front + this.currentlyStored - 1) % this.capacity];
    }

    /**
     * This method inserts an element to the Queue and if it can't, throws exception<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param element The element to be inserted
     * @throws IllegalStateException If the Queue is full
     * @throws IllegalArgumentException If the element to be added is null
     */
    public void insertSorted(E element) throws IllegalStateException, IllegalArgumentException {
        if (element == null)
            throw new IllegalArgumentException("Cannot enqueue the element as it's null");
        if (isFull())
            throw new IllegalStateException("Cannot enqueue " + element + " because the queue only has a capacity of " + this.capacity);
        int position = 0;
        while (position < this.currentlyStored) {
            int index = (this.front + position) % this.capacity;
            if(this.array[index].compareTo(element) > 0)
                break;
            position++;
        }
        for (int i = this.currentlyStored; i > position; i--) {
            int current = (this.front + i) % this.capacity;
            int previous = (this.front + i - 1) % this.capacity;
            this.array[current] = this.array[previous];
        }
        int target = (this.front + position) % this.capacity;
        this.array[target] = element;
        this.currentlyStored++;
    }
    
    /**
     * This method sorts the queue if it's not already sorted<p>
     * Time Complexity: O(n^2)<p>
     * Space Complexity: O(n)
     */
    public void sortQueue() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("Cannot sort queue as it's empty");
        CircularQueue<E> q = new CircularQueue<E>(this.currentlyStored);
        int stored = this.currentlyStored;
        for (int i = 0; i < stored; i++)
            q.insertSorted(this.dequeue());
        while (!q.isEmpty())
            this.enqueue(q.dequeue());
    }
    
    /**
     * This method returns the Queue as a String<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(n)
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            return "( )";
        }
        int position = 0;
        str.append("( ");
        int stored = this.currentlyStored;
        while (stored > 1) {
            str.append(this.array[(position + this.front) % this.capacity] + " ,");
            position++;
            stored--;
        }
        str.append(this.array[(this.front + this.currentlyStored - 1) % this.capacity] + " )");
        return str.toString();
    }
}