package Judge;

// Librerias Creadas
import WindowJudge.Wrong_Window;
import WindowJudge.Runtime_Window;
import WindowJudge.Accepted_Window;
import WindowJudge.Compilation_Window;
import WindowJudge.Presentation_Window;
import static Judge.CompileAndRun.*;

// Librerias por Default
import java.io.IOException;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class init {

    static Accepted_Window ac = new Accepted_Window();
    static Wrong_Window wa = new Wrong_Window();
    static Compilation_Window ce = new Compilation_Window();
    static Presentation_Window pe = new Presentation_Window();
    static Runtime_Window rt = new Runtime_Window();
    static EntityManagerFactory _emf;
    static int cnt_ejercicio;

    public static void juzgador(String id, String code, String section, String rute,
            String num, int _cnt_ejercicio, EntityManagerFactory emf) throws Exception {

        _emf = emf;
        cnt_ejercicio = _cnt_ejercicio + 1;
        if (compileRunCompareJudge(id, code, section, rute, num)) {
            System.out.println("habilitar de nuevo botones");
        }
    }

    public static boolean compileRunCompareJudge(String problem, String code, String section,
            String rute, String num) throws Exception {

        replaceCode(code, section, rute, num);
        String final_status = "";
        try {
            // Obtener URL
            String findURL = System.getProperty("user.dir") + "\\src\\" + section + "\\Main.java";
            System.out.println("findUrl " + findURL);

            // Compilar Archivo
            int result = compile(findURL);
            if (result != 0) {
                final_status = "COMPILE ERROR";
                setFinalStatus(final_status);
                ce.setVisible(true);
                return true;
            }

            System.out.println("Compilador de java (javac) retorna un " + result);

            // Ejecutar archivo
            result = run(section + ".Main", rute);
            if (result != 0) {
                final_status = "RUNTIME ERROR";
                setFinalStatus(final_status);
                rt.setVisible(true);
                return true;
            }

            System.out.println("Ejecutable java (java " + section + ".Main) retorna un " + result);

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error " + ex);
        }

        switch (CompareAndJudge.compareUtil(problem, rute, num)) {
            case 0:
                final_status = "ACCEPTED";
                setFinalStatus(final_status);
                ac.setVisible(true);
                return true;
            case 1:
                final_status = "PRESENTATION ERROR";
                setFinalStatus(final_status);
                pe.setVisible(true);
                return true;
            default:
                final_status = "WRONG ANSWER";
                setFinalStatus(final_status);
                wa.setVisible(true);
                return true;
        }
    }

    public static void setFinalStatus(String final_status) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        @SuppressWarnings("JPQLValidation")
        Query q = em.createQuery("UPDATE Exercises SET status = :final_status " + "WHERE exercise_code = :cnt_ejercicio");
        q.setParameter("final_status", final_status);
        q.setParameter("cnt_ejercicio", cnt_ejercicio);
        int rows = q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("FILAS ACTUALIZADAS: " + rows);
        _emf.close();
    }
}
