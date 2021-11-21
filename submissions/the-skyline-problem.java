class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // sort by: end up, height down;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });
        TreeMap<Integer, Set<Integer>> heightMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            // remove all ended regions in queue
            while (!queue.isEmpty() && queue.peek()[1] < buildings[i][0]) {
                int[] cur = queue.poll();
                Set<Integer> set = heightMap.get(cur[2]);
                set.remove(cur[3]);
                heightMap.put(cur[2], set);
                if (set.isEmpty()) {
                    heightMap.remove(cur[2]);
                }
                // top height decrease
                if (heightMap.isEmpty() || cur[2] > heightMap.firstKey()) {
                    result.add(Arrays.asList(new Integer[]{cur[1], heightMap.isEmpty() ? 0 : heightMap.firstKey()}));
                }
            }
            // add cur region
            if (heightMap.isEmpty() || buildings[i][2] > heightMap.firstKey()) {
                result.add(Arrays.asList(new Integer[]{buildings[i][0], buildings[i][2]}));
            }
            queue.add(new int[] {buildings[i][0], buildings[i][1], buildings[i][2], i});
            Set<Integer> set = heightMap.getOrDefault(buildings[i][2], new HashSet<>());
            set.add(i);
            heightMap.put(buildings[i][2], set);
        }
        // remove queue
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            Set<Integer> set = heightMap.get(cur[2]);
            set.remove(cur[3]);
            heightMap.put(cur[2], set);
            if (set.isEmpty()) {
                heightMap.remove(cur[2]);
            }
            // top height decrease
            if (heightMap.isEmpty() || cur[2] > heightMap.firstKey()) {
                result.add(Arrays.asList(new Integer[]{cur[1], heightMap.isEmpty() ? 0 : heightMap.firstKey()}));
            }
        }
        // remove duplicate items.
        List<List<Integer>> result2 = new ArrayList();
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i).get(0);
            int val = result.get(i).get(1);
            if (result2.isEmpty() || result2.get(result2.size() - 1).get(0) != index) {
                result2.add(Arrays.asList(new Integer[]{index, val}));
            } else {
                result2.get(result2.size() - 1).set(1, Math.max(val, result2.get(result2.size() - 1).get(1)));
            }
        }
        return result2;
    }

}