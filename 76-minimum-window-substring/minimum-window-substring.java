class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) &&
                windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // shrink window
            while (left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char ch = s.charAt(left);
                windowMap.put(ch, windowMap.get(ch) - 1);

                if (tMap.containsKey(ch) &&
                    windowMap.get(ch) < tMap.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" 
               : s.substring(start, start + minLen);
    }
}