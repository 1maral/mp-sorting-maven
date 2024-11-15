package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of our InsertionSorter.
 */
public class TestMaralSort extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new MaralBatErdeneSort<String>((x,y) -> x.compareTo(y));
    intSorter = new MaralBatErdeneSort<Integer>((x,y) -> x.compareTo(y));
  } // setup()

} // class TestMaralSort
