class Solution {
  public int candy(int[] ratings) {
    int[][] hash = new int[ratings.length][2];
    for (int i = 0; i < ratings.length; i++) {
      hash[i][1] = i;
      hash[i][0] = ratings[i];
    }
    Arrays.sort(hash, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0]) {
          return o1[0] - o2[0];
        }
        return o1[1] - o2[1];
      }
    });

    int[] candy = new int[ratings.length];
    int lowVal = hash[0][0];
    int lowPos = hash[0][1];
    candy[lowPos] = 1;

    for (int i = 1; i < hash.length; i++) {
      int curVal = hash[i][0];
      int curPos = hash[i][1];

      int curCandy = 1;
      if (curPos != 0 && (ratings[curPos] > ratings[curPos - 1])) {
        curCandy = Math.max(curCandy, candy[curPos - 1] + 1);
      }
      if (curPos != candy.length - 1 && (ratings[curPos] > ratings[curPos + 1])) {
        curCandy = Math.max(curCandy, candy[curPos + 1] + 1);
      }
      candy[curPos] = curCandy;
      lowVal = curVal;
      lowPos = curPos;
    }

    return Arrays.stream(candy).sum();
  }
}