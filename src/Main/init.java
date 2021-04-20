package Main;

import java.io.IOException;
import javax.swing.JOptionPane;
import Judge.CompareAndJudge;
import static Judge.CompileAndRun.*;

public class init {
    
    static Accepted_Window ac = new Accepted_Window();
    static Wrong_Window wa = new Wrong_Window();
    static Compilation_Window ce = new Compilation_Window();
    static Presentation_window pe = new Presentation_window();
    static Runtime_Window rt = new Runtime_Window();

    public static void juzgador(String id, String code) {
        if (compileRunCompareJudge(id, code)) {
            System.out.println("habilitar de nuevo botones");
        }
    }

    public static boolean compileRunCompareJudge(String problem, String code) {

        replaceCode(code);
        try {
            // Obtener URL
            String findURL = System.getProperty("user.dir") + "\\src\\Judge\\Main.java";
            System.out.println("findUrl " + findURL);

            // Compilar Archivo
            int result = compile(findURL);
            if (result != 0) {
//                JOptionPane.showMessageDialog(null, "Compilation Error");
                ce.setVisible(true);
                return true;
            }

            System.out.println("Compilador de java (javac) retorna un " + result);

            // Ejecutar archivo
            result = run("judge.Main");
            if (result != 0) {
//                JOptionPane.showMessageDialog(null, "Runtime Error");
                rt.setVisible(true);
                return true;
            }

            System.out.println("Ejecutable java (java judge.Main) retorna un " + result);

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error " + ex);
        }

        switch (CompareAndJudge.compareUtil(problem)) {
            case 0:
//                JOptionPane.showMessageDialog(null, "Accepted");
                ac.setVisible(true);
                return true;
            case 1:
//                JOptionPane.showMessageDialog(null, "Presentation Error");
                pe.setVisible(true);
                return true;
            default:
//                JOptionPane.showMessageDialog(null, "Wrong Answer");
                wa.setVisible(true);
                return true;
        }
    }
}
