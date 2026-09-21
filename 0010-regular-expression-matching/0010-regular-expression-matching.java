class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    boolean solve(String s, String p, int i, int j) {

        // Pattern khatam
        if (j == p.length()) {
            return i == s.length();
        }

        boolean match = i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Next character is *
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            return solve(s, p, i, j + 2) ||
                   (match && solve(s, p, i + 1, j));

        } else {
            return match && solve(s, p, i + 1, j + 1);
        }
    }
}