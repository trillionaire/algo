class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> list = map.getOrDefault(keyName[i], new ArrayList());
            list.add(hash(keyTime[i]));
            map.put(keyName[i], list);
        }
        List<String> res = new ArrayList();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (check(entry.getValue())) {
                res.add(entry.getKey());
            }
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    private boolean check(List<Integer> list) {
        if (list.size() < 3) {
            return false;
        }
        list.sort((a, b) -> (a - b));
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i + 2) <= list.get(i) + 60) {
                return true;
            }
        }
        return false;
    }

    private Integer hash(String s) {
        String h = s.split(":")[0];
        String m = s.split(":")[1];
        return Integer.valueOf(h) * 60 + Integer.valueOf(m);
    }

}