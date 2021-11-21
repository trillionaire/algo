class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        // x, y, c
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < chars.length; i++) {
            int x = i % (2 * numRows - 2);
            int y = i / (2 * numRows - 2) * (numRows - 1);
            int delta = 0;
            if (x >= numRows) {
                y += (x - numRows + 1);
                x = 2 * numRows - 2 - x;
            }
            pq.add(new int[]{x, y, chars[i] - 'A'});
        }
        while (!pq.isEmpty()) {
            sb.append((char)(pq.poll()[2] + 'A'));
        }
        return sb.toString();
    }

}