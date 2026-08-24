class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int countA = 0, countB = 0;

        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                countA++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                countB++;
            }
        }

        return countA == countB;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
