import java.util.Map.Entry;

class Solution {
/*
*
1: 1
2: 0,5
3: 1,2,3

1: 5
3: 0,1,2,3,4,6
*/
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> res = new ArrayList();
    Map<Integer, List<Integer>> map = new HashMap();

    for (int i = 0; i < groupSizes.length; i++) {
      List<Integer> cur = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
      cur.add(i);
      map.put(groupSizes[i], cur);
    }

    for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
      while (entry.getValue().size() >= entry.getKey()) {
        res.add(entry.getValue().subList(0, entry.getKey()));
        entry.setValue(entry.getValue().subList(entry.getKey(), entry.getValue().size()));
      }
    }
    return res;
  }
}