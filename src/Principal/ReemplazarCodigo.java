package Principal;

public class ReemplazarCodigo {

    public static String reemplazar(String code, int num) {
        String nuevoCodigo = null;
        if (num == 1) {
            nuevoCodigo = "package editor;\nimport java.io.*;\n" + code;
            nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\Editor\\\\input.txt\"))");
            nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
        } else {
            nuevoCodigo = "package judge;\nimport java.io.*;\n" + code;
            nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\IOFiles\\\\IN1.txt\"))");
            nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
        }
        return nuevoCodigo;
    }
}
