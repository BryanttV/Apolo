package Judge;

import java.io.IOException;
import WindowJudge.Wrong_Window;
import WindowJudge.Runtime_Window;
import WindowJudge.Accepted_Window;
import WindowJudge.Compilation_Window;
import WindowJudge.Presentation_Window;
import static Judge.CompileAndRun.*;

public class init {

    static Accepted_Window ac = new Accepted_Window();
    static Wrong_Window wa = new Wrong_Window();
    static Compilation_Window ce = new Compilation_Window();
    static Presentation_Window pe = new Presentation_Window();
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
                ce.setVisible(true);
                return true;
            }

            System.out.println("Compilador de java (javac) retorna un " + result);

            // Ejecutar archivo
            result = run("judge.Main");
            if (result != 0) {
                rt.setVisible(true);
                return true;
            }

            System.out.println("Ejecutable java (java judge.Main) retorna un " + result);

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error " + ex);
        }

        switch (CompareAndJudge.compareUtil(problem)) {
            case 0:
                ac.setVisible(true);
                return true;
            case 1:
                pe.setVisible(true);
                return true;
            default:
                wa.setVisible(true);
                return true;
        }
    }
}
