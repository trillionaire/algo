class Solution {

    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        // [left, right]
        List<int[]> list = new ArrayList();
        // len : cnt
        Map<Integer, Integer> map = new HashMap();
        if (len == m) {
            return len;
        }
        list.add(new int[] {0, len - 1});
        map.put(len, 1);
        // inverse loop
        for (int i = len - 1; i >= 0; i--) {
            int cur = search(list, arr[i]);
            int left = list.get(cur)[0];
            int right = list.get(cur)[1];
            int leftLen = arr[i] - left - 1;
            int rightLen = right - arr[i] + 1;
            if (leftLen == m || rightLen == m) {
                return i;
            }
            map.put(right - left + 1, map.get(right - left + 1) - 1);
            if (map.get(right - left + 1) == 0) {
                map.remove(right - left + 1);
            }
            list.remove(cur);
            if (rightLen > 0) {
                map.put(rightLen, map.getOrDefault(rightLen, 0) + 1);
                list.add(cur, new int[] {arr[i], right});
            }
            if (leftLen > 0) {
                map.put(leftLen, map.getOrDefault(leftLen, 0) + 1);
                list.add(cur, new int[] {left, arr[i] - 2});
            }
        }
        return -1;
    }
    // bsearch :
    private int search(List<int[]> list, int val) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[0] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }



}