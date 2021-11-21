class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      if (s.length() == 0) {
          return true;
      }
        if (s.length() >= 149) {
            return false;
        }
      for (String prev : wordDict) {
          if (prev.length() > s.length()) {
              continue;
          } 
          String next = s.substring(prev.length());
          if (s.startsWith(prev) && wordBreak(next, wordDict)) {
              return true;
          }
      }
      return false;
  }
}