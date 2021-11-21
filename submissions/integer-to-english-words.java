class Solution {
    // 模拟
    private final static String[] MOD = {"Billion", "Million", "Thousand", ""};
    private final static String[] TEENS = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TYS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        // 注意：依次除1e9, 1e6, 1e3, 1获取截断位
        for (int i = (int) 1e9, j = 0; i > 0; i /= 1000, j++) {
            if (num / i % 1000 == 0) {
                continue;
            }
            sb.append(str2Num(num / i % 1000));
            sb.append(" ");
            sb.append(MOD[j]);
            if (i != 1) {
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String str2Num(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20) {
            return TEENS[num];
        } else if (num < 100) {
            sb.append(TYS[num / 10]);
            if (num % 10 != 0) {
                sb.append(" ").append(TEENS[num % 10]);
            }
        } else {
            sb.append(TEENS[num / 100]).append(" Hundred");
            if (num % 100 != 0) {
                sb.append(" ").append(str2Num(num % 100));
            }
        }
        return sb.toString();
    }
}