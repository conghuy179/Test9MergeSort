import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    private Scanner sc;
    private int selection;

    public Driver(Scanner sc) {
        this.sc = sc.useDelimiter("\n");
    }

    public void run() {
        do {
            System.out.println("PHAN CONG HUY - FX16513");
            System.out.println("Merge Sort: ");
            System.out.println("Enter number of array (1 to 10): ");
            selection = sc.nextInt();
            if (!isValid(selection)) {
                System.out.println("Only type number from 1 to 10. Try again.");
            }
        } while (!isValid(selection));
        int[] arr = new int[selection];
        System.out.println("Type " + selection + " number in the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Unsorted array: " + Arrays.toString(arr));
        sort(arr, 0, selection - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }

    public boolean isValid(int selection) {
        for (int i = 1; i < 11; i++) {
            if (selection == i) {
                return true;
            }
        }
        return false;
    }

    public void merge(int[] a, int low, int mid, int high) {
        // Merge 2 array: a[low to mid] with a[mid+1 to high].
        int j = mid + 1;

        // Create new array aux to copy the value
        int[] aux = new int[a.length];

        // Copy a[lo..hi] to aux[lo..hi].
        for (int i = low; i <= high; i++)
            aux[i] = a[i];

        for (int i = low; i <= high; i++) // Merge back to a[lo..hi].
            if (low > mid) {
                a[i] = aux[j++];
            } else if (j > high) {
                a[i] = aux[low++];
            } else if (aux[j] < aux[low]) {
                a[i] = aux[j++];
            } else {
                a[i] = aux[low++];
            }
    }

        private void sort (int[] a, int low, int high)
        { // Chia array thanh 2 nua: low -> mid va mid + 1 -> high
            // sort tung nua rieng biet -> merge lai
            if (high <= low) {
                return;
            }
            int mid = low + (high - low) / 2;

            sort(a, low, mid); // Sort nua trai .
            sort(a, mid + 1, high); // Sort nua phai.
            merge(a, low, mid, high); // Merge 2 ben.
        }
}
