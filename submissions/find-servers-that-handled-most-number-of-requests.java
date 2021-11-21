class Solution {
    // 优先队列 + TreeSet：任务安排模板。
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // <server, free>
        TreeSet<Integer> frees = new TreeSet();
        int busy[] = new int[k];
        for (int i = 0; i < k; i++) {
            frees.add(i);
        }
        // [end, serverId]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0] - b[0]));
        for (int i = 0; i < arrival.length; i++) {
            // 更新pq: 已结束的出队,加入到空闲集合
            int begin = arrival[i];
            while (!pq.isEmpty() && begin >= pq.peek()[0]) {
                frees.add(pq.poll()[1]);
            }
            if (frees.isEmpty()) {
                continue;
            }
            // 当前任务入队。 注意：treeset的ceiling用法!!!
            int id = (frees.ceiling(i % k) != null) ? frees.ceiling(i % k) : frees.ceiling(-1);
            busy[id]++;
            frees.remove(id);
            pq.add(new int[] {arrival[i] + load[i], id});
        }
        // 计算最忙的服务器：从busy[]找最大值，再遍历
        int busiest = 0;
        for (int i = 0; i < k; i++) {
            busiest = Math.max(busiest, busy[i]);
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < k; i++) {
            if (busy[i] == busiest) {
                res.add(i);
            }
        }
        return res;
    }
}