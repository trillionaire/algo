class Solution {
    StringBuilder sb=new StringBuilder();
    List<String> res=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        dfs(0,s,set);
        return res;
    }
    private void dfs(int cur,String s,HashSet<String> set){
        if(cur==s.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=cur;i<s.length();i++){
            if(set.contains(s.substring(cur,i+1))){
                if(sb.length()!=0){
                    sb.append(' ');
                    sb.append(s.substring(cur,i+1));
                    dfs(i+1,s,set);
                    sb.delete(sb.length()-(i+2-cur),sb.length());
                }else{
                    sb.append(s.substring(cur,i+1));
                    dfs(i+1,s,set);
                    sb.delete(sb.length()-(i+1-cur),sb.length());
                }
            }
        }
    }
}