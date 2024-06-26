import java.util.Arrays;


public class shellsort {
    // Function to perform Shell Sort
    public static void shellsort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    // Function to display the top five scores
    public static void displayTopFiveScores(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Top Five Scores:");
        for (int i = arr.length - 1; i >= Math.max(0, arr.length - 5); i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        // Input: Array of second-year percentages
        int[] percentages = {82, 91, 76, 89, 96, 72, 100, 85, 90, 80};

         // Sorting using Shell Sort
        shellsort(percentages);
        System.out.println("After Shell Sort:");
        System.out.println(Arrays.toString(percentages));

        // Display the top five scores
        displayTopFiveScores(percentages);
    }
}


