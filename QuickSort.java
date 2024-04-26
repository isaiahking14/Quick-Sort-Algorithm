import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        load();
        quickSorted(arr);
    }

    private static void load() throws FileNotFoundException {
                                // change for file
        File number = new File("numbers-4.txt");
        Scanner scan = new Scanner(number);
        int index_count = 0;
        while (scan.hasNextInt()) {
            index_count++;
            scan.nextInt();
        }
        arr = new int[index_count];
        scan.close();

        Scanner scan2 = new Scanner(number);
        index_count = -1;
        while (scan2.hasNextInt()) {
            index_count++;
            arr[index_count] = scan2.nextInt();
        }
        scan2.close();
    }

    static int[] quickSorted(int[] arr) {
        // return array if length = 1
        if (arr.length == 1) {
            return arr;
        }

        int l = 0;
        int r = arr.length - 1;

        return quickSortedRecursive(arr, l, r);
    }

    static int[] quickSortedRecursive(int[] arr, int l, int r) {
        // recursive base case
        if ((r - l) <= 0) {
            return arr;
        }

        int i = l - 1;
        int j = l;

        // set pivot to last index
        int pivot_index = r;
        int temp;

        // loop over partition of array
        while (j < r) {
            if (arr[j] < arr[pivot_index]) {
                i++;
                // swap i and j index's
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;                  
            }
            j++;
        }
        i++;
        
        // swap i and pivot
        temp = arr[i];
        arr[i] = arr[pivot_index];
        arr[pivot_index] = temp;
        
        int pivot = i;
        // left of pivot
        quickSortedRecursive(arr, l, pivot - 1);
        // right of pivot
        quickSortedRecursive(arr, pivot + 1, r);
    
        return arr;

    }

    
}
