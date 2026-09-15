import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        s = br.readLine().trim();

        String t = s + s;

        // ans[i] = longest palindrome in rotation starting at i
        int[] ans = new int[n];

        /*
         * Manacher's algorithm on s+s.
         *
         * d1[i] = radius of odd palindrome centered at i
         * d2[i] = radius of even palindrome centered between i-1 and i
         */
        int m = 2 * n;

        int[] d1 = new int[m];
        for (int i = 0, l = 0, r = -1; i < m; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);

            while (i - k >= 0 && i + k < m &&
                   t.charAt(i - k) == t.charAt(i + k)) {
                k++;
            }

            d1[i] = k--;

            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }

        int[] d2 = new int[m];
        for (int i = 0, l = 0, r = -1; i < m; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);

            while (i - k - 1 >= 0 && i + k < m &&
                   t.charAt(i - k - 1) == t.charAt(i + k)) {
                k++;
            }

            d2[i] = k--;

            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }

        /*
         * For every possible rotation start, check palindrome
         * centers that can lie completely inside its n characters.
         *
         * We process all centers and update the rotations whose
         * interval contains that palindrome.
         */
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[] events = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            events[i] = new ArrayList<>();
        }

        // Odd palindromes
        for (int center = 0; center < m; center++) {
            int radius = d1[center];

            int left = center - radius + 1;
            int right = center + radius - 1;

            // Only palindromes of length <= n are useful
            int maxRadius = Math.min(radius, (n + 1) / 2);

            for (int lenRadius = 1; lenRadius <= maxRadius; lenRadius++) {
                int l = center - lenRadius + 1;
                int r = center + lenRadius - 1;

                int from = Math.max(0, r - n + 1);
                int to = Math.min(n - 1, l);

                if (from <= to) {
                    events[from].add(new int[]{
                            2 * lenRadius - 1, to
                    });
                }
            }
        }

        // Even palindromes
        for (int center = 0; center < m; center++) {
            int radius = d2[center];

            for (int k = 1; k <= Math.min(radius, n / 2); k++) {
                int l = center - k;
                int r = center + k - 1;

                int from = Math.max(0, r - n + 1);
                int to = Math.min(n - 1, l);

                if (from <= to) {
                    events[from].add(new int[]{
                            2 * k, to
                    });
                }
            }
        }

        /*
         * Sweep rotations and keep the longest palindrome
         * currently covering each rotation.
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < n; i++) {
            for (int[] event : events[i]) {
                pq.offer(event);
            }

            while (!pq.isEmpty() && pq.peek()[1] < i) {
                pq.poll();
            }

            ans[i] = pq.isEmpty() ? 1 : pq.peek()[0];
        }

        StringBuilder out = new StringBuilder();
        for (int x : ans) {
            out.append(x).append('\n');
        }

        System.out.print(out);
    }
}
