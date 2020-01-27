import java.util.NoSuchElementException;

/***
 * Class implementing immutable queue based on stacks
 * @param <T> Generic Object
 */
public class ImmutableQueue<T> implements Queue<T>
{
    private Stack<T> queue;
    private Stack<T> revertedQueue;

    /***
     * Default constructor
     */
    ImmutableQueue(){
        this.queue = new Stack<T>();
        this.revertedQueue = new Stack<T>();
    }

    /***
     * Constructor when stacks are not empty
     * @param queue Stack<E>
     * @param revertedQueue Stack<E>
     */
    private ImmutableQueue(Stack<T> queue, Stack<T> revertedQueue){
        this.queue = queue;
        this.revertedQueue = revertedQueue;
    }

    /***
     * Adds an element to the queue
     * @param object T
     * @return ImmutableQueue<T>
     */
    public Queue<T> enQueue(T object){
        if(object!=null) {
            return new ImmutableQueue<T>(this.queue.push(object),this.revertedQueue);
        }
        throw new IllegalArgumentException();
    }

    /***
     * Swap the forward stack to the reverse stack
     */
    private void queueToReversed(){
        this.revertedQueue = this.queue.reverseStack();
        this.queue = new Stack<T>();
    }

    /***
     * Removes an element from the queue
     * @return Stack<T>
     */
    public Queue<T> deQueue(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        if(!this.revertedQueue.isEmpty()){
            return new ImmutableQueue<T>(this.queue,this.revertedQueue.getTail());
        }else{
            return new ImmutableQueue<T>(new Stack<T>(),this.queue.reverseStack().getTail());
        }
    }

    /***
     * returns the first element of the queue
     * @return object T
     */
    public T head(){
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (this.revertedQueue.isEmpty())
            queueToReversed();
        return this.revertedQueue.getHead();
    };

    /***
     * Checks if the queue is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return this.queue.getSize() + this.revertedQueue.getSize() == 0;
    };
}