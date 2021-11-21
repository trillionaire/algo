class Solution {
  public boolean containsPattern(int[] arr, int m, int k) {
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      while (count <= k) {
        if (!compare(arr, i + count * m, m)) {
          break;
        }
        count++;
      }
      if (count >= k - 1) {
        return true;
      }
    }
    return false;
  }

  private boolean compare(int[] arr, int start, int len) {
    boolean isValid = (start + 2 * len <= arr.length);
    if (!isValid) { return false; }
    for (int i = 0; i < len; i++) {
      if (arr[start + i] != arr[start + len + i]) {
        return false;
      }
    }
    return true;
  }
}