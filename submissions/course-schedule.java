class Solution {
    static class Graph {
        private ArrayList<Integer>[] adjlist;
        private int[] indegree;
        private int size;
        public Graph(int n) {
            indegree = new int[n];
            adjlist = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjlist[i] = new ArrayList();
            }
            size = n;
        }

        public void addEdge(int i, int j) {
            adjlist[i].add(j);
            indegree[j]++;
        }

        public boolean topologySort() {
            int cnt = 0;
            boolean[] visited = new boolean[size];
            Stack<Integer> zeros = new Stack();
            for (int i = 0; i < size; i++) {
                if (indegree[i] == 0) {
                    visited[i] = true;
                    zeros.push(i);
                }
            }
            while (!zeros.isEmpty()) {
                int cur = zeros.pop();
                visited[cur] = true;
                cnt++;
                List<Integer> list = adjlist[cur];
                for (int i = 0; i < list.size(); i++) {
                    if (!visited[list.get(i)]) {
                        indegree[list.get(i)] -= 1;
                        if (indegree[list.get(i)] == 0) {
                            zeros.push(list.get(i));
                        }
                    }
                }
            }
            return (cnt == size);
        }

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int m = prerequisites.length;
        Graph g = new Graph(numCourses);
        for (int i = 0; i < m; i++) {
            g.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }
        return g.topologySort();
    }
}