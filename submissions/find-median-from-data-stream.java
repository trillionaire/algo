class MedianFinder {
    private PriorityQueue<Integer> big;
    private PriorityQueue<Integer> small;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
      big = new PriorityQueue<>((a, b) -> b - a);
      small = new PriorityQueue<>((a, b) -> a - b);
    }

    // [...b.peek()]   [s.peek, ......]
    public void addNum(int num) {
      if (small.isEmpty() || small.peek() >= num) {
        big.offer(num);
      } else {
        small.offer(num);
      }

      while (big.size() > small.size() + 1) {
        small.offer(big.poll());
      }
      while (small.size() > big.size()) {
        big.offer(small.poll());
      }
    }

    public double findMedian() {
      if (big.size() == small.size() + 1) {
        return (double) big.peek();
      }
      if (big.size() == small.size()) {
        return (big.peek() + small.peek()) / 2.0;
      }
      System.out.println(big.size() + " " + small.size());
      return -1;
    }
  }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */