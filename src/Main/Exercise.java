package Main;

// librerias Creada
import Entities.Exercises;
import Entities.ExercisesContent;
import Entities.AlternativeSolutions;
import JPA_Controllers.ExercisesJpaController;
import JPA_Controllers.ExercisesContentJpaController;
import JPA_Controllers.AlternativeSolutionsJpaController;

// Librerias por Defecto
import java.util.List;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Exercise {

    private EntityManagerFactory _emf = null;

    //Declaraciones iniciales
    private ExercisesContentJpaController excjpa = null;
    private ExercisesJpaController exjpa = null;
    private AlternativeSolutionsJpaController asoljpa = null;

    //Listas de informacion
    private List<Exercises> ex = null;
    private List<ExercisesContent> exContent = null;
    private List<AlternativeSolutions> altSol = null;

    //Variables requeridas
    private int cnt = 0;
    private int verticalSize;

    //Generar listas de información
    public void generateListsInfo() {
        ex = exjpa.findExercisesEntities();
        exContent = excjpa.findExercisesContentEntities();
        altSol = asoljpa.findAlternativeSolutionsEntities();
    }

    //Obtener conexion con la Base de Datos
    public void setConnectionDB(EntityManagerFactory emf) {
        _emf = emf;
        excjpa = new ExercisesContentJpaController(_emf);
        exjpa = new ExercisesJpaController(_emf);
        asoljpa = new AlternativeSolutionsJpaController(_emf);
    }

    private void regenerateJPAControler() {
        excjpa = new ExercisesContentJpaController(_emf);
        exjpa = new ExercisesJpaController(_emf);
        asoljpa = new AlternativeSolutionsJpaController(_emf);
    }

    //Ontener el ejercicio actual
    public void setCounter(int _cnt) {
        this.cnt = _cnt;
    }

    //Obtener contador actual del ejercicio
    public int getCounter() {
        return cnt;
    }

    //Setear medida vertical para el panel
    public void setVerticalSize(int _verticalSize) {
        this.verticalSize = _verticalSize;
    }

    //Obtener medida vertical seteada
    public int getVerticalSize() {
        return verticalSize;
    }

    //Insertar titulo del ejercicio
    public String getTitle() {
        return ex.get(cnt).getExerciseName();
    }

    //Obtener descripcion del ejercicio
    public String getContent() {
        return exContent.get(cnt).getExerciseDescription();
    }

    //Obtener input del ejercicio
    public String getInput() {
        return exContent.get(cnt).getInput();
    }

    //Obtener output del ejercicio
    public String getOutput() {
        return exContent.get(cnt).getOutput();
    }

    //Obtener input de ejemplo del ejercicio
    public String getSampleInput() {
        return exContent.get(cnt).getSampleInput();
    }

    //Obtener output de ejemplo del ejercicio
    public String getSampleOutput() {
        return exContent.get(cnt).getSampleOutput();
    }

    //Obtener Solucion del ejercicio
    public String getSolution() {
        return (altSol.get(cnt).getSolutionText());
    }

    //Obtener Estatus actual
    public String getStatus() {
        return ex.get(cnt).getStatus();
    }

    public boolean getExerciseStatus() {
        return exContent.get(cnt).getAdditionalNotes().equals("TRUE");
    }

    public void clearListExercises() {
        ex.clear();
        exContent.clear();
    }

    public EntityManagerFactory regenerateConnectionUpdate() {
        _emf = Persistence.createEntityManagerFactory("ApoloPU");
//        setConnectionDB(_emf);
        regenerateJPAControler();
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        clearListExercises();
        Query q = em.createQuery("Select ex from Exercises ex");
        Query a = em.createQuery("Select exc from ExercisesContent exc");
        ex = (List<Exercises>) q.getResultList();
        exContent = (List<ExercisesContent>) a.getResultList();
        em.close();
        return _emf;
    }
}
