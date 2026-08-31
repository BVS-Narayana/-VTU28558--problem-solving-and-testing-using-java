class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] wordToPattern = new int[26];
        int[] patternToWord = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            // Check if mapping matches previous occurrences (use 1-based index to treat 0 as unvisited)
            if (wordToPattern[w] != patternToWord[p]) {
                return false;
            }

            // Store 1-based index of the current position
            wordToPattern[w] = i + 1;
            patternToWord[p] = i + 1;
        }

        return true;
    }
}
