public class MyClass1 {
    public static void main(String[] args) {
        test(1<<32, "1<<32");
        test(1<<31, "1<<31");
        test(1<<30, "1<<30");
        test(1,     "1"    );
        test(0,     "0"    );
        test(-1,    "-1"   );
	int[] array={10,20};
	System.out.println(array.length);
    }

    public static void test(int i, String exp) {
        if ((i >> 1) != (i >>> 1)) System.out.println(exp);
    }
}

