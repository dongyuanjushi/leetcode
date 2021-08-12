public class p11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        p11 p = new p11();
        int[] numbers = {3,4,5,1,2};
        System.out.println(p.minArray(numbers));
    }
}
