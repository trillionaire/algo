class Solution {
    public int[] asteroidCollision(int[] stars) {
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(stars[0]);
        for (int i = 1; i < stars.length; i++) {
            if (deque.isEmpty()) {
                deque.add(stars[i]);
                continue;
            }
            int top = deque.peekLast();
            boolean pending = true;
            int next = stars[i];
            if (isOk(top, next)) {
                deque.add(next);
                continue;
            }
            while (pending && !isOk(top, next)) {
                if (Math.abs(top) < Math.abs(next)) {
                    deque.pollLast();
                    if (deque.isEmpty()) {
                        break;
                    } else {
                        top = deque.peekLast();
                    }
                } else if (Math.abs(top) == Math.abs(next)) {
                    deque.pollLast();
                    pending = false;
                } else {
                    pending = false;
                }
            }
            if (pending) {
                deque.add(next);
            }
        }
        return deque.stream().mapToInt(i->i).toArray();
    }
    private boolean isOk(int top, int next) {
        return (top > 0 && next > 0) || (top < 0 && next < 0) || (top < 0 && next > 0);
    }
}