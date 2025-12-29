/***
 * @author George Leonidou
 * @version 1.0
 * 
 * This class implements a Queue in Java
 */
import java.util.NoSuchElementException;

public class Queue <E extends Comparable<E>> {
    private E[] array;
    private int currentlyStored;
    private int capacity;
    private int front;
    private int tail;

    /**
     * This method is the constructor of the Queue
     * 
     * It initializes the capacity of the Queue with the capacity parameter
     * Time Complexity: O(1)
     * 
     * @param capacity
     */
    public Queue(int capacity){
        this.currentlyStored = 0;
        this.capacity = capacity;
        this.array = (E[]) new Object[this.capacity];
    }

    /**
     * This method checks if the Queue is empty
     * Time Complexity: O(1)
     * 
     * @return true if the Queue is empty
     */
    private boolean isEmpty(){ 
        return this.currentlyStored == 0;
    }

    /***
     * This method checks if the Queue is Full
     * Time Complexity: O(1)
     * 
     * @return true if the Queue is full
     */
    private boolean isFull() {
        return this.currentlyStored == this.capacity;
    }
    
    /**
     * This method returns how many elements are in the queue
     * 
     * @return The number of elements in the queue
     */
    public int getSize() {
        return this.currentlyStored;
    }

    /**
     * This method inserts an element to the Queue and if it can't, throws exception
     * Time Complexity: O(1)
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
        this.array[this.currentlyStored++] = element;
    }

    /**
     * This method inserts an element to the Queue and if it can't, returns false
     * Time Complexity: O(1)
     * 
     * @param element The element to be inserted 
     * @return false if the element can't be inserted
     */
    public boolean offer(E element) {
        if (isFull() || element == null)
            return false;
        this.array[this.currentlyStored++] = element;
        return true;
    }

    /**
     * This method removes the head from the Queue and if it can't, throws exception
     * Time Complexity: O(n)
     * 
     * @return the head of the Queue
     * @throws NoSuchElementException if the Queue is empty and there's no head to dequeue
     */
    public E dequeue() throws NoSuchElementException{
        if (isEmpty())
            throw new NoSuchElementException("Cannot dequeue front element as the queue is Empty");
        E head = this.array[0];
        this.array[0] = null;
        for (int i = 1; i < this.currentlyStored; i++) {
            this.array[i-1] = this.array[i];
        }
        this.currentlyStored--;
        return head;
    }

    /**
     * This method removes the head from the Queue and if it can't, returns null
     * Time Complexity: O(n)
     * 
     * @return The head of the Queue or null if the Queue is empty
     */
    public E poll() {
        if (isEmpty())
            return null;
        E head = this.array[0];
        this.array[0] = null;
        for (int i = 1; i < this.currentlyStored; i++) {
            this.array[i - 1] = this.array[i];
        }
        this.currentlyStored--;
        return head;
    }
    
    /**
     * This method returns the head of the Queue and if it can't, throws exception
     * Time Complexity: O(1)
     * 
     * @return the head of the Queue
     * @throws NoSuchElementException  if the Queue is empty and there's no head to return
     */
    public E element() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Can't return element because Queue is empty");
        return this.array[0];
    }

    /**
     * This method returns the head of the Queue and if it can't, returns null
     * Time Complexity: O(1)
     * 
     * @return The head of the Queue or null if the Queue is empty
     */
    public E peek() {
        if (isEmpty())
            return null;
        return this.array[0];
    }

    /**
     * This method inserts an element to the Queue and if it can't, throws exception
     * Time Complexity: O(n)
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
        int position = this.currentlyStored;
        for (int i = 0; i < this.currentlyStored; i++) {
            if (this.array[i].compareTo(element) > 0) {
                position = i;
                break;
            }
        }
        for (int i = this.currentlyStored; i > position; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[position] = element;
        this.currentlyStored++;
    }
    
    /**
     * This method sorts the queue if it's not already sorted
     * Time Complexity: O(n^2)
     */
    public void sortQueue() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("Cannot sort queue as it's empty");
        Queue<E> q = new Queue<E>(this.currentlyStored);
        int stored = this.currentlyStored;
        for (int i = 0; i < stored; i++) {
            q.insertSorted(this.array[i]);
        }
        for (int i = 0; i < this.currentlyStored; i++)
            this.array[i] = q.dequeue();
    }
}