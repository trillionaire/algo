class Solution {
    Set<String> res = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        backtrace(tiles, new StringBuilder(), visited);
        return res.size() - 1;
    }

    private void backtrace(String tiles, StringBuilder path, boolean[] visited) {
        //if (path.length() > tiles.length()) {
        //    return;
        //}
        res.add(path.toString());
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.append(tiles.charAt(i));
            backtrace(tiles, path, visited);
            visited[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}