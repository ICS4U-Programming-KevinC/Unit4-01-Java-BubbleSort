import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Does the bubble sort stuff yayy!!!.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-10
 */

// BubbleSort class
public final class BubbleSort {

  /** Private constructor to prevent instantiation. */
  private BubbleSort() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        // Check if line is valid input.
        try {
          int[] arrLine = strToIntArr(line);
          // Call method.
          int[] sortArr = bubbleSort(arrLine);
          // Write to file with a new line.
          for (int i = 0; i < sortArr.length; i++) {
            bufferedWriter.write(arrLine[i] + " ");
          }
        } catch (Exception e) {
          bufferedWriter.write("Please input a number!");
        }
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * For casting to int array.
   *
   * @param str
   * @return Integer array.
   */
  public static int[] strToIntArr(String str) {
    String[] splitArray = str.split(" ");
    int[] array = new int[splitArray.length];

    for (int i = 0; i < splitArray.length; i++) {
      array[i] = Integer.parseInt(splitArray[i]);
    }
    return array;
  }

  /**
   * Does the bubble sort stuff.
   *
   * @param arr
   * @return Returns a sorted int array.
   */
  public static int[] bubbleSort(final int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      // Reset temp and check variable.
      int temp = 0;
      boolean check = true;
      // Loop through the array.
      for (int i = 0; i < arr.length - 1; i++) {
        // Check if the order is correct.
        if (arr[i] <= arr[i + 1]) {
          continue;
        } else {
          // Do the swap!
          check = false;
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
        }
      }
      // Check for making the sorting faster.
      if (check == true) {
        break;
      }
    }
    return arr;
  }
}
