
class Solution {
    public boolean checkRecord(String s) {

        if (s.length() - s.replace("A", "").length() >= 2) {
            return false;
        }

        
        if (s.contains("LLL")) {
            return false;
        }

        return true;
    }
}
