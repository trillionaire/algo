class MyCalendarThree {
    // 数学：边界计数。用treemap来按顺序表示某时间的预订变化情况。start时,值加一。end时，值减一。
    private TreeMap<Integer, Integer> books;

    public MyCalendarThree() {
        books = new TreeMap();
    }
    
    public int book(int start, int end) {
        books.put(start, books.getOrDefault(start, 0) + 1);
        books.put(end, books.getOrDefault(end, 0) - 1);
        int res = 0;
        int sum = 0;
        for (int val : books.values()) {
            sum += val;
            res = Math.max(res, sum);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */