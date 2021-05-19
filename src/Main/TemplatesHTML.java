package Main;

import java.util.HashMap;

public class TemplatesHTML {

    private final static HashMap<String, String> templates = new HashMap<>();

    public TemplatesHTML() {
        this.addTemplates();
    }

    private void addTemplates() {
        templates.put("p", "<html><p>%s</p></html>");
        templates.put("pBR", "<html><p>%s</p><br></html>");
        templates.put("p_p", "<html><p>%s</p><p>%s</p></html>");
        templates.put("p_pBR", "<html><p>%s</p><br><p>%s</p></html>");
        templates.put("p_p_p", "<html><p>%s</p><p>%s</p><p>%s</p></html>");
        templates.put("p_p_pBR2", "<html><p>%s</p><br><p>%s</p><br><p>%s</p></html>");
        templates.put("p_h3BR", "<html><p>%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_h3BR1", "<html><p>%s</p><p>%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_h3BR2", "<html><p>%s</p><br><p>%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_p_h3BR", "<html><p>%s</p><p>%s</p><p>%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p", "<html><h2>%s</h2><p>%s</p></html>");
        templates.put("h2_p_h3", "<html><h2>%s</h2><p>%s</p><h3>%s</h3></html>");
        templates.put("h2_p_h3BR", "<html><h2>%s</h2><p>%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_h3BR1", "<html><h2>%s</h2><p>%s</p><p>%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_h3BR2", "<html><h2>%s</h2><p>%s</p><br><p>%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_p_h3BR3", "<html><h2>%s</h2><p>%s</p><br><p>%s</p><br><p>%s</p><br><h3>%s</h3></html>");
    }

    public String getTemplate(String s) {
        return templates.get(s);
    }
}
