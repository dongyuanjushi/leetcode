import java.util.ArrayList;
import java.util.List;

public class q93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s.toCharArray(), 0, 0, 0, "");
        for (String r : res) {
            System.out.println(r);
        }
        return res;
    }

    public void dfs(char[] letters, int start, int current, int idx, String str) {
        if (idx == 4) {
            if (start == letters.length) res.add(str);
            return;
        }
        for (int i = start; i < letters.length; i++) {
            int tmp = letters[i] - '0';
            if (i > start && current == 0 && letters[i - 1] == '0') return;
            current = current * 10 + tmp;
            if (current >= 0 && current <= 255) {
                String value = String.valueOf(current);
                if (idx < 3) value += ".";
                dfs(letters, i + 1, 0, idx + 1, str + value);
            }
        }
    }

    public static void main(String[] args) {
        q93 q = new q93();
        String ip = "1231231231234";
        q.restoreIpAddresses(ip);
    }
}
