class Solution {
    public char findTheDifference(String s, String t) {

        int[] map = new int[256];

        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            map[ch - 'a']--;

        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] < 0)
                return (char)(i + 'a');
        }
        return '@';


    }
}