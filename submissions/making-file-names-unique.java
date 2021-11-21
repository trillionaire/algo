class Solution {
    // hash： 对name(num) ，使用<name(num), 1>代表自身，另如果已出现从表中找到第一个未出现的num2，并记录<name(num2),1>
    public String[] getFolderNames(String[] names) {
        if (names == null || names.length == 0) {
            return null;
        }
        // 结果字符串数组
        String[] re = new String[names.length];
        // 保存文件出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<names.length; i++) {
            // 如果没有出现过，直接赋值即可
            if (!map.containsKey(names[i])) {
                re[i] = names[i];
                map.put(names[i], 1);
            } else {
                // 如果出现过，先取出之前出现的次数，再判断后序的有没有出现过
                int count=map.get(names[i]);
                while (map.containsKey(names[i] + "(" + count + ")")) {
                    count++;
                }
                // 细节：记得更新
                map.put(names[i] + "(" + count + ")", 1);
                map.put(names[i], map.get(names[i])+1);
                // 本次的结果
                re[i] = names[i] + "(" + count + ")";
            }
        }
        return re;
    }
}