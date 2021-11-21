class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> peopleSet = new HashSet<>();
        // 1. found people can'talk
        for (int[] pair : friendships) {
            if (!canTalk(pair[0], pair[1], languages)) {
                peopleSet.add(pair[0]);
                peopleSet.add(pair[1]);
            }
        }

        // 2.
        Map<Integer, Set<Integer>> friends = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            for( int j = 0; j < languages[i].length; j++) {
                Set<Integer> set = friends.getOrDefault(languages[i][j], new HashSet<>());
                set.add(i + 1);
                friends.put(languages[i][j], set);
            }
        }

        // 3. compute language's fd count in set.
        int count = 0;
        for (Map.Entry<Integer, Set<Integer>> e : friends.entrySet()) {
            int lang = e.getKey();
            Set<Integer> people = e.getValue();
            count = Math.max(count, countPeople(people, peopleSet));
        }
        return peopleSet.size() - count;
    }

    private int countPeople(Set<Integer> people, Set<Integer> peopleSet) {
        int res = 0;
        for (Integer i : people) {
            if (peopleSet.contains(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean canTalk(int p1, int p2, int[][] languages) {
        List<Integer> p1Langs = Arrays.stream(languages[p1 - 1]).boxed().collect(Collectors.toList());
        List<Integer> p2Langs = Arrays.stream(languages[p2 - 1]).boxed().collect(Collectors.toList());
        p1Langs.retainAll(p2Langs);
        return !p1Langs.isEmpty();
    }

}