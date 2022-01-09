class GeorgianQueue<E> : Queue<E> {
    private var iterator: Node<E>? = null
    private var tail: Node<E>? = null
    private var head: Node<E>? = null
    var count = 0
        private set

    /**
     * Inserts the specified element into this queue
     * For more interesting behavior, look at [offerLikeGeorgian] function.
     *
     * @param element the element to add
     */
    override fun offer(element: E) {
        val node = Node(element)

        // if the queue is empty both tail and the head points to the same node
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }

        count++
    }

    /**
     * Inserts the specified element into this queue right after the head
     * How you might ask, well, Georgians ¯\_(ツ)_/¯
     *
     * @param element the element to add
     */
    override fun offerLikeGeorgian(element: E) {
        val node = Node(element)

        if (head == null) {
            head = node
            tail = node
        } else {
            val temp = head?.next
            head?.next = node
            node.next = temp
        }

        count++
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    override fun poll(): E? {
        if (head == null) {
            return null
        }

        val temp = head
        head = head?.next
        /* if there are no more elements as a head, means the queue
         is empty and update the tail as well
         */
        if (head == null) {
            tail = null
        }
        count--

        return temp?.data
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    override fun peek(): E? {
        if (head == null) {
            return null
        }
        return head?.data
    }

    override fun hasNext(): Boolean {
        return if (iterator == null) {
            head!!.next != null
        } else {
            iterator!!.next != null
        }

    }

    override fun next(): Node<E> {
        iterator = if (iterator == null) {
            head!!
        } else {
            iterator!!.next!!
        }
        return iterator as Node<E>
    }
}