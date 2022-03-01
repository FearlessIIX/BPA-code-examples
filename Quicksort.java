public class Quicksort {

    // Swaps to items in place in an array
    public static void swap(int[] arr, int in1, int in2) {
        int item = arr[in1];
        arr[in1] = arr[in2];
        arr[in2] = item;
    }


    public static void quicksort(int[] arr, int low, int high) {

        // Terminates Recursion when sub-array is of length 1 or less
        if (low < high) {
            // Setting the Pivot to the correct area
            int pivot_index = partition(arr, low, high);

            // Partitioning before the Pivot
            quicksort(arr, low, pivot_index - 1);
            // Partitioning after the Pivot
            quicksort(arr, pivot_index + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Grabbing the right most element in the array as the pivot
        int pivot = arr[high];

        // Rightmost possible position for the pivot
        int bottom = low;

        // For every item from low to before the pivot
        for (int index = low; index < high; index++) {
            int current = arr[index];

            // If current item is less than the pivot
            if (current < pivot) {
                // Swaps the current item and the rightmost position for the pivot
                swap(arr, index, bottom);
                // Increments the rightmost position for the pivot beyond the current element
                bottom++;
            }
        }

        // Puts the pivot in the correct location
        swap(arr, high, bottom);
        return bottom;
    }
}
