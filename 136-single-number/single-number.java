class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        for(int i:nums){
            
                           map.compute(i,(k,v)->(v==null) ? 1 : v+1);

        }

        for(int i:nums){
            if(map.get(i)==1)
                return i;
        }
        return 0;
        
    }
}