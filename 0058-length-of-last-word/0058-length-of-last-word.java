class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // last ke spaces skip karo
        while (s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;

        // last word count karo
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}