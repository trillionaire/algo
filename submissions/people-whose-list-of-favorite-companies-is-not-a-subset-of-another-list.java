class Solution {
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> sub = new HashSet<>();
    List<Set<String>> sets = new ArrayList<>();
    for (List<String> ss : favoriteCompanies) {
      Set<String> cur = new HashSet<>();
      cur.addAll(ss);
      sets.add(cur);
    }
    
    for (int i = 0; i < sets.size(); i++) {
      for (int j = 0; j < sets.size(); j++) {
        if ((i != j) && sets.get(j).containsAll(sets.get(i))) {
          sub.add(i);
          break;
        }
      }
    }

    for (int i = 0; i < favoriteCompanies.size(); i++) {
      if (!sub.contains(i)) {
        result.add(i);
      }
    }
    return result;
  }
}