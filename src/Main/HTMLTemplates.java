package Main;

import java.util.HashMap;

public class HTMLTemplates {

    private final static HashMap<String, String> templates = new HashMap<>();

    public HTMLTemplates() {
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

    private final String introductionTemplate = "<html>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Estructura de un Ejercicio Programación Competitiva</h1>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Título</h2>\n"
            + "Contiene el nombre del problema. Comúnmente describe superficialmente el tema del problema.\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Descripción</h2>\n"
            + "Contiene toda la información del problema. Describe una situación a la cual se debe dar solución. "
            + "En algunas ocasiones se dan pistas de como se podría resolver el ejercicio. Esta sección aunque en "
            + "algunas ocasiones se extiende un poco, debe prestarse bastante atención porque es la que nos dice lo "
            + "que debemos programar.\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Variables y Restricciones</h2>\n"
            + "Contiene la descripción de los tipos de datos de entrada y salida, además de las restricciones que "
            + "se deben tomar en cuenta al momento de realizar el programa.\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Ejemplo de Entrada y Salida</h2>\n"
            + "Contiene algunos ejemplos de entrada y salida. Es importante saber que los ejemplos mostrados no "
            + "serán los únicos, son solo una guía. Por esto mismo, debemos evaluar diferentes casos de prueba, "
            + "se recomienda hacer pruebas con un caso sencillo, un caso intermedio, y un caso difícil.\n"
            + "<br>\n"
            + "<br>\n"
            + "<hr>\n"
            + "<br>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Casos de prueba:</h1>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Caso Único:</h2>\n"
            + "El código se ejecutará una única vez.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Caso Bandera:</h2>\n"
            + "El código seguirá ejecutándose en bucle hasta que se cumpla una condición.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Caso Fijo:</h2>\n"
            + "El código se ejecutará una cierta cantidad de veces dada por un valor numérico.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Caso Infinito:</h2>\n"
            + "El código se ejecutará una cantidad ilimitada de veces hasta encontrarse una excepción EOF "
            + "(mientras sigue habiendo entradas).\n"
            + "<br>\n"
            + "<br>\n"
            + "<hr>\n"
            + "<br>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Veredictos del juez:</h1>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Accepted (AC):</h2> ¡El código funciona!, la "
            + "respuesta es correcta con una solución que satisface un límite de tiempo y memoria razonables.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Presentation Error (PE):</h2> La salida del "
            + "programa es correcta, pero no se presenta de manera correcta para el problema. Se debe revisar los espacios en blanco, las tabulaciones o los saltos de línea adicionales.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Time Limit Exceeded (TLE):</h2> El tiempo de "
            + "ejecución del código se demora mucho para obtener un resultado. \n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Memory Limit Exceeded (MLE):</h2> El programa "
            + "intenta utilizar más memoria que lo permitido por el juez.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Wrong Answer (WA):</h2> ¡El código no funciona "
            + "en absoluto para resolver el problema! las entradas no alcanzaron la solución correcta.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Runtime Error (RE):</h2>  El código falló durante"
            + " su ejecución.\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">• Compile Error (CE):</h2> El código no pudo ser "
            + "compilado con satisfacción.\n"
            + "</html>";

    private final String historyTemplate = "<html>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p>%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"margin:0\">%s</p>\n"
            + "    </html>";

    private final String questionnairesTemplate = "<html>\n"
            + "<p>%s</p>\n"
            + "<p>%s</p>\n"
            + "<br>\n"
            + "<p>%s</p>\n"
            + "<p>%s</p>\n"
            + "<br>\n"
            + "<p>%s</p>\n"
            + "<p>%s</p>\n"
            + "</html>";

    private final String exercisesTemplate = "<html>\n"
            + "    <h1 style=\"color: rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"margin: 0;\">%s</p><br>\n"
            + "    <h2 style=\"color: rgb(0, 47, 108);\">Input</h2>\n"
            + "    <p style=\"margin: 0;\">%s</p><br>\n"
            + "    <h2 style=\"color: rgb(0, 47, 108);\">Output</h2>\n"
            + "    <p style=\"margin: 0;\">%s</p><br>\n"
            + "    <h2 style=\"color: rgb(0, 47, 108);\">Sample Input</h2>\n"
            + "    <p style=\"margin: 0;\">%s</p><br>\n"
            + "    <h2 style=\"color: rgb(0, 47, 108);\">Sample Output</h2>\n"
            + "    <p style=\"margin: 0;\">%s</p><br>\n"
            + "</html>";

    public String getGeneralTemplate(String s) {
        return templates.get(s);
    }

    public String getIntroductionTemplate() {
        return introductionTemplate;
    }

    public String getQuestionnairesTemplate() {
        return questionnairesTemplate;
    }

    public String getHistoryTemplate() {
        return historyTemplate;
    }

    public String getExerciseTemplate() {
        return exercisesTemplate;
    }
}
