public class UniqueList {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 5, 7, 2, 3, 3 };
        int size = arr.length;
        uniqueList(arr, size);
    }

    public static void uniqueList(int arr[], int size) {
        // xor of whole list;
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = res ^ arr[i];
        }
        // finding rightmost set bit;
        int i = 0;
        int temp = res;
        while (temp > 0) {
            boolean rs = (temp & 1) != 0 ? true : false;
            if (rs) {
                break;
            }
            i++;
            temp = temp >> 1;
        }
        // finding a mask by using i
        int mask = (1 << i);

        // finding unique elements
        int fNumber = 0;
        int sNumber = 0;
        for (int j = 0; j < size; j++) {
            boolean rs = (mask & arr[j]) != 0 ? true : false;
            if (rs) {
                fNumber = fNumber ^ arr[j];
            }

        }
        sNumber = res ^ fNumber;
        System.out.println(fNumber + "   " + sNumber);
    }
}