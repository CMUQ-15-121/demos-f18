import java.util.Scanner;

public class SearchDemo {
    private MyTimer timer;
    private Scanner scanner;

    public SearchDemo() {
        timer = new MyTimer();
        scanner = new Scanner(System.in);

        // Get n from user
        System.out.print("Enter size of array [try 100 thousand]: ");
        int n = scanner.nextInt();

        // Create a sorted array of size n
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        // this method lets the user search for a particular value
        // with both binary & linear search
        System.out.print("Enter value to search for (-1 to end): ");
        int value = scanner.nextInt();
        while (value != -1) {
            // Do a linear search
            timer.startTiming();
            int loc = linearSearch(arr, value);
            timer.stopTiming();
            if (loc != -1)
                System.out.println("linearSearch found it at location " + loc);
            else
                System.out.println("not found...");
            System.out.println("linearSearch took " + timer.elapsedTime() + " milliseconds.");

            // Do a binary search
            timer.startTiming();
            loc = binarySearch(arr, value);
            timer.stopTiming();
            if (loc != -1)
                System.out.println("binarySearch found it at location " + loc);
            else
                System.out.println("not found...");
            System.out.println("binarySearch took " + timer.elapsedTime() + " milliseconds.");

            System.out.print("Enter value to search for (-1 to end): ");
            value = scanner.nextInt();
        }

        /*
         * These methods search for every value in the array to better give a sense of
         * time
         */

        // Binary search
        int elapsedTime = binarySearchAllValues(arr);
        System.out.println("Finished searching for all values with binary search.");
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        System.out.println("Starting linear search...");

        // Linear search
        double sec = linearSearchAllValues(arr);
        System.out.println("Finished searching for all values with linear search.");
        System.out.println("Elapsed time: " + sec + " seconds");

    }

    public int linearSearch(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value)
                return i;
        }
        return -1;
    }

    public int binarySearch(int[] a, int value) {
        int lowIndex = 0;
        int highIndex = a.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            // System.out.println("low = " + lowIndex + "; high = " + highIndex + "; mid = +
            // midIndex);
            if (value < a[midIndex])
                highIndex = midIndex - 1;
            else if (value > a[midIndex])
                lowIndex = midIndex + 1;
            else // found it!
                return midIndex;
        }
        return -1;
    }

    public void userValueSearch(int[] arr, int value) {
        int loc = binarySearch(arr, value);
        if (loc != -1)
            System.out.println("  binarySearch found it at location " + loc);
        else
            System.out.println("  not found...");

    }

    public int binarySearchAllValues(int[] arr) {
        timer.startTiming();
        for (int value = 0; value < arr.length; value++) {
            int loc = binarySearch(arr, value);
        }
        timer.stopTiming();
        return timer.elapsedTime();
    }

    public double linearSearchAllValues(int[] arr) {
        timer.startTiming();
        for (int value = 0; value < arr.length; value++) {
            int loc = linearSearch(arr, value);
        }
        timer.stopTiming();
        return timer.elapsedSeconds();
    }

    public static void main(String[] args) {
        SearchDemo demo = new SearchDemo();
    }
}
