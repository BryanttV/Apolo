package Services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class RecursosService {

    private Font fLabel_Aprender;
    private Font fLabel_HistoriaB;
    private Font fLabel_HistoriaR;
    private Cursor cMano;
    private Cursor cDefault;
    private Color cPrincipal;
    private Dimension dTamanioPaneles;
    private Dimension dTamanioBotones;
    private Dimension dBtns_Aprender;
    private Dimension dBtns_CodeStorm;
    private Dimension dPnl_Temas;
    private LayoutManager lPrincipal;

    static private RecursosService servicio;

    private RecursosService() {
        this.crearCursores();
        this.crearColores();
        this.crearTamanio();
    }

    public static RecursosService getService() {
        if (servicio == null) {
            servicio = new RecursosService();
        }
        return servicio;
    }

    // Getters -----------------------------------------------------------------
    private void crearCursores() {
        cMano = new Cursor(Cursor.HAND_CURSOR);
        cDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    private void crearColores() {
        cPrincipal = new Color(237, 234, 243);
    }

    private void crearTamanio() {
        dBtns_CodeStorm = new Dimension(142, 52);
        dBtns_Aprender = new Dimension(254, 64);
        dTamanioBotones = new Dimension(172, 47);
        dTamanioPaneles = new Dimension(1176, 705);
        dPnl_Temas = new Dimension(1155, 1500);
    }

    public void crearFuentes() {
        fLabel_Aprender = new Font("Trebuchet MS", 1, 18);
        fLabel_HistoriaR = new Font("Segoe UI Emoji", Font.PLAIN, 20);
        fLabel_HistoriaB = new Font("Segoe UI SemiBold", Font.BOLD, 26);
    }

    public void crearLayout() {
        lPrincipal = new AbsoluteLayout();
    }

    // Setters -----------------------------------------------------------------
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
        return cPrincipal;
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

    public LayoutManager getLPrincipal() {
        return lPrincipal;
    }

}
