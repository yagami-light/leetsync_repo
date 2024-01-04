class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map=new HashMap();
        List<String> list=new ArrayList();
        for(String str: s1.split(" "))
            map.put(str,map.getOrDefault(str,0)+1);
        for(String str: s2.split(" "))
            map.put(str,map.getOrDefault(str,0)+1);
        
        for(String key:map.keySet()){
            if(map.get(key)==1)
                list.add(key);
        }
        
        return list.toArray(new String[0]);
        
    }
}