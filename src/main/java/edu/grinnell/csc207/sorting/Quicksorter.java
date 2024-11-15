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

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
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
    if (values.length < 1) {
      return;
    } // if
    quickSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Performs the recursive Quicksort algorithm on a segment of the array.
   *
   * @param values
   *   The array to be sorted.
   * @param lb
   *   The lower bound (inclusive) of the segment to be sorted.
   * @param ub
   *   The upper bound (inclusive) of the segment to be sorted.
   */
  private void quickSort(T[] values, int lb, int ub) {
    if (lb >= ub) {
      return;
    } // if
    int [] bounds = dnf(values, lb, ub);
    // recursive calls on the two halves
    quickSort(values, lb, bounds[0]);
    quickSort(values, bounds[1], ub);
  } // quickSort(T[], int, int)

  /**
   * Performs the Dutch National Flag partitioning algorithm to partition
   * the array segment around a pivot value.
   *
   * @param values
   *   The array being partitioned.
   * @param lb
   *   The lower bound (inclusive) of the segment to partition.
   * @param ub
   *   The upper bound (inclusive) of the segment to partition.
   * @return
   *   An array of two integers: the index of the last element in the
   *   lower partition and the index of the first element in the upper
   *   partition.
   */
  private int[] dnf(T[] values, int lb, int ub) {
    int pivot = pickPivot(lb, ub);
    T pivotVal = values[pivot];
    int lowerP = lb;
    int equalP = lb;
    int higherP = ub;
    while (equalP <= higherP) {
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
    if (lb > ub) {
      System.err.println("Lower bound must be larger than upper bound");
    } // if
    return new int[] {lowerP, equalP};
  } // dnf(T[], int, int)

  /**
   * Selects a pivot for the Quicksort algorithm using a
   * random value within the specified range.
   *
   * @param min
   *   The minimum index in the range.
   * @param max
   *   The maximum index in the range.
   * @return
   *   The index of the chosen pivot.
   */
  private int pickPivot(int min, int max) {
    // create a random pivot to divide the array
    Random rand = new Random();
    return (rand.nextInt(max - min + 1) + min);
  } // pickPivot(int, int)
} // class Quicksorter
