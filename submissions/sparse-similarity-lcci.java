class Solution {
    public List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap();
        int[][] helper = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> list = map.get(docs[i][j]);
                if (list == null) {
                    list = new ArrayList<Integer>();
                    map.put(docs[i][j], list);
                } else {
                    for (Integer k : list) {
                        helper[k][i]++;
                    }
                }
                list.add(i);
            }
        }

        for (int i = 0; i < docs.length - 1; i++) {
            for (int j = i + 1; j < docs.length; j++) {
                if (helper[i][j] == 0) { continue; }
                StringBuilder sb = new StringBuilder();
                sb.append(i).
                    append(",").
                    append(j).
                    append(": ").
                    append(String.format("%.4f", helper[i][j] * 1.0 / (docs[i].length + docs[j].length - helper[i][j])));
                res.add(sb.toString());
            }
            System.out.println();
        }
        return res;
    }

}