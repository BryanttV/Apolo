package Main;

import java.util.HashMap;

public class HTMLTemplates {

    private final static HashMap<String, String> templates = new HashMap<>();

    public HTMLTemplates() {
        this.addTemplates();
    }

    private void addTemplates() {
        templates.put("p", "<html><p style=\"text-align: justify;\">%s</p></html>");
        templates.put("pBR", "<html><p style=\"text-align: justify;\">%s</p><br></html>");
        templates.put("p_p", "<html><p style=\"text-align: justify;\">%s</p><p style=\"text-align: justify;\">%s</p></html>");
        templates.put("p_pBR", "<html><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p></html>");
        templates.put("p_p_p", "<html><p style=\"text-align: justify;\">%s</p><p style=\"text-align: justify;\">%s</p><p>%s</p></html>");
        templates.put("p_p_pBR2", "<html><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p><br><p>%s</p></html>");
        templates.put("p_h3BR", "<html><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_h3BR1", "<html><p style=\"text-align: justify;\">%s</p><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_h3BR2", "<html><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("p_p_p_h3BR", "<html><p style=\"text-align: justify;\">%s</p><p style=\"text-align: justify;\">%s</p><p>%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p></html>");
        templates.put("h2_p_h3", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p><h3>%s</h3></html>");
        templates.put("h2_p_h3BR", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_h3BR1", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_h3BR2", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
        templates.put("h2_p_p_p_h3BR3", "<html><h2>%s</h2><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p><br><p style=\"text-align: justify;\">%s</p><br><h3>%s</h3></html>");
    }

    private final String introductionTemplate = "<html>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Estructura de un Ejercicio Programaci??n Competitiva</h1>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? T??tulo</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">Contiene el nombre del problema. Com??nmente "
            + "describe superficialmente el tema del problema.</p>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Descripci??n</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">Contiene toda la informaci??n del problema. "
            + "Describe una situaci??n a la cual se debe dar soluci??n. En algunas ocasiones se "
            + "dan pistas de como se podr??a resolver el ejercicio. Esta secci??n aunque en "
            + "algunas ocasiones se extiende un poco, debe prestarse bastante atenci??n porque "
            + "es la que nos dice lo que debemos programar.</p>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Variables y Restricciones</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">Contiene la descripci??n de los tipos de datos "
            + "de entrada y salida, adem??s de las restricciones que se deben tomar en cuenta al "
            + "momento de realizar el programa.</p>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Ejemplo de Entrada y Salida</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">Contiene algunos ejemplos de entrada y salida. "
            + "Es importante saber que los ejemplos mostrados no ser??n los ??nicos, son solo una "
            + "gu??a. Por esto mismo, debemos evaluar diferentes casos de prueba se recomienda "
            + "hacer pruebas con un caso sencillo, un caso intermedio, y un caso dif??cil.</p>\n"
            + "<br><br><hr><br>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Casos de prueba:</h1>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Caso ??nico:</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo se ejecutar?? una ??nica vez.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Caso Bandera:</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo seguir?? ejecut??ndose en bucle hasta "
            + "que se cumpla una condici??n.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Caso Fijo:</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo se ejecutar?? una cierta cantidad de"
            + " veces dada por un valor num??rico.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Caso Infinito:</h2>\n"
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo se ejecutar?? una cantidad ilimitada "
            + "de veces hasta encontrarse una excepci??n EOF "
            + "(mientras sigue habiendo entradas).</p>\n"
            + "<br><br><hr><br>\n"
            + "<h1 style=\"color: rgb(183, 30, 29);\">Veredictos del juez:</h1>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Accepted (AC):</h2>"
            + "<p style=\"text-align: justify; margin: 0;\">??El c??digo funciona!, la respuesta es correcta"
            + " con una soluci??n que satisface un l??mite "
            + "de tiempo y memoria razonables.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Presentation Error (PE):</h2> "
            + "<p style=\"text-align: justify; margin: 0;\">La salida del programa es correcta, pero no se "
            + "presenta de manera correcta para el problema. Se debe revisar los espacios en blanco, "
            + "las tabulaciones o los saltos de l??nea adicionales.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Time Limit Exceeded (TLE):</h2> "
            + "<p style=\"text-align: justify; margin: 0;\">El tiempo de ejecuci??n del c??digo se demora mucho "
            + "para obtener un resultado.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Memory Limit Exceeded (MLE):</h2> "
            + "<p style=\"text-align: justify; margin: 0;\">El programa intenta utilizar m??s memoria que lo "
            + "permitido por el juez.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Wrong Answer (WA):</h2>"
            + "<p style=\"text-align: justify; margin: 0;\">??El c??digo no funciona en absoluto para resolver "
            + "el problema! las entradas no alcanzaron la soluci??n correcta.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Runtime Error (RE):</h2>  "
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo fall?? durante su ejecuci??n.</p>\n"
            + "<br>\n"
            + "<h2 style=\"color: rgb(183, 30, 29);\">??? Compile Error (CE):</h2>"
            + "<p style=\"text-align: justify; margin: 0;\">El c??digo no pudo ser compilado con satisfacci??n.</p>\n"
            + "</html>";

    private final String historyTemplate = "<html>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"text-align: justify\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "    <h2>%s</h2>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p><br>\n"
            + "<hr>\n"
            + "    <h1 style=\"color:rgb(0, 47, 108);\">%s</h1>\n"
            + "    <p style=\"margin:0; text-align: justify;\">%s</p>\n"
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

    private final String exercisesTemplateLearn = "<html>\n"
            + "    <h1 style=\"color: rgb(0, 37, 26);\">%s</h1>\n"
            + "    <p style=\"margin: 0; text-align: justify;\">%s</p><br>\n"
            + "    <hr>"
            + "    <h2 style=\"color: rgb(0, 37, 26);\">Input</h2>\n"
            + "    <p style=\"margin: 0; text-align: justify;\">%s</p><br>\n"
            + "    <hr>"
            + "    <h2 style=\"color: rgb(0, 37, 26);\">Output</h2>\n"
            + "    <p style=\"margin: 0; text-align: justify;\">%s</p><br>\n"
            + "    <hr>"
            + "    <h2 style=\"color: rgb(0, 37, 26);\">Sample Input</h2>\n"
            + "    <p style=\"margin: 0; text-align: justify;\">%s</p><br>\n"
            + "    <hr>"
            + "    <h2 style=\"color: rgb(0, 37, 26);\">Sample Output</h2>\n"
            + "    <p style=\"margin: 0; text-align: justify;\">%s</p><br>\n"
            + "</html>";

    private final String exercisesTemplateCodeStorm = "<html>\n"
            + "  <h1 style=\"color: rgb(183, 30, 29);\">%s</h1>\n"
            + "  <p style=\"margin-right: 10; text-align: justify;\">%s</p><br/>\n"
            + "  <hr>"
            + "  <h2 style=\"color: rgb(183, 30, 29);\">Input</h2>\n"
            + "  <p style=\"margin-right: 10; text-align: justify;\">%s</p><br/>\n"
            + "  <hr>"
            + "  <h2 style=\"color: rgb(183, 30, 29);\">Output</h2>\n"
            + "  <p style=\"margin-right: 10; text-align: justify;\">%s</p><br/>\n"
            + "  <hr>"
            + "  <h2 style=\"color: rgb(183, 30, 29);\">Sample Input</h2>\n"
            + "  <p style=\"margin-right: 10; text-align: justify;\">%s</p><br/>\n"
            + "  <hr>"
            + "  <h2 style=\"color: rgb(183, 30, 29);\">Sample Output</h2>\n"
            + "  <p style=\"margin-right: 10; text-align: justify;\">%s</p>\n"
            + "</html>";
    private final String lastMessageTemplate = "<html>\n"
            + "    <h1 style=\"margin:0;color: rgb(230, 230, 230)\">??Gracias por llegar hasta ac??!</h1><br>\n"
            + "    <p style=\"margin:0;color: rgb(220, 220, 220);text-align:justify\">Este es un triunfo para todos, "
            + "pero en especial es tuyo, has vencido la "
            + "adversidad y la desconfianza, desde aqu?? la imaginaci??n es el l??mite. Has visto "
            + "c??mo desde peque??as cosas puedes llegar a hacer cualquier programa que se te ocurra. "
            + "Esta parte de conocimiento es infinitesimalmente peque??a comparada a todo lo que "
            + "puedas llegar a ver. El futuro es especial, y a??n m??s cuando desde tu grandeza y "
            + "gloria puedas iluminarlo, recuerda el c??mo y el por qu?? llegaste hasta ac??, recuerda"
            + " tus sue??os y metas, del c??mo las cumplir??s, pero sobre todo recuerda que siempre "
            + "valdr?? la pena luchar por ello.</p><br>\n"
            + "    <p style=\"margin:0;color: rgb(220, 220, 220);text-align:justify\">No va a ser f??cil, "
            + "las cosas geniales nunca lo son, pero eres t?? el motivo"
            + " de nuestra acci??n, tenemos fe en ti, fue una suerte haberte ense??ado todo esto "
            + "porque sabemos todas las cosas extraordinarias que har??s y hasta d??nde esas cosas "
            + "te llevar??n. No nos queda nada m??s que decir que gracias por todo.\n"
            + "    </p><br>\n"
            + "    <p style=\"margin:0;color: rgb(220, 220, 220);text-align:justify\">Recuerda, si quieres "
            + "saber m??s, puedes unirte al <b>Grupo de Programaci??n "
            + "Competitiva</b> donde ampliar??s tus conocimientos acerca de este bello deporte y de "
            + "todas las puertas que te puede abrir.\n"
            + "    </p><br>\n"
            + "    <p style=\"margin:0;color: rgb(220, 220, 220);text-align:justify\">\"Este regalo de"
            + " conocimiento es para ti, mira dentro de ti mismo y "
            + "admira al universo en ??l???\n"
            + "    </p><br><br>\n"
            + "    <span style=\"color: rgb(255,255,255)\"><b>Equipo de Desarrollo Apolo</b></span>\n"
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

    public String getExerciseTemplateLearn() {
        return exercisesTemplateLearn;
    }

    public String getExerciseTemplateCodeStorm() {
        return exercisesTemplateCodeStorm;
    }

    public String getLastMessageTemplate() {
        return lastMessageTemplate;
    }
}
