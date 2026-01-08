/**
 * This class implements a SinglyLinkedList in Java
 * 
 * @author George Leonidou
 * @version 1.0
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E extends Comparable<E>> {
    
    /**
     * This class represents a Node in the Singly Linked List<p>
     */
    protected class Node {
        E data;
        Node next;

        /**
         * This is the constructor of the Node Class, initializes the data field with a given parameter<p>
         * Time Complexity: O(1)<p>
         * Space Complexity: O(1) 
         * 
         * @param data The data to be stored in the Node
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    protected Node head;
    private int currentlyStored;

    /**
     * This is the constructor of the SinglyLinkedList class, initializes the head to null and the currentlyStored value to 0<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     */
    public SinglyLinkedList() {
        this.head = null;
        this.currentlyStored = 0;
    }

    /**
     * This method returns how many elements are stored in the SinglyLinkedList<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return The number of elements in the Singly Linked List
     */
    public int getSize() {
        return this.currentlyStored;    
    }

    /**
     * This method checks if the Singly Linked List is empry<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @return true if the Singly Linked List is empty
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * This method clears the Singly Linked List<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     */
    public void clear() {
        this.head = null;
        this.currentlyStored = 0;
    }

    /**
     * This method inserts an element at the front of the Singly Linked List<p>
     * Time Complexity: O(1)<p>
     * Space Complexity: O(1)
     * 
     * @param data The data to be inserted
     * @throws IllegalArgumentException if the @param data is null
     */
    public void insertFront(E data) throws IllegalArgumentException{
        if (data == null) 
            throw new IllegalArgumentException("Cannot insert null element");
        Node newHead = new Node(data);
        newHead.next = this.head;
        this.head = newHead;
        this.currentlyStored++;
    }

    /**
     * This method inserts an element at the end of the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param data The data to be inserted
     * @throws IllegalArgumentException if the @param data is null
     */
    public void insertLast(E data) throws IllegalArgumentException{
        if (data == null)
            throw new IllegalArgumentException("Cannot insert null element");
        if (isEmpty()) {
            this.head = new Node(data);
            this.currentlyStored++;
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        this.currentlyStored++;
    }

    /**
     * This method inserts an element to its sorted position in the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param data The data to be inserted
     * @throws IllegalArgumentException if the @param data is null
     */
    public void insertSorted(E data) throws IllegalArgumentException{
        if (data == null)
            throw new IllegalArgumentException("Cannot insert null element");
        if (isEmpty() || this.head.data.compareTo(data) > 0) {
            Node newHead = new Node(data);
            newHead.next = this.head;
            this.head = newHead;
            this.currentlyStored++;
            return;
        }
        Node current = this.head;
        while (current.next != null && current.next.data.compareTo(data) < 0)
            current = current.next;
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        this.currentlyStored++;
    }
    
    /**
     * This method removes an element at a given index from the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param index the index of the element to be removed
     * @return The removed element
     * @throws NoSuchElementException if the index is out of bounds
     */
    public E removeIndex(int index) throws NoSuchElementException{
        if (index > this.currentlyStored || index < 0)
            throw new NoSuchElementException("Index out of bounds");
        if (index == 0) {
            E currentData = this.head.data;
            this.head = this.head.next;
            this.currentlyStored--;
            return currentData;
        }
        Node current = this.head;
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        E currentData = current.next.data;
        current.next = current.next.next;
        this.currentlyStored--;
        return currentData;
    }

    /**
     * This method removes a given element from the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param element The element to be removed
     * @return true if the element is in the list and false if not
     */
    public boolean removeElement(E element) {
        if (this.head == null)
            return false;
        if (this.head.data.equals(element)) {
            this.head = this.head.next;
            this.currentlyStored--;
            return true;
        }
        Node current = this.head;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                current.next = current.next.next;
                this.currentlyStored--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * This method checks if a given element is stored in the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param data The element to be found
     * @return true if the element is found
     */
    public boolean findNode(E data) {
        Node current = this.head;
        while (current != null) {
            if (current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }

    /**
     * This method gets the element at a given index in the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(1)
     * 
     * @param index The index of the element to be returned
     * @return The element at the given index
     * @throws NoSuchElementException if the index is out of bounds
     */
    public E get(int index) throws NoSuchElementException{
        if (index < 0 || index > this.currentlyStored- 1)
            throw new NoSuchElementException("Index out of bounds");
        Node current = this.head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    /**
     * This method creates a clone of the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(n)
     * 
     * @return A clone of the Singly Linked List
     */
    public SinglyLinkedList<E> clone() {
        SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
        if (this.head == null)
            return copy;
        copy.head = new Node(this.head.data);
        copy.currentlyStored = this.currentlyStored;
        Node currentOriginal = this.head.next;
        Node lastAdded = copy.head;
        while (currentOriginal != null) {
            lastAdded.next = new Node(currentOriginal.data);
            currentOriginal = currentOriginal.next;
            lastAdded = lastAdded.next;
        }
        return copy;
    }

    /**
     * This method returns a string representation of the Singly Linked List<p>
     * Time Complexity: O(n)<p>
     * Space Complexity: O(n)
     * 
     * @return A string representation of the Singly Linked List
     */
    public String toString() {
        if (isEmpty())
            return "empty";
        StringBuilder sb = new StringBuilder();
        Node current = this.head;
        while (current.next != null) {
            sb.append(current.data + " -> ");
            current = current.next;
        }
        sb.append(current.data + " -> null");
        return sb.toString();
    }
}
