class StackOfPlates {
    // 模拟：注意cap <= 0的异常场景。
    // 方法一：初始化和push完成后，检查是否要建立空栈。popAt时先消除空栈，再pop。
    // 方法二：初始化时不建新栈。push前检查是否要建空栈。popAt时，先pop再清除空栈。
    // 方法二代码：
    private List<List<Integer>> stacks;
    private int cap;
    public StackOfPlates(int cap) {
        this.cap = cap;
        stacks = new LinkedList();
    }
    
    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == cap) {
            stacks.add(new ArrayList());
        }
        List<Integer> cur = stacks.get(stacks.size() - 1);
        cur.add(val);
    }
    
    public int pop() {
        return popAt(stacks.size() - 1);
    }
    
    public int popAt(int index) {
        // 注意：cap异常分支
        if (cap <= 0) {
            return -1;
        }
        if (index < 0 || index >= stacks.size()) {
            return -1;
        }
        List<Integer> cur = stacks.get(index);
        if (cur.size() == 0) {
            return -1;
        }
        int val = cur.get(cur.size() - 1);
        cur.remove(cur.size() - 1);
        if (cur.size() == 0) {
            stacks.remove(index);
        }
        return val;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */