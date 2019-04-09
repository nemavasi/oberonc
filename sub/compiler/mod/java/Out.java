import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public final class Out {

  private Out() {}

  static {
    try {
      System.setOut(new PrintStream(System.out, true, "UTF-8"));
      System.setErr(new PrintStream(System.err, true, "UTF-8"));
    } catch(UnsupportedEncodingException e) {
      // keep defaults
    }
  }

  public static void Char(char ch) {
    System.out.print(ch);
  }

  public static void String(char[] str) {
    int i = 0;
    int len = str.length;
    while(i < len && str[i] != '\0') {
      i++;
    }
    System.out.print(new String(str, 0, i));
  }

  public static void Real(float x, int n) {
    if(n <= 0) {
      System.out.print(x);
    } else {
      System.out.printf("%" + n + "f", x);
    }
  }

  public static void Int(int x, int n) {
    if(n <= 0) {
      System.out.print(x);
    } else {
      System.out.printf("%" + n + "d", x);
    }
  }

  public static void Ln() {
    System.out.print('\n');
  }

  public static void Hex(int x) {
    System.out.printf("%08X", x);
  }

}
