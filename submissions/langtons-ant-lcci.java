class Solution {
    public List<String> printKMoves(int k) {
        // [x, y, col, dir]. dir: 0(no), 1(u), 2(r), 3(d), 4(l). col: 0(w), 1(black).
        Map<int[], int[]> nodes = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result;
                if (o1[0] != o2[0]) {
                    result = o1[0] - o2[0];
                } else {
                    result = o1[1] - o2[1];
                }
                return result;
            }
        });
        int[] cPos = {0, 0};
        int[] cVal = {0, 2};
        int step = 0;
        nodes.put(cPos, cVal);
        while (step < k) {
            int[] nVal = update(cVal);
            int[] nPos = forward(cPos, nVal[1]);
            nodes.put(cPos, cVal);
            nVal[0] = nodes.getOrDefault(nPos, new int[]{0, 0})[0];
            cPos = nPos;
            cVal = nVal;
            nodes.put(cPos, cVal);
            step++;
        }
        return getResult(nodes);
    }

    private int[] forward(int[] pos, int dir) {
        int[] res = {pos[0], pos[1]};
        switch (dir) {
            case 1: // U
                res[1]++;
                break;
            case 2:
                res[0]++;
                break;
            case 3:
                res[1]--;
                break;
            case 4:
                res[0]--;
                break;
            default:
                System.out.println("error dir!");
                break;
        }

        return res;
    }

    private int[] update(int[] val) {
        int[] res = {val[0], val[1]};
        if (val[0] == 0) { // white
            val[0] = 1;
            res[1] = (val[1] == 4) ? 1 : (val[1] + 1);
        } else {
            val[0] = 0;
            res[1] = (val[1] == 1) ? 4 : (val[1] - 1);
        }
        val[1] = 0;
        return res;
    }

    private List<String> getResult(Map<int[], int[]> nodes) {
        int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] node : nodes.keySet()) {
            min[0] = Math.min(min[0], node[0]);
            min[1] = Math.min(min[1], node[1]);
            max[0] = Math.max(max[0], node[0]);
            max[1] = Math.max(max[1], node[1]);
        }
        List<String> res = new ArrayList<>();
        for (int j = max[1] - min[1]; j >= 0; j--) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < max[0] - min[0] + 1; i++) {
                int[] val = nodes.getOrDefault(new int[]{i + min[0], j + min[1]}, new int[]{0, 0});
                sb.append(getChar(val));
            }
            res.add(sb.toString());
        }
        return res;
    }

    private char getChar(int[] val) {
        char c = ' ';
        switch (val[1]) {
            case 0:
                c = (val[0] == 0) ? '_' : 'X';
                break;
            case 1:
                c = 'U';
                break;
            case 2:
                c = 'R';
                break;
            case 3:
                c = 'D';
                break;
            case 4:
                c = 'L';
                break;
            default:
                break;
        }
        return c;
    }
}