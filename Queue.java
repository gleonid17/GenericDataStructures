/***
 * @author George Leonidou
 * @version 1.0
 * 
 * This class implements a Queue in Java
 */
import java.util.NoSuchElementException;

public class Queue <E extends Comparable> {
    private E[] array;
    private int currentlyStored;
    private int capacity;

    /***
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

    /***
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
    private boolean isFull(){
        return this.currentlyStored == this.capacity;
    }

    /***
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

    /***
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

    //Time Complexity: O(n)
    /***
     * This method 
     * @return
     * @throws NoSuchElementException
     */
    public E dequeue() throws NoSuchElementException{
        if (isEmpty())
            throw new NoSuchElementException("Cannot dequeue front element as the queue is Empty");
        E head = this.array[0];
        this.array[0] = null;
        for (int i = 1; i < this.currentlyStored + 1; i++) {
            this.array[i-1] = this.array[i];
        }
        this.currentlyStored--;
        return head;
    }

    //Time Complexity: O(1)
    public E poll() {
        if (isEmpty())
            return null;
        E head = this.array[0];
        this.array[0] = null;
        for (int i = 0; i < this.currentlyStored + 1; i++) {
            this.array[i + 1] = this.array[i];
        }
        this.currentlyStored--;
        return head;
    }
    
    //Time Complexity: O(1)
    public E element() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Can't return element because Queue is empty");
        return this.array[0];
    }

    //Time Complexity: O(1)
    public E peek(){ 
        if (isEmpty())
            return null;
        return this.array[0];
    }
}