class Solution {
    // 并查集：字符串映射。
    // 1. 按账号Id建并查集。
    // 2. 遍历email时进行并查，来建立email到Id的hash表。即：一个email已映射到另一个id时，合并id。
    // 3. 遍历accounts，建立parent[id]的email集合的hash表，即idToEmails。
    // 4. 遍历idToEmails，生成结果。
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // hash: email -> account id
        Map<String, Integer> emailId = new HashMap<String, Integer>();
        // dfu by account account id
        DFU dfu = new DFU(accounts.size());
        // map email to id with dfu
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());
            for (String email : emails) {
                // NOTE：union email if it is related to two ids ！
                if (emailId.containsKey(email)) {
                    dfu.union(i, emailId.get(email));
                } else {
                    emailId.put(email, i);
                }
            }
        }

        // build id to emails hash: index by parent[id]
        Map<Integer, Set<String>> idToEmails = new HashMap();
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());
            int id = dfu.find(i);
            Set<String> set = idToEmails.getOrDefault(id, new HashSet());
            set.addAll(emails);
            idToEmails.put(id, set);
        }

        // convert idToEmails to result
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, Set<String>> entry : idToEmails.entrySet()){
            List<String> emails = entry.getValue().stream().collect(Collectors.toList());
            Collections.sort(emails);
            List<String> cur = new ArrayList<>();
            String name = accounts.get(entry.getKey()).get(0);
            cur.add(name);
            cur.addAll(emails);
            res.add(cur);
        }
        return res;
    }

    class DFU {
        private int[] parents;
        DFU (int n) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px < py) {
                parents[py] = px;
            } else {
                parents[px] = py;
            }
        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
}