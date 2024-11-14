package edu.grinnell.csc207.sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Your Name
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  /**
   * Ensure that an array that is empty gets sorted correctly.
   */
  @Test
  public void emptyArrTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {};
    String[] expected = {};
    assertSorts(expected, original, stringSorter);
  } // emptyArrTest

  /**
   * Ensure that a large array gets sorted correctly.
   */
  @Test
  public void largeArrTest() {
    int SIZE = 50000; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // largeArrTest

  /**
   * Ensure that a small array with negative int gets sorted correctly.
   */
  @Test
  public void numArrTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = { 1, -5, -10, 10, 100, 0, -9, -99, 11};
    Integer[] expected = { -99, -10, -9, -5, 0, 1, 10, 11, 100};
    assertSorts(expected, original, intSorter);
  } // largeArrTest

  /**
   * Ensure that a small array with duplicate int gets sorted correctly.
   */
  @Test
  public void dupArrTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = { 1, 2, 1, 2, 1, 0, 3, 1, 3, 2};
    Integer[] expected = { 0, 1, 1, 1, 1, 2, 2, 2, 3, 3};
    assertSorts(expected, original, intSorter);
  } // largeArrTest

  /**
   * Ensure that a string array gets sorted correctly.
   */
  @Test
  public void stringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"maral1", "maral2", "maral bat", "maral bate", "1maral", "2maral"};
    String[] expected = {"1maral", "2maral", "maral1", "maral2", "maral bat", "maral bate"};
    assertSorts(expected, original, stringSorter);
  } // emptyArrTest
} // class TestSorter
