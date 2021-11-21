/*
1215. 步进数
如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。

例如，321 是一个步进数，而 421 不是。

给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。

 

示例：

输入：low = 0, high = 21
输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
 

提示：

0 <= low <= high <= 2 * 10^9
*/

// BFS begin
public List<Integer> countSteppingNumbers(int low, int high) {
    List<Integer> res = new ArrayList<Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();

    if (low == 0) {
        res.add(0);
    }
    for (int i = 1; i < 10; i++) {
            queue.add(i);
    }
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int cur = queue.poll();
            if (cur > high) {
                return res;
            } else if (cur > low) {
                res.add(cur);
            }
            // 注意：不加超时
            if (cur > high / 10) {
                continue;
            }
            int lowBit = cur % 10;
            if (lowBit != 0 && (cur * 10 + lowBit - 1 <= high)) {
                queue.add(cur * 10 + lowBit - 1);
            }
            if (lowBit != 9 && (cur * 10 + lowBit + 1 <= high)) {
                queue.add(cur * 10 + lowBit + 1);
            }
        }
    }
    return res;
}
// BFS end

// DFS begin
public List<Integer> countSteppingNumbers(int low, int high) {
    List<Integer> res = new ArrayList();
    if (low == 0) {
        res.add(0);
    }
    for (int i = 1; i < 10; i++) {
        dfs(i, res, low, high);
    }
    Collections.sort(res);
    return res;
}

private void dfs(int cur, List<Integer> path, int low, int high) {
    if (low <= cur && cur <= high) {
        path.add(cur);
    }
    if (cur > high / 10) {
        return;
    }

    int lowBit = cur % 10;
    if (lowBit != 0 && (cur * 10 + lowBit - 1 <= high)) {
        dfs(cur * 10 + lowBit - 1, path, low, high);
    }
    if (lowBit != 9 && (cur * 10 + lowBit + 1 <= high)) {
        dfs(cur * 10 + lowBit + 1, path, low, high);
    }
}
// DFS end