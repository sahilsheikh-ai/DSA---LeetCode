
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            List<String> line = new ArrayList<>();
            int letters = 0;

            while (i < words.length && letters + words[i].length() + line.size() <= maxWidth) {
                line.add(words[i]);
                letters += words[i].length();
                i++;
            }

            StringBuilder sb = new StringBuilder();
            int gaps = line.size() - 1;

            if (i == words.length || gaps == 0) {
                for (int j = 0; j < line.size(); j++) {
                    if (j > 0) sb.append(" ");
                    sb.append(line.get(j));
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaces = maxWidth - letters;
                int evenSpaces = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int j = 0; j < gaps; j++) {
                    sb.append(line.get(j));
                    int count = evenSpaces + (j < extraSpaces ? 1 : 0);

                    for (int k = 0; k < count; k++) {
                        sb.append(" ");
                    }
                }

                sb.append(line.get(line.size() - 1));
            }

            result.add(sb.toString());
        }

        return result;
    }
}
