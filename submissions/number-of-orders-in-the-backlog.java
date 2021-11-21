class Solution {
    // 优先队列：模拟
    public int getNumberOfBacklogOrders(int[][] orders) {
        // buy queue [val, cnt]: down by val
        PriorityQueue<int[]> buyQueue = new PriorityQueue<int[]>((a, b) -> (b[0] - a[0]));
        // sell queue [val, cnt]: up by val
        PriorityQueue<int[]> sellQueue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < orders.length; i++) {
            handleOrder(orders[i], buyQueue, sellQueue);
        }
        return getCount(buyQueue, sellQueue);
    }

    private void handleOrder(int[] order, PriorityQueue<int[]> buyQueue, PriorityQueue<int[]> sellQueue) {
        // sell from buy queue
        if (order[2] == 0) {
            while (canSell(order, sellQueue)) {
                if (consumeOrder(order, sellQueue)) break;
            }
            // remain orders
            if (order[1] > 0) {
                buyQueue.add(order);
            }
        } else {
            while (canBuy(order, buyQueue)) {
                if (consumeOrder(order, buyQueue)) break;
            }
            // remain orders
            if (order[1] > 0) {
                sellQueue.add(order);
            }
        }
    }

    private boolean canBuy(int[] order, PriorityQueue<int[]> buyQueue) {
        return !buyQueue.isEmpty() && buyQueue.peek()[0] >= order[0];
    }

    private boolean canSell(int[] order, PriorityQueue<int[]> sellQueue) {
        return !sellQueue.isEmpty() && sellQueue.peek()[0] <= order[0];
    }

    private boolean consumeOrder(int[] order, PriorityQueue<int[]> queue) {
        int[] pending = queue.poll();
        if (order[1] < pending[1]) {
            pending[1] -= order[1];
            queue.add(pending);
            order[1] = 0;
            return true;
        } else {
            order[1] -= pending[1];
        }
        return false;
    }

    private int getCount(PriorityQueue<int[]> buyQueue, PriorityQueue<int[]> sellQueue) {
        long result = 0;
        for (int[] i : buyQueue) {
            result += i[1];
        }
        result = result % 1000000007;
        for (int[] i : sellQueue) {
            result += i[1];
        }
        result = result % 1000000007;
        return (int) result;
    }
}