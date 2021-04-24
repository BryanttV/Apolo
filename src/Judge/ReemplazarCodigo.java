package Judge;

public class ReemplazarCodigo {

    public static String reemplazar(String code, String pckage, String rute, String num) {
        String nuevoCodigo = null;

        nuevoCodigo = "package " + pckage + ";\nimport java.io.*;\n" + code;
        nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\" + rute + "\\\\input" + num + ".txt\"))");
        nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
//        switch (pckage) {
//            case "ioeditor":
//                nuevoCodigo = "package " + pckage + ";\nimport java.io.*;\n" + code;
//                nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\" + rute + "\\\\input.txt\"))");
//                nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
//                break;
//            case "judge":
//                nuevoCodigo = "package " + pckage + ";\nimport java.io.*;\n" + code;
//                nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\" + rute + "\\\\input1.txt\"))");
//                nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
//                break;
//            case "ioaprender":
//                nuevoCodigo = "package " + pckage + ";\nimport java.io.*;\n" + code;
//                nuevoCodigo = nuevoCodigo.replace("(System.in)", "(new File(System.getProperty(\"user.dir\") + \"\\\\" + rute + "\\\\input1.txt\"))");
//                nuevoCodigo = nuevoCodigo.replace("args)", "args) throws Exception");
//                break;
//            default:
//                break;
//        }
        return nuevoCodigo;
    }
}
