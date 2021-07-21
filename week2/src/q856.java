public class q856 {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int res = 0, dep = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') dep++;
            else {
                dep--;
                if (s.charAt(i - 1) == '(') res += 1 << dep;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        q856 q = new q856();
        String s = "((())(((()()))))";
        q.scoreOfParentheses(s);
    }
}
