import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    private boolean canDo;

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char ch:s.toCharArray())  {
          int count=map.getOrDefault(ch,0)+1;
            
            if(count> (s.length()+1)/2)
                return "";
            
            map.put(ch,count);
        };
//        if(canDo) return "";
        PriorityQueue<Character> pq = new PriorityQueue<Character>(Comparator.comparing(map::get, Comparator.reverseOrder()));
        StringBuilder str = new StringBuilder();
        pq.addAll(map.keySet());

        while (!pq.isEmpty()) {
            char first = pq.remove();
            if (str.isEmpty() || first != str.charAt(str.length() - 1)) {
                str.append(first);
                map.put(first, map.get(first) - 1);
                if (map.get(first) > 0) pq.add(first);
            } else {
                char second = pq.remove();
                str.append(second);
                map.put(second, map.get(second) - 1);
                if (map.get(second) > 0)
                pq.add(second);
                    pq.add(first);

            }
        }
        return str.toString();
    }
}