class Solution {
    public double averageWaitingTime(int[][] customers) {
        System.out.println();
        long sum = 0;
        long wait = 0;
        long finish = 0;
        for(int i = 0; i < customers.length; i++) {
            if (finish >= customers[i][0]) {
                finish += customers[i][1]; 
                wait = finish - customers[i][0];
            } else {
                finish = customers[i][0] + customers[i][1];
                wait = customers[i][1];
            }
            sum += wait;
        }
        return 1.0 * sum / (customers.length);
    }
}