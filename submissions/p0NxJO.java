class Solution {
    public int magicTower(int[] nums) {
        int res = 0;
        long blood = 1;
        Queue<Integer> remains = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            remains.add(i);
        }

        while (!remains.isEmpty()) {
            int len = remains.size();
            for (int i = 0; i < len; i++) {
                int index = remains.poll();
                int val = nums[index];
                if (val < 0) {
                    pq.add(index);
                }
                blood += val;
                while (blood <= 0 && !pq.isEmpty()) {
                    int cur = pq.poll();
                    blood -= nums[cur];
                    remains.add(cur);
                    res++;
                }
                if (blood <= 0 || res > nums.length - 1) {
                    return -1;
                }
            }
        }
        return res;
    }

}