package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

import edu.grinnell.csc207.main.SortTools;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Maral Bat-Erdene
 */

public class MaralSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public MaralSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    quickSort(values, 0, values.length - 1);
  } // sort(T[])

  private void quickSort(T[] values, int lb, int ub) {
    int [] bounds = dnf(values, lb, ub);

    dnf(values, lb, bounds[0]);
    dnf(values, bounds[1], ub);
  } // quickSort(T[], int, int)

  private int[] dnf(T[] values, int lb, int ub) {
    int pivot = pickPivot(lb, ub);
    T pivotVal = values[pivot];
    int lowerP = lb;
    int equalP = lb;
    int higherP = ub;

    while (lowerP < higherP) {
      if (order.compare(values[equalP], pivotVal) < 0) {
        SortTools.swap(values, equalP, lowerP);
        lowerP++;
        equalP++;
      } else if (order.compare(values[equalP], pivotVal) == 0) {
        SortTools.swap(values, equalP, equalP);
        equalP++;
      } else {
        SortTools.swap(values, equalP, higherP);
        higherP--;
      } // if/else
    } // while

    return new int[] {lowerP, equalP};
  }

  private int pickPivot(int min, int max) {
    // create a random pivot to divide the array
    Random rand = new Random();
    int pivot1 = rand.nextInt(max - min + 1) + min;
    int pivot2 = rand.nextInt(max - min + 1) + min;
    int pivot3 = rand.nextInt(max - min + 1) + min;
    int mid = (low + high) / 2;
    if (arr[low] > arr[mid]) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
    return mid; 
  }
} // class MaralSorter
