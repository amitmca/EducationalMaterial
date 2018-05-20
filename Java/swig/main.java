public class main {
  static {
    System.loadLibrary("example");
  }

  public static void main(String argv[]) {
    System.out.println(swig.fact(4));
  }
}
