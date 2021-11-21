class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) { return 0;}
        Queue<Integer> queue = new LinkedList(); // bus
        Set<Integer> visited = new HashSet(); // bus
        Map<Integer, Set<Integer>> busMap = new HashMap(); // <bus, stas>
        Map<Integer, Set<Integer>> staMap = new HashMap(); // <sta, buses>

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                Set<Integer> curBuses = staMap.getOrDefault(routes[i][j], new HashSet<Integer>());
                curBuses.add(i);
                staMap.put(routes[i][j], curBuses);
                Set<Integer> curStas = busMap.getOrDefault(i, new HashSet<Integer>());
                curStas.add(routes[i][j]);
                busMap.put(i, curStas);
            }
        }

        for (int bus : staMap.get(S)) {
            queue.add(bus);
            visited.add(bus);
        }
        int depth = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int bus = queue.poll();
                if (busMap.get(bus).contains(T)) {
                    return depth;
                }
                for (int sta : busMap.get(bus)) {
                    for (Integer next : staMap.get(sta)) {
                        if (!visited.contains(next)) {
                            queue.add(next);
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