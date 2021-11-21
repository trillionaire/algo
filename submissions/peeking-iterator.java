// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        private Deque<Integer> deque;
        public PeekingIterator(Iterator<Integer> iter) {
            // initialize any member here.
            deque = new LinkedList<Integer>();
            while (iter.hasNext()) {
                deque.add(iter.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return deque.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return deque.pollFirst();
        }

        @Override
        public boolean hasNext() {
            return deque.size() > 0;
        }
    }