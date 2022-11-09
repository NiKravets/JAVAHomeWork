
import java.util.Arrays;
import java.util.Scanner;

/*Реализовать алгоритм сортировки слиянием*/
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.println("Введите диапазон чисел: ");
        int n = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 2*n - n );
        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,size);
        System.out.println(Arrays.toString(arr));

    }
    public static void mergeSort(int[] input, int size) {
        if (size < 2) return;
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        System.arraycopy(input, 0, left, 0, mid);
        System.arraycopy(input, mid, right, 0, size - mid);

        mergeSort(left, mid);
        mergeSort(right, size - mid);
        merge(input, left, right, mid, size - mid);
    }
    public static void merge(int[] input, int[] left, int[] right, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) input[k++] = left[i++];
            else input[k++] = right[j++];
        }
        while (i < leftLength) input[k++] = left[i++];
        while (j < rightLength) input[k++] = right[j++];
    }
}
