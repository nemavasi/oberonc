DEFINITION XYplane;  
  CONST erase = 0; draw = 1;
  VAR X, Y, W, H: INTEGER;

  PROCEDURE Open(width, height: INTEGER);
  PROCEDURE SetBackgroundColor(r, g, b, a: INTEGER);
  PROCEDURE SetPenColor(r, g, b, a: INTEGER);
  PROCEDURE Dot(x, y, mode: INTEGER);
  PROCEDURE IsDot(x, y: INTEGER): BOOLEAN;
  PROCEDURE Key(): CHAR;
  PROCEDURE Clear;
END XYplane.