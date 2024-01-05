class Solution {
   public int repeatedNTimes(int[] nums) {
       
        Set<Integer> set=new HashSet();
       for(int i:nums){
           if(!set.add(i)) return i;
           
       }
       return -1;
       
    }
}

/*
[9,5,3,3]
3,3,5,9

1,2,2,2,3,5

x




*/