class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = parse(startTime);
        int finish = parse(finishTime);
        final int morning = 0;
        final int midnight = 24 * 60;
        if (start > finish) {
            return getRounds(start, midnight) + getRounds(morning, finish);
        }
        return getRounds(start, finish);
    }

    private int getRounds(int start, int finish) {
        int delta = finish / 15 - (start + 14) / 15;
        delta = Math.max(0, delta);
        return delta;
    }

    private int parse(String s) {
        int hour = Integer.valueOf(s.substring(0, 2));
        int min = Integer.valueOf(s.substring(3, 5));
        return hour * 60 + min;
    }
}