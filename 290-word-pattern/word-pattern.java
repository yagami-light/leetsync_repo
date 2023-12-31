class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap();
        String[] strArrays=s.split(" ");
        if(pattern.length() != strArrays.length) return false;
        
        for(int i=0;i<pattern.length();i++){
            System.out.println("map is :"+map);
            char ch=pattern.charAt(i);
            if(map.get(ch)!=null ){
                // System.out.println("map value is :"+map.get(ch) +" and strArrays is : "+strArrays[i]);
                if(!strArrays[i].equals(map.get(ch)))
                return false;
            }
            else{
            if(map.containsValue(strArrays[i]))
                return false;
                
                
            map.put(ch,strArrays[i]);
            }
        }
        return true;
        
        
        
    }
}