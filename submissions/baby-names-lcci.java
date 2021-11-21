class Solution {
    static class DFU {
        private int n;
        private int[] parents;

        public DFU(int n) {
            this.n = n;
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public void merge(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 < p2) {
                parents[p2] = p1;
            } else {
                parents[p1] = p2;
            }
        }

        public int find(int n) {
            if (parents[n] != n) {
                parents[n] = find(parents[n]);
            }
            return parents[n];
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> cntMap = new HashMap();
        Map<String, Integer> posMap = new HashMap();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String nameStr = name.substring(0, name.indexOf('('));
            String cntStr = name.substring(name.indexOf('(') + 1, name.length() - 1);
            int cnt = Integer.valueOf(cntStr);
            cntMap.put(nameStr, cnt);
        }

        for (int i = 0; i < synonyms.length; i++) {
            String[] list = parseSynonyms(synonyms[i]);
            if (!cntMap.containsKey(list[0])) {
                cntMap.put(list[0], 0);
            }
            if (!cntMap.containsKey(list[1])) {
                cntMap.put(list[1], 0);
            }
        }

        List<String> nameList = cntMap.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < nameList.size(); i++) {
            posMap.put(nameList.get(i), i);
        }

        DFU dfu = new DFU(cntMap.size());
        for (int i = 0; i < synonyms.length; i++) {
            String[] list = parseSynonyms(synonyms[i]);
            dfu.merge(posMap.get(list[0]), posMap.get(list[1]));
        }
        return getResult(cntMap, posMap, nameList, dfu);
    }

    private String[] getResult(Map<String, Integer> cntMap, Map<String, Integer> posMap, List<String> nameList, DFU dfu) {
        Map<String, Integer> map = new HashMap();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            String name = entry.getKey();
            int cnt = cntMap.get(name);
            if (posMap.containsKey(name)) {
                int id =  posMap.get(name);
                int p = dfu.find(id);
                String pName = nameList.get(p);
                map.put(pName, map.getOrDefault(pName, 0) + cnt);
            } else {
                map.put(name, cnt);
            }
        }

        String[] res = new String[map.size()];
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append('(').append(entry.getValue()).append(')');
            list.add(sb.toString());
        }
        list.sort((a, b) -> a.compareTo(b));
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private String[] parseSynonyms(String synonym) {
        String[] res = new String[2];
        res[0] = synonym.substring(1, synonym.indexOf(','));
        res[1] = synonym.substring(synonym.indexOf(',') + 1, synonym.length() - 1);
        return res;
    }
}