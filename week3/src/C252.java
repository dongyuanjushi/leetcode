public class C252 {
    public C252() {

    }

    public void sol() {

    }

    private class sol1 {
        public boolean isThree(int n) {
            if (n == 1 || n == 2) return false;
            int count = 2;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (i < Math.sqrt(n)) count += 2;
                    else count += 1;
                    if (count > 3) return false;
                }
            }
            return count == 3;
        }
    }

    private class sol2 {
        public long numberOfWeeks(int[] milestones) {
            long sum = milestones[0];
            long max = milestones[0];
            for (int i = 1; i < milestones.length; i++) {
                sum += milestones[i];
                max = Math.max(milestones[i], max);
            }
            long dif = 2 * max - sum > 1 ? 2 * max - sum -1 : 0;
            return sum - dif;
        }
    }

    private class sol3 {
        public long minimumPerimeter(long neededApples) {
            long a=1;
            for(long i=1;i<neededApples;i++){
                if(2*i*(i+1)*(2*i+1)>=neededApples){
                    a=i;
                    break;
                }
            }
            return 8*a;
        }
    }

    private class sol4 {

    }

    public static void main(String[] args) {
        C252 c = new C252();
        c.sol();
    }
}
