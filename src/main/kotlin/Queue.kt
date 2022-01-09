interface Queue<E> : Iterator<Node<E>> {
    /**
     * Inserts the specified element into this queue
     * For more interesting behavior, look at [offerLikeGeorgian] function.
     *
     * @param element the element to add
     */
    fun offer(element: E)

    /**
     * Inserts the specified element into this queue right after the head
     * How you might ask, well, Georgians ¯\_(ツ)_/¯
     *
     * @param element the element to add
     */
    fun offerLikeGeorgian(element: E)

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    fun poll(): E?

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    fun peek(): E?
}