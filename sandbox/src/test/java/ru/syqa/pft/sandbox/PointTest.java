package ru.syqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPointFractional() {
    Point p1 = new Point(5.0, 99.0);
    Point p2 = new Point(7.5, 2.9);

    Assert.assertEquals(p1.distance(p2), 96.13);
  }

  @Test
  public void testPointWhole() {
    Point p1 = new Point(5, 99);
    Point p2 = new Point(7, 2);

    Assert.assertEquals(p1.distance(p2), 97.02);
  }

  @Test
  public void testPointZero() {
    Point p1 = new Point(5, 0);
    Point p2 = new Point(7, 0);

    Assert.assertEquals(p1.distance(p2), 2.00);
  }
}
