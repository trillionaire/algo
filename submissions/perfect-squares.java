class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList();
        List<Integer> list = new LinkedList();
        Set<Integer> visited = new HashSet();
        for (int i = 1; i * i <= n; i++) {
            list.add(i*i);
            //System.out.println(i*i);
        }
        q.add(n);
        int depth = 0;
        visited.add(n);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (cur == 0) {
                    return depth;
                }
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (cur >= list.get(j)) {
                        int next = cur - list.get(j);
                        if (!visited.contains(next)) {
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}