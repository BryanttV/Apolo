package Judge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompileAndRun {

    static FileOutputStream out;

    static public void replaceCode(String code, String section, String rute, String num) {
        String codeModificado = ReemplazarCodigo.reemplazar(code, section, rute, num);

        try {
            out = new FileOutputStream("C:\\Apolo\\src\\" + section + "\\Main.java");
            byte[] bytxt = codeModificado.getBytes();
            out.write(bytxt);
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + e);
        }
    }

    static public int run(String clazz, String rute) throws IOException, InterruptedException {

        List<String> cmds = new ArrayList<>();
        cmds.add("java");
        cmds.add(clazz);

        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectError();
        pb.redirectInput(new File("C:\\Apolo\\src\\" + rute, "compare.txt"));
        pb.directory(new File("src"));

        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();

        System.out.println(consumer.getOutput());
        String writteable = consumer.getOutput().toString();
        try (FileWriter fw = new FileWriter("C:\\Apolo\\src\\" + rute + "\\compare.txt")) {
            fw.write(writteable);
            System.out.println("Archivo de salida correctamente creado");
        }

        return result;
    }

    static public int compile(String ruta) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("javac", ruta);
        pb.redirectError();

        String[] partesRuta = ruta.split("\\\\");

        String rutaNueva = "";

        for (int i = 0; i < partesRuta.length - 1; i++) {
            if (i < partesRuta.length - 2) {
                rutaNueva += partesRuta[i] + "\\\\";
            } else {
                rutaNueva += partesRuta[i];
            }
        }

        pb.directory(new File(rutaNueva));
        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();
        System.out.println(consumer.getOutput());
        return result;
    }

    static public class InputStreamConsumer extends Thread {

        private final InputStream is;
        private IOException exp;
        private StringBuilder output;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            int in = -1;
            output = new StringBuilder(64);
            try {
                while ((in = is.read()) != -1) {
                    output.append((char) in);
                }
            } catch (IOException ex) {
                exp = ex;
            }
        }

        public StringBuilder getOutput() {
            return output;
        }

        public IOException getException() {
            return exp;
        }
    }
}
