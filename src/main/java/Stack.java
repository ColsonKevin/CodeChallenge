/***
 * Class allowing to manipulate objects the queues are going to contain.
 * @param <E> Generic object
 */
class Stack<E>{

    private E head;
    private Stack<E> tail;
    private int size;

    /***
     * Default constructor
     */
    Stack(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /***
     * Constructor used to add an object, increasing the size of the stack
     * @param object Generic object to add to the stack
     * @param tail Stack<E>
     */
    private Stack(E object, Stack<E> tail){
        this.head = object;
        this.tail = tail;
        this.size = tail.size+1;
    }

    /***
     * Checks if the stack is empty
     * @return boolean
     */
    boolean isEmpty(){
        return this.size == 0;
    }

    /***
     * Adds an object to the stack
     * @param object Generic object to add to the stack
     * @return Stack<E>
     */
    Stack<E> push(E object){
        return new Stack<E>(object,this);
    }

    /***
     * Reverses the stack to handle the queues
     * @return Stack<E>
     */
    Stack<E> reverseStack(){
        Stack<E> newStack = new Stack<E>();
        Stack<E> initial = this;
        while(!initial.isEmpty()){
            newStack = newStack.push(initial.head);
            initial = initial.tail;
        }
        return newStack;
    }

    /***
     * Gets the tail of the stack
     * @return Stack<E>
     */
    Stack<E> getTail() {
        return this.tail;
    }

    /***
     * Returns the head if the stack
     * @return object E
     */
    E getHead() {
        return this.head;
    }

    /***
     * returns the size of the stack
     * @return int
     */
    int getSize() {
        return this.size;
    }
}
