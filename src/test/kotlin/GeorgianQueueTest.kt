import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GeorgianQueueTest {
    private lateinit var georgianQueue: GeorgianQueue<Int>

    @BeforeEach
    fun setUp() {
        val abc = GeorgianQueue<Int>().apply {

        }
        georgianQueue = GeorgianQueue<Int>().apply {
            offer(1)
            offer(2)
            offer(3)
            offer(4)
            offer(5)
        }
    }

    @Test
    fun `can add the element - offer`() {
        georgianQueue.offer(-5)
        assertEquals(6, georgianQueue.count)
        assertEquals(1, georgianQueue.peek())

    }


    @Test
    fun `can add the element - offerLikeGeorgian`() {
        georgianQueue.apply {
            offer(6)
            poll()
            poll()
            offer(7)
            offer(8)
            offerLikeGeorgian(99)
        }

        assertEquals(99, georgianQueue.next().next!!.data)
        assertEquals(3, georgianQueue.peek())
    }

    @Test
    fun `can add the element - offerLikeGeorgian when empty`() {
        clearQueue()
        georgianQueue.offerLikeGeorgian(99)
        assertEquals(99, georgianQueue.peek())
        assertEquals(1, georgianQueue.count)
    }

    @Test
    fun `can take the element - poll returns the head element`() {
        addFinalElement()
        assertEquals(1, georgianQueue.poll())
    }

    @Test
    fun `can not take the element - poll returns null`() {
        clearQueue()
        assertEquals(null, georgianQueue.poll())
    }

    @Test
    fun `head element found - peek returns the element`() {
        addFinalElement()
        assertEquals(1, georgianQueue.peek())
    }

    @Test
    fun `head element not found - peek returns null`() {
        clearQueue()
        assertEquals(null, georgianQueue.peek())
    }

    @Test
    fun `iterator has no element`() {
        clearQueue()
        assertEquals(false, georgianQueue.hasNext())
    }

    @Test
    fun `iterator has a next element`() {
        assertEquals(true, georgianQueue.hasNext())
        assertEquals(true, georgianQueue.hasNext())
        assertEquals(true, georgianQueue.hasNext())
    }

    @Test
    fun `iterator has a next element after clear`() {
        assertEquals(true, georgianQueue.hasNext())
        clearQueue()
        georgianQueue.offer(123)
        assertEquals(1, georgianQueue.count)
    }

    @Test
    fun next() {
        georgianQueue.next()
        georgianQueue.next()
        georgianQueue.next()
        assertEquals(true, georgianQueue.hasNext())
    }

    @Test
    fun `no next`() {
        clearQueue()
        assertEquals(false, georgianQueue.hasNext())
    }

    private fun addFinalElement() {
        georgianQueue.offer(99)
    }

    private fun clearQueue() {
        while (georgianQueue.hasNext()) {
            georgianQueue.next()
            georgianQueue.poll()
        }
    }
}