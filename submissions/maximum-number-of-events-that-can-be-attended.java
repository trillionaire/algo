class Solution {
    //https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/solution/java-dui-pai-xu-tan-xin-onlgnshi-jian-fu-za-du-by-/
    public int maxEvents(int[][] events) {
        if (events.length <= 1) {
            return events.length;
        }
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        int i = 0;
        int ret = 0;
        // pq: keeps ones ok for day by end's up order. 
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int day = 1; day <= 100000; day++) {
            // remove all invalid
            while (!queue.isEmpty() && (queue.peek() < day)) {
                queue.poll();
            }
            // add new meeting start at day
            while (i < events.length && events[i][0] == day) {
                queue.offer(events[i++][1]);
            }
            // pick one which ends first
            if (!queue.isEmpty()) {
                queue.poll();
                ret++;
            }
        }
        return ret;
    }
}