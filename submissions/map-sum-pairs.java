class MapSum {

    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                result += entry.getValue();
            }
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */