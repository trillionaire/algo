class Solution {
    // 双栈： 计算模板
    // https://leetcode-cn.com/problems/basic-calculator-ii/solution/shi-yong-shuang-zhan-jie-jue-jiu-ji-biao-c65k/
    private Map<Character, Integer> priority =
        new HashMap() {
            {
                put('+', 1);
                put('-', 1);
                put('*', 2);
                put('/', 2);
                put('%', 2);
                put('^', 3);
            }
        };

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque();
        Deque<Character> ops = new ArrayDeque<>();
        String formatted = "0" + s;
        char[] chars = formatted.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            // 左括号： 入ops栈
            if (c == '(') {
                ops.addLast(c);
            }
            // 右括号： 计算到最近的一个（为止，再ops弹出最近的（
            handleRightBracket(nums, ops, c);
            // 数字： 获取完整数字入nums栈，前进至最后一个数字
            i = handleNum(nums, chars, i, c);
            // 操作符： 先预处理(+ 这种情况，变成(0+。再
            handleOp(nums, ops, chars, i, c);
        }
        // 计算剩余内容：到ops为空
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    private void handleOp(Deque<Integer> nums, Deque<Character> ops, char[] chars, int i, char c) {
        if (priority.containsKey(c)) {
            if (i > 0 && (chars[i - 1] == '(' /* || chars[i - 1] == '+' || chars[i - 1] == '-'*/)) {
                nums.addLast(0);
            }
            while (!ops.isEmpty() && ops.peekLast() != '(') {
                if (priority.get(ops.peekLast()) >= priority.get(c)) {
                    calc(nums, ops);
                } else {
                    break;
                }
            }
            ops.addLast(c);
        }
    }

    private int handleNum(Deque<Integer> nums, char[] chars, int i, char c) {
        if (Character.isDigit(c)) {
            int num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + (chars[i++] - '0');
            }
            nums.addLast(num);
            i--;
        }
        return i;
    }

    private void handleRightBracket(Deque<Integer> nums, Deque<Character> ops, char c) {
        if (c == ')') {
            while (!ops.isEmpty()) {
                if (ops.peekLast() != '(') {
                    calc(nums, ops);
                } else {
                    ops.pollLast();
                    break;
                }
            }
        }
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        int next = nums.pollLast();
        int pre = nums.pollLast();
        char op = ops.pollLast();
        int result = 0;
        switch (op) {
            case '+':
                result = pre + next;
                break;
            case '-':
                result = pre - next;
                break;
            case '*':
                result = pre * next;
                break;
            case '/':
                result = pre / next;
                break;
        }
        nums.addLast(result);
    }
}