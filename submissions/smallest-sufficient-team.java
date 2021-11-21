class Solution {
    //https://leetcode-cn.com/submissions/detail/146900630/
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillMap = getSkillMap(req_skills);
        int[] peopleMap = getPeopleMap(people, skillMap);
        int[][] dp = new int[1 << skillMap.size()][];
        // dp: initial
        dp[0] = new int[0];
        int maxSize = 0;
        // dp: dp[x|skills(y)] = dp[x].append(y) when dp[x|y].length > dp[x] + 1. y is new people.
        for (int i = 0; i < peopleMap.length; i++) {
            if (peopleMap[i] == 0) { continue; }
            for (int j = 0; j <= maxSize; j++) {
                if (dp[j] == null) { continue; }
                int comb = j | peopleMap[i];
                // people i is useful to skillset comb,
                // then replace dp[comb] with dp[j] appending people i.
                if (dp[comb] == null || dp[comb].length > dp[j].length + 1) {
                    dp[comb] = Arrays.copyOf(dp[j], dp[j].length + 1);
                    dp[comb][dp[j].length] = i;
                }
            }
            maxSize |= peopleMap[i];
        }
        return dp[(1 << skillMap.size()) - 1];
    }

    private int[] getPeopleMap(List<List<String>> people, Map<String, Integer> skillMap) {
        int[] res = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skill = 0;
            for (int j = 0; j < people.get(i).size(); j++) {
                skill |= 1 << skillMap.get(people.get(i).get(j));
            }
            res[i] = skill;
            // trim people i if skill is subset of people j.
            for (int j = 0; j < i; j++) {
                if (res[j] == 0) {continue;}
                if ((res[i] | res[j]) == res[j]) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

    private Map<String, Integer> getSkillMap(String[] req_skills) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            res.put(req_skills[i], i);
        }
        return res;
    }
}