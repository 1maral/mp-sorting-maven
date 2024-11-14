package edu.grinnell.csc207.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Maral Bat-Erdene
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
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
    sortDivide(values, values.length);
  } // sort(T[])

  private void sortDivide(T[] values, int length) {
    // Divide the array recursively until one element
    if (length > 1) {
      // find the middle
      int middle = length/2;
      // create and store half arrays from the division
      T[] left = Arrays.copyOfRange(values, 0, middle);
      T[] right = Arrays.copyOfRange(values, middle, length);
      sortDivide(left, middle);
      sortDivide(right, length - middle);

      sortMerge(values, left, right, middle, length - middle);
    } // if
  } //sortDivide(T[], int)

  private void sortMerge(T[] values, T[] left, T[] right, int leftlim, int rightlim) {
    int lPointer = 0;
    int rPointer = 0;
    int valPointer = 0;

    while (lPointer < leftlim && rPointer < rightlim) {
      if (this.order.compare(left[lPointer], right[rPointer]) < 0) {
        values[valPointer] = left[lPointer];
        lPointer++;
      } else {
        values[valPointer] = right[rPointer];
        rPointer++;
      } // if/else
      valPointer++;
    } // while

    while(lPointer < leftlim) {
      values[valPointer] = left[lPointer];
      lPointer++;
      valPointer++;
    } // while

    while(rPointer < rightlim) {
      values[valPointer] = right[rPointer];
      rPointer++;
      valPointer++;
    } // while
  } //sortMerge(T[], T[], T[], int, int)
} // class MergeSorter
