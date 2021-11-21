class Solution {
    // 滑动窗口：用atan2取角度，然后+360度拼接解决1/4象限夹角
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int base = 0;
        List<Double> angles = new ArrayList();
        // 调整坐标系，基于loc
        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { base++; continue; }
            angles.add(Math.toDegrees(Math.atan2(dy,dx)));
        }
        // 获取所有角度，+360拼接起来，以处理1/4象限夹角
        Collections.sort(angles, Double::compareTo);
        int size = angles.size();
        for (int i = 0; i < size; i++) {
            angles.add(angles.get(i) + 360);
        }
        // 滑窗
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < angles.size()) {
            if (angles.get(right) - angles.get(left) <= angle) {
                res = Math.max(res, right - left + 1);
            } else {
                while (left <= right) {
                    if (angles.get(right) - angles.get(left) <= angle) {
                        res = Math.max(res, right - left + 1);
                        break;
                    }
                    left++;
                }
            }
            right++;
        }
        return res + base;
    }
}