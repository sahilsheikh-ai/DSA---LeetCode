class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        HashMap<String, Integer> map = new HashMap<>();

        // Required frequency of each word
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting offset
        for (int start = 0; start < wordLen; start++) {

            int left = start;
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            for (int right = start;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Word is not present in words
                if (!map.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                // Same word appears too many times
                while (seen.get(word) > map.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                // All words are present
                if (count == wordCount) {
                    ans.add(left);

                    // Move window forward
                    String leftWord = s.substring(left, left + wordLen);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}