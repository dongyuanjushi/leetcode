public class q233 {
    public int countDigitOne(int n) {
        int high = n;
        int low = 0;
        int cur = 0;
        long count = 0;
        int num = 1;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high /= 10;
            if (cur == 0) count += (long) high * num;
            else if (cur == 1) count += (long) high * num + 1 + low;
            else count += (long) (high + 1) * num;
            low = cur * num + low;
            num *= 10;
        }
        return (int) count;
    }
}
