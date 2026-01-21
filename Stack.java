public class Stack<E extends Comparable<E>> {
    Object[] array;
    int top;
    int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new Object[this.capacity];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.capacity - 1;
    }

    public void push(E element) throws IllegalStateException{
        if (!isFull())
            throw new IllegalStateException("Cannot push " + element + " because the Stack is full");
        
    }
}
