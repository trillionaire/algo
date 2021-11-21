class Solution {
    class Node {
        private String name;
        private int level;

        public Node(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }
    }

    private List<Node> path;
    private int result;

    public int lengthLongestPath(String input) {
        path = new ArrayList<Node>();
        result = 0;
        String[] lines = input.split("\n");
        dfs(lines, 0, path, 0);
        return result;
    }

    private void dfs(String[] lines, int start, List<Node> path, int pathLen) {
        if (start >= lines.length || lines[start].isEmpty()) {
            return;
        }
        String[] words = lines[start].split("\t");
        int level = words.length - 1;
        String name = words[level];
        Node cur = new Node(name, level);
        while (!path.isEmpty() && path.get(path.size() - 1).getLevel() != level - 1) {
            pathLen -= path.get(path.size() - 1).getName().length();
            path.remove(path.size() - 1);
         }

        if (name.contains(".")) {
            result = Math.max(result, pathLen + name.length() + level);
        }
        path.add(cur);
        dfs(lines, start + 1, path, pathLen + name.length());
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }
}