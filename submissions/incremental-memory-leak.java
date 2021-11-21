class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int time = 0;
        while (memory1 >= 0 && memory2 >= 0) {
            int max = Math.max(memory1, memory2);
            if (max < time) {
                break;
            }
            if (memory1 >= memory2) {
                memory1 -= time;
            } else {
                memory2 -= time;
            }
            time++;
        }
        return new int[] {time, memory1, memory2};
    }
}