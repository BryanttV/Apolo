package Judge;

public class ReemplazarCodigo {

    public static String reemplazar(String code, String pckage, String rute, String num) {
        String nuevoCodigo = null;

        nuevoCodigo = "package " + pckage + ";\nimport java.io.*;\n" + code;
        nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(\"C:\\\\Apolo\\\\src\\\\" + rute + "\\\\input" + num + ".txt\"))");
        nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
        return nuevoCodigo;
    }
}
