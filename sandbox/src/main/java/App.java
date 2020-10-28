class MyFirstClass {

  public static void main(String[] arg) {

    Point p1 = new Point(5.0, 99.0);
    Point p2 = new Point(7.5, 2.9);

    System.out.println(Math.round(p1.distance(p2) * 100.0) / 100.0);
  }
}
