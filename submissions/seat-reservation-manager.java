class SeatManager {
    private TreeSet<Integer> freeSet;
    public SeatManager(int n) {
        freeSet = new TreeSet<Integer>();
        for (int i = 1; i <= n; i++) {
            freeSet.add(i);
        }
    }
    
    public int reserve() {
        return freeSet.pollFirst();
    }
    
    public void unreserve(int seatNumber) {
        freeSet.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */