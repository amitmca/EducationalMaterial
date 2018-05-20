import java.awt.Color;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;

public class MainClass {
  public static void main(String[] args) throws Exception {
    byte ff = (byte) 0xff;
    byte[] r = { ff, 0, 0, ff, 0 };
    byte[] g = { 0, ff, 0, ff, 0 };
    byte[] b = { 0, 0, ff, ff, 0 };

    ColorModel cm = new IndexColorModel(3, 5, r, g, b);

    Color[] colors = { new Color(255, 0, 0), new Color(0, 255, 0), new Color(0, 0, 255)};

    for (int i = 0; i < colors.length; i++) {
      int rgb = colors[i].getRGB();
      Object pixel = cm.getDataElements(rgb, null);
      System.out.println(colors[i] + " -> " + ((byte[]) pixel)[0]);
    }

    for (byte i = 0; i < 5; i++) {
      int[] unnormalizedComponents = cm.getComponents(i, null, 0);
      System.out.print(i + " -> unnormalized components");
      for (int j = 0; j < unnormalizedComponents.length; j++)
        System.out.print(" " + unnormalizedComponents[j]);
      System.out.println();
    }
  }
}
