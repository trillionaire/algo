class Solution {
    private final static int MOD = 1000000007;
    private int inc;
    private int dec;
    private int[] jump;
    private int[] cost;
    private Map<Long, Long> map;

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        this.inc = inc;
        this.dec = dec;
        this.jump = jump;
        this.cost = cost;
        map = new HashMap<>();
        return (int) (dfs(target) % MOD);
    }

    private long dfs(long target) {
        if (target == 0) {
            return 0;
        }

        if (target == 1) {
            return inc;
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        long res = target * inc;
        for (int i = 0; i < jump.length; i++) {
            long from = target / jump[i];
            long remain = target % jump[i];
            if (remain == 0) {
                res = Math.min(res, dfs(from) + cost[i]);
            } else {
                res = Math.min(res, dfs(from + 1) + cost[i] + (jump[i] - remain) * dec);
                res = Math.min(res, dfs(from) + cost[i] + remain * inc);
            }
        }
        map.put(target, res);
        return res;
    }
}