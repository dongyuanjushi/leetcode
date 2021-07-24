public class Sort {
    public Sort() {
    }

    public void heapSort(int[] arr) {
        heapSort hs = new heapSort();
        hs.sort(arr);
        hs.print(arr);
    }

    public void quickSort(int[] arr, int low, int high) {
        quickSort qs = new quickSort();
        qs.sort(arr, low, high);
        qs.print(arr);
    }

    private class heapSort {
        public void sort(int[] arr) {
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                adjustHeap(arr, i, arr.length);
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                int tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
                adjustHeap(arr, 0, i);
            }
        }

        public void print(int[] arr) {
            for (int i : arr) System.out.print(i + " ");
        }

        public void adjustHeap(int[] arr, int idx, int length) {
            int tmp = arr[idx];
            for (int i = 2 * idx + 1; i < length; i = 2 * i + 1) {
                if (i < length - 1 && arr[i] < arr[i + 1]) i++;
                if (arr[i] > tmp) {
                    arr[idx] = arr[i];
                    idx = i;
                } else break;
            }
            arr[idx] = tmp;
        }
    }

    private class quickSort {
        public void sort(int[] arr, int low, int high) {
            if (high <= low) return;
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }

        public int partition(int[] arr, int low, int high) {
            int i = low, j = high + 1;
            while (true) {
                while (arr[++i] < arr[low]) {
                    if (i == high) break;
                }
                while (arr[--j] > arr[low]) ;
                if (i >= j) break;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            int tmp = arr[low];
            arr[low] = arr[j];
            arr[j] = tmp;
            return j;
        }

        public void print(int[] arr) {
            for (int i : arr) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] arr = {5, 1, 3, 2, 4, 6, 8};
//        s.quickSort(arr, 0, arr.length - 1);
        s.heapSort(arr);
    }
}
