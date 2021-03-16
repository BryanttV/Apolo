package Tipografias;

import java.awt.Font;
import java.io.InputStream;

public class Fuentes {

    private Font font = null;
    public String EUCM = "EuclidCircularA-Medium.ttf";
    public String EUCR = "EuclidCircularA-Regular.ttf";
    public String EUCB = "EuclidCircularA-Bold.ttf";

    public Font fuente(String fontName, int estilo, float len) {
        try {
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            System.out.println(fontName + "no se encuentra");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        Font tfont = font.deriveFont(estilo, len);
        return tfont;
    }
}
