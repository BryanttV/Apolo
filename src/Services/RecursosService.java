package Services;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import Tipografias.Fuentes;

public final class RecursosService {

    private final Fuentes f = new Fuentes();
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
    private Cursor cMano;
    private Cursor cDefault;
    private Color colorPrincipal;
    private Color colorDark;
    private Color colorTextGray;
    private Color colorRojo;
    private Color colorAzul;
    private Color colorVerde;
    private Dimension dTamanioPaneles;
    private Dimension dTamanioBotones;
    private Dimension dBtns_Aprender;
    private Dimension dBtns_CodeStorm;
    private Dimension dPnl_Temas;

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
    }

    private void crearTamanio() {
        dBtns_CodeStorm = new Dimension(142, 52);
        dBtns_Aprender = new Dimension(254, 64);
        dTamanioBotones = new Dimension(172, 47);
        dTamanioPaneles = new Dimension(1176, 705);
        dPnl_Temas = new Dimension(1155, 1500);
    }

    private void crearFuentes() {
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
    }

    // Getters -----------------------------------------------------------------
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

    public Cursor getCMano() {
        return cMano;
    }

    public Cursor getCDefault() {
        return cDefault;
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
}
