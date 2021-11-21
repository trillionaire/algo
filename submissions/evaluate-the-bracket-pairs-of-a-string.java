class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = buildMap(knowledge);
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("\\(");
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i].indexOf(')');
            if (index <= 0) {
                sb.append(arr[i]);
                continue;
            }
            String key = arr[i].substring(0, index);
            if (map.containsKey(key)) {
                sb.append(map.get(key));
            } else {
                sb.append("?");
            }
            sb.append(arr[i].substring(index + 1, arr[i].length()));
        }
        return sb.toString();
    }

        private Map<String, String> buildMap(List<List<String>> knowledge) {
        Map<String, String> map = new HashMap();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        return map;
    }
}