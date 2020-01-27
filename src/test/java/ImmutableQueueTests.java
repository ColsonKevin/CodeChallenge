import junit.framework.TestCase;
import org.junit.Test;
import java.util.NoSuchElementException;

/***
 * Class containing the immutable queue tests
 */
public class ImmutableQueueTests extends TestCase {

    @Test(expected = NoSuchElementException.class)
    public void testImmutableQueue() {
        ImmutableQueue a = new ImmutableQueue<Integer>();
        ImmutableQueue b = (ImmutableQueue) a.enQueue(2);
    }
}
