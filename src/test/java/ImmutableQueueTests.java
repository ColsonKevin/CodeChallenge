import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

/***
 * Class containing the immutable queue tests
 */
public class ImmutableQueueTests extends TestCase {

    /***
     * Tests if the class is immutable
     */
    public void testImmutableQueue() {
        ImmutableQueue a = new ImmutableQueue<Integer>();
        ImmutableQueue b = (ImmutableQueue) a.enQueue(2);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            System.out.println(a.head());
        });
    }

    /***
     * Tests functions of the class
     */
    public void testQueuesFunctions() {
        ImmutableQueue<Integer> a = new ImmutableQueue<>();
        assertTrue(a.isEmpty());
        ImmutableQueue b = (ImmutableQueue) a.enQueue(0);
        assertFalse(b.isEmpty());
        assertEquals((int) b.head(), 0);
        assertTrue(b.deQueue().isEmpty());
        ImmutableQueue c = (ImmutableQueue) a.enQueue(5);
        ImmutableQueue d = (ImmutableQueue) c.enQueue(2);
        assertFalse(d.isEmpty());
        assertEquals((int) d.head(), 5);
        ImmutableQueue e = (ImmutableQueue) d.deQueue();
        assertEquals((int) e.head(), 2);
    }
}
