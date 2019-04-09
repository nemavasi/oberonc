import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class XYplane {
  public static final int erase = 0;
  public static final int draw = 1;
  public static int X, Y, W, H;
  private static char key;
  private static Viewer viewer;
  private static int penColor = Color.WHITE.getRGB();
  private static int backColor = Color.BLACK.getRGB();

  public static void SetPenColor(int r, int g, int b, int a){
      penColor = new Color(r,g,b,a).getRGB();
  }

  public static void SetBackgroundColor(int r, int g, int b, int a){
      backColor = new Color(r,g,b,a).getRGB();
  }


  public static void Open(int width, int height) {
    W = width;
    H = height;
    JFrame frame = new JFrame("XYPlane");
    viewer = new Viewer(W, H);
    frame.add(viewer);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public static void Dot(int x, int y, int mode) {
    y = H - y - 1;
    if(mode == erase) {
      viewer.canvas.setRGB(x, y, backColor);
    } else {
      viewer.canvas.setRGB(x, y, penColor);
    }
    viewer.updateUI();
  }

  public static boolean isDot(int x, int y) {
    y = H - y - 1;
    return viewer.canvas.getRGB(x, y) == penColor;
  }

  public static char Key() {
    return key;
  }

  public static void Clear() {
    viewer.fillCanvas(backColor);
  }

  private static class Viewer extends JPanel {
    private BufferedImage canvas;

    public Viewer(int width, int height) {
      canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      fillCanvas(backColor);
      setFocusable(true);
      requestFocus(true);
    }

    public Dimension getPreferredSize() {
      return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(canvas, null, null);
    }

    public void fillCanvas(int color) {
      for(int x = 0; x < canvas.getWidth(); x++) {
        for(int y = 0; y < canvas.getHeight(); y++) {
          canvas.setRGB(x, y, color);
        }
      }
      repaint();
    }
  }
}
