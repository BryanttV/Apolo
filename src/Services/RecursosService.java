package Services;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import Typographies.Fuentes;
import java.awt.Toolkit;

public final class RecursosService {

    private final Fuentes f = new Fuentes();
    private Font fGeneral;
    private Font fGeneral_19R;
    private Font fExContent;
    private Font fEuclidB16;
    private Font fEuclidB18;
    private Font fEuclidB20;
    private Font fEuclidB22;
    private Font fEuclidB30;
    private Font fEuclidR16;
    private Font fEuclidR14;
    private Font fLabel_Aprender;
    private Font fLabel_HistoriaB;
    private Font fLabel_HistoriaR;
    private Font fTitles;
    private Font fEditor;
    private Cursor cMano;
    private Cursor cDefault;
    private Color colorPrincipal;
    private Color colorDark;
    private Color colorTextGray;
    private Color colorRojo;
    private Color colorAzul;
    private Color colorVerde;
    private Color colorGrisBorde;
    private Color colorThumb_Off = new Color(50, 50, 50);
    private Color colorThumb_On = new Color(32, 30, 33);
    private Color colorDrag = new Color(32, 30, 33);
    private Color colorBgScroll = new Color(34, 34, 34);
    private Dimension dTamanioPaneles;
    private Dimension dTamanioBotones;
    private Dimension dBtns_Aprender;
    private Dimension dBtns_CodeStorm;
    private Dimension dPnl_Temas;
    private Dimension dLbl_Temas;
    private Dimension dScreen;

    static private RecursosService servicio;

    private RecursosService() {
        this.crearCursores();
        this.crearColores();
        this.crearTamanio();
        this.crearFuentes();
    }

    public static RecursosService getService() {
        if (servicio == null) {
            servicio = new RecursosService();
        }
        return servicio;
    }

    // Setters -----------------------------------------------------------------
    private void crearCursores() {
        cMano = new Cursor(Cursor.HAND_CURSOR);
        cDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    private void crearColores() {
        colorPrincipal = new Color(237, 234, 243);
        colorRojo = new Color(183, 30, 29);
        colorAzul = new Color(0, 47, 108);
        colorVerde = new Color(0, 37, 26);
        colorDark = new Color(56, 56, 56);
        colorTextGray = new Color(220, 220, 220);
        colorGrisBorde = new Color(153, 153, 153);
        colorThumb_Off = new Color(50, 50, 50);
        colorThumb_On = new Color(32, 30, 33);
        colorDrag = new Color(32, 30, 33);
        colorBgScroll = new Color(34, 34, 34);
    }

    private void crearTamanio() {
        dBtns_CodeStorm = new Dimension(142, 52);
        dBtns_Aprender = new Dimension(254, 64);
        dTamanioBotones = new Dimension(172, 47);
        dTamanioPaneles = new Dimension(1176, 705);
        dPnl_Temas = new Dimension(1155, 1500);
        dLbl_Temas = new Dimension(750, 45);
        dScreen = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private void crearFuentes() {
        fEditor = new Font("Consolas", Font.PLAIN, 14);
        fLabel_Aprender = new Font("Trebuchet MS", 1, 18);
        fLabel_HistoriaR = new Font("Segoe UI Emoji", Font.PLAIN, 20);
        fLabel_HistoriaB = new Font("Segoe UI SemiBold", Font.BOLD, 26);
        fEuclidR14 = f.fuente(f.EUCR, 0, 14);
        fEuclidR16 = f.fuente(f.EUCR, 0, 16);
        fEuclidB16 = f.fuente(f.EUCB, 0, 16);
        fEuclidB18 = f.fuente(f.EUCB, 0, 18);
        fEuclidB20 = f.fuente(f.EUCB, 0, 20);
        fEuclidB22 = f.fuente(f.EUCB, 0, 22);
        fEuclidB30 = f.fuente(f.EUCB, 0, 30);
        fTitles = f.fuente(f.EUCB, 0, 18);
        fGeneral = f.fuente(f.EUCR, 0, 16);
        fGeneral_19R = f.fuente(f.EUCR, 0, 19);
        fExContent = f.fuente(f.EUCR, 0, 19);
    }

    // Getters Fuentes ---------------------------------------------------------
    public Font getFEditor() {
        return fEditor;
    }

    public Font getFGeneral() {
        return fGeneral;
    }

    public Font getFExContent() {
        return fExContent;
    }

    public Font getFGeneral_19R() {
        return fGeneral_19R;
    }

    public Font getFTitles() {
        return fTitles;
    }

    public Font getFB20() {
        return fEuclidB20;
    }

    public Font getFContentTip() {
        return fEuclidR14;
    }

    public Font getFWindow() {
        return fEuclidR16;
    }

    public Font getFLabelSettings() {
        return fEuclidB16;
    }

    public Font getFTitleTips() {
        return fEuclidB18;
    }

    public Font getFTitleEditor() {
        return fEuclidB22;
    }

    public Font getFLabelsAprender() {
        return fEuclidB30;
    }

    public Font getFLabels() {
        return fLabel_Aprender;
    }

    public Font getFHistoriaR() {
        return fLabel_HistoriaR;
    }

    public Font getFHistoriaB() {
        return fLabel_HistoriaB;
    }

    // Getters Cursores --------------------------------------------------------
    public Cursor getCMano() {
        return cMano;
    }

    public Cursor getCDefault() {
        return cDefault;
    }

    // Getters Colores ---------------------------------------------------------
    public Color getColorBgScroll() {
        return colorBgScroll;
    }

    public Color getColorThumbOff() {
        return colorThumb_Off;
    }

    public Color getColorThumbOn() {
        return colorThumb_On;
    }

    public Color getColorDrag() {
        return colorDrag;
    }

    public Color getCPrincipal() {
        return colorPrincipal;
    }

    public Color getColorVerde() {
        return colorVerde;
    }

    public Color getColorAzul() {
        return colorAzul;
    }

    public Color getColorRojo() {
        return colorRojo;
    }

    public Color getColorDark() {
        return colorDark;
    }

    public Color getColorTextGray() {
        return colorTextGray;
    }

    public Color getColorGrisBorde() {
        return colorGrisBorde;
    }

    // Getters Dimension
    public Dimension getDTamanio() {
        return dTamanioPaneles;
    }

    public Dimension getDTamanioBotones() {
        return dTamanioBotones;
    }

    public Dimension getDBtns_Aprender() {
        return dBtns_Aprender;
    }

    public Dimension getDBtns_CodeStorm() {
        return dBtns_CodeStorm;
    }

    public Dimension getDPnls_Temas() {
        return dPnl_Temas;
    }

    public Dimension getDLbls_Temas() {
        return dLbl_Temas;
    }

    public Dimension getDScreen() {
        return dScreen;
    }
}
