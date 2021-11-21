class StockPrice {
    // 优先队列
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        tm.put(timestamp, price);
        int[] data = new int[] {timestamp, price};
        max.add(data);
        min.add(data);
    }

    public int current() {
        return tm.lastEntry().getValue();
    }

    public int maximum() {
        while (!max.isEmpty() && tm.get(max.peek()[0]) != max.peek()[1]) {
            max.poll();
        }
        return max.peek()[1];
    }

    public int minimum() {
        while (!min.isEmpty() && tm.get(min.peek()[0]) != min.peek()[1]) {
            min.poll();
        }
        return min.peek()[1];
    }
}