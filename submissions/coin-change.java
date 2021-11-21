class Solution {
  // DFS： 记忆化搜索  
  Map<Integer, Integer> memo = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    if (memo.containsKey(amount)) {
      return memo.get(amount);
    }
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, amount - coin);
      if (res < min && res >= 0) {
        min = Math.min(res + 1, min);
      }
    }
    min = (min != Integer.MAX_VALUE) ? min : -1;
    memo.putIfAbsent(amount, min);
    return min;
  }
}