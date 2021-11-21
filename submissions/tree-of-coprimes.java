class Solution {
    // DFS ：map记录最近祖先
    // https://leetcode-cn.com/problems/tree-of-coprimes/solution/shen-du-you-xian-sou-suo-yu-xian-zhao-da-t0jp/
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private Map<Integer, List<Integer>> G = new HashMap<>();
    private int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 1; i <= 50; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }

        for(int[] edge : edges) {
            G.putIfAbsent(edge[0], new ArrayList<>());
            G.putIfAbsent(edge[1], new ArrayList<>());
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }

        dfs(nums, 0, -1, new HashMap<Integer, Integer>());

        return ans;
    }

    void dfs(int[] nums, int u, int fa, HashMap<Integer, Integer> record) {
        if(record.containsKey(nums[u])) {
            ans[u] = record.get(nums[u]);
        }
        HashMap<Integer, Integer> newMap = new HashMap<>(record);
        for(int num : map.get(nums[u])) {
            newMap.put(num, u);
        }
        if(G.containsKey(u))
            for(int v : G.get(u)) {
                if(v != fa) {
                    dfs(nums, v, u, newMap);
                }
            }
    }

    public int gcd(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }
}