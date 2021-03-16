package Judge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import Principal.ReemplazarCodigo;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompileAndRun {

    static FileOutputStream out;

    static public void replaceCode(String code) {
        String codeModificado = ReemplazarCodigo.reemplazar(code, 2);

        try {
            out = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Judge\\Main.java");
            byte[] bytxt = codeModificado.getBytes();
            out.write(bytxt);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + e);
        }
    }

    static public int run(String clazz) throws IOException, InterruptedException {

        List<String> cmds = new ArrayList<>();
        cmds.add("java");
        cmds.add(clazz);

        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectError();
        pb.redirectInput(new File(System.getProperty("user.dir") + "\\src\\IOfiles", "output.txt"));
        pb.directory(new File("src"));

        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();

        System.out.println(consumer.getOutput());
        String writteable = consumer.getOutput().toString();
        try (FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\IOfiles\\output.txt")) {
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
