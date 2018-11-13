import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortDemo {
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        boolean didSwap = true;

        // Keep going until we didn't do any swaps during a pass
        while (didSwap) {
            didSwap = false;
            // Make a pass, swapping pairs if needed.
            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1]) {
                    didSwap = true;
                    swap(a, i, i + 1);
                }
            }
            // The previous loop puts the largest value at the end,
            // so we don't need to check that one again.
            n--;
        }
    }

    public void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[indexOfSmallest])
                    indexOfSmallest = j;
            swap(a, i, indexOfSmallest);
        }
    }

    public void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            int valueToInsert = a[index];
            while (index > 0 && valueToInsert < a[index - 1]) {
                a[index] = a[index - 1];
                index--;
            }
            a[index] = valueToInsert;
        }
    }

    public void mergeSort(int[] a) {
        if (a.length > 1) {
            int mid = a.length / 2; // first index of right half
            int[] left = new int[mid];
            for (int i = 0; i < left.length; i++) // create left subarry
                left[i] = a[i];
            int[] right = new int[a.length - mid];
            for (int i = 0; i < right.length; i++) // create right subarray
                right[i] = a[mid + i];
            mergeSort(left); // recursively sort the left half
            mergeSort(right); // recursively sort the right half
            merge(left, right, a); // merge the left and right parts back into a whole
        }
    }

    public void merge(int[] left, int[] right, int[] arr) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (rightIndex == right.length || (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
                arr[i] = left[leftIndex];
                leftIndex++;
            } else {
                arr[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high); // value at pivotIndex will be in correct spot
            quickSort(a, low, pivotIndex - 1); // recursively sort the items to the left (< pivot)
            quickSort(a, pivotIndex + 1, high); // recursively sort the items to the right (>= pivot)
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // select the first value as the pivot value (there are better ways to do this!)
        int boundaryIndex = low + 1; // the index of the first place (left-most) to put a value < pivot
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                if (i != boundaryIndex) { // if it is ==, no swap needed since it's on correct side of partition
                    swap(arr, i, boundaryIndex);
                }
                boundaryIndex++; // must always bump boundary if a smaller element found at arr[i]
            }
        }
        /*
         * boundaryIndex is the first (left-most) index of values >= pivot, because all
         * elements to the left of boundaryIndex are < pivot so we'll swap the pivot (at
         * index high) with the value at boundaryIndex - 1, so pivot is placed correctly
         */
        swap(arr, low, boundaryIndex - 1);
        return boundaryIndex - 1;
    }

    public static void main(String[] args) {
        SortDemo demo = new SortDemo();
        MyTimer t = new MyTimer();

        // Get n from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (try 20 thousand): ");
        int n = scanner.nextInt();

        // Create unsorted array of size n with random ints
        Random random = new Random();
        int[] test = new int[n];
        for (int i = 0; i < n; i++)
            test[i] = random.nextInt();

        String sortType;
        do {
            // make a copy of the initial array (since sort is destructive)
            // so we will always make a fresh copy of the test array
            int[] arr = new int[test.length];
            for (int i = 0; i < test.length; i++)
                arr[i] = test[i];

            // make a copy and sort it to validate our sort methods
            int[] sortedCopy = new int[arr.length];
            for (int i = 0; i < test.length; i++)
                sortedCopy[i] = arr[i];
            Arrays.sort(sortedCopy);

            // select sorting method (first run on a method is always slow due to initial
            // memory allocations)
            System.out.print("Enter one of [b]ubble, [s]elect, [i]nsert, [m]erge, [q]uick, [j]ava built-in, [e]nd: ");
            sortType = scanner.next();
            while (!(sortType.equals("s") || sortType.equals("i") || sortType.equals("m") || sortType.equals("q")
                    || sortType.equals("b") || sortType.equals("j") || sortType.equals("e"))) {
                System.out.println("**Error** - unknown sort type!: " + sortType);
                System.out
                        .print("Enter one of [b]ubble, [s]elect, [i]nsert, [m]erge, [q]uick, [j]ava built-in, [e]nd: ");
                sortType = scanner.next();
            }
            // Time sorting the array until user quits
            t.startTiming();
            if (sortType.equals("s")) {
                demo.selectionSort(arr);
            } else if (sortType.equals("i")) {
                demo.insertionSort(arr);
            } else if (sortType.equals("m")) {
                demo.mergeSort(arr);
            } else if (sortType.equals("q")) {
                demo.quickSort(arr);
            } else if (sortType.equals("b")) {
                demo.bubbleSort(arr);
            } else if (sortType.equals("j")) {
                Arrays.sort(arr);
            } else if (sortType.equals("e")) {
                break;
            }
            t.stopTiming();

            // make sure the method actually sorted the array :-)
            assert Arrays.equals(sortedCopy, arr) : "Array is not sorted correctly!";

            // print timing results (NOTE: first timing of a new sort appears "contaminated"
            System.out.println("Elapsed time: " + t.elapsedTime() + " ms");
        } while (!sortType.equals("e"));
    }
}
