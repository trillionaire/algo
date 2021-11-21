class Solution {
  // 数学：筒填充
  // https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
  public int leastInterval(char[] tasks, int n) {
      int maxCount = 0; // ["A","A","A","B","B","B"] : 3 means 3 A or 3 B
      int maxCountFreq = 0; // ["A","A","A","B","B","B"] : 2 means A and B
      HashMap<Character, Integer> charCountMap = new HashMap<>();
      // make task freq map and get max freq
      for (Character task : tasks) {
        int freq = charCountMap.getOrDefault(task, 0) + 1;
        charCountMap.put(task, freq);
        if (freq > maxCount) {
          maxCount = freq;
        }
      }
      // get max freq count
      for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
        if (entry.getValue() == maxCount) {
          maxCountFreq++;
        }
      }
      // 总时间 = 前面桶（耗时固定） + 最后一桶（不需要填满）= (桶个数 - 1) * (n + 1) + 最后一桶的任务数
      int result1 = (n + 1) * (maxCount - 1) + maxCountFreq;
      int result2 = tasks.length;
      return Math.max(result1, result2);
  }
}