import java.util.Arrays;

public class q828 {
    public int uniqueLetterString(String s) {
        int ans = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] preLen = new int[26], pre = new int[26];
        for (int i = 0; i < n;) {
            int c = cs[i++] - 'A';
            int curLen = i - pre[c];
            ans += preLen[c] * curLen;
            preLen[c] = curLen;
            pre[c] = i;
        }
        ++n;
        for (int i = 0; i < 26; ++i)
            ans += preLen[i] * (n - pre[i]);
        return ans % 1000000007;
    }
}
