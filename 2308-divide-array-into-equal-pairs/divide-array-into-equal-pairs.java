class Solution {
    public boolean divideArray(int[] nums) {
        int result=0;
        int sum=0;
        Set<Integer> set=new HashSet();
        for(int i:nums){
            if(set.contains(i)){
                sum -= i;
                set.remove(i);
            }else{
                sum +=i;
                set.add(i);
            }
            result ^= i;
        }
        System.out.println(sum);
        return result == 0 && sum==0 && set.size()==0;
        
    }
}

/*

[3,2,3,2,2,2]

[9,9,19,10,9,12,2,12,3,3,11,5,8,4,13,6,2,11,9,19,11,15,9,17,15,12,5,14,12,16,18,16,10,3,8,9,16,20,2,4,16,12,11,14,20,16,2,18,17,20,3,13,16,17,1,1,11,20,20,4]


*/