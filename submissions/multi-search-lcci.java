class Solution {
  public int[][] multiSearch(String big, String[] smalls) {
    int[][] res = new int[smalls.length][];
    for (int i = 0; i < smalls.length; i++) {
      if (smalls[i].equals("")) {
        res[i] = new int[0];
        continue;
      }
      int index = -1;
      List<Integer> list = new ArrayList<Integer>();
      while ((index = big.indexOf(smalls[i], index + 1)) != -1) {
          list.add(index);
      }
      res[i] = list.stream().mapToInt(Integer::intValue).toArray();
    }
    return res;
  }

}