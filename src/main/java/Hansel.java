import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 04/02/17.
 */
public class Hansel {

    static List<ClassObfuscator> classObfuscators = new ArrayList<ClassObfuscator>();

    public static class ClassObfuscator {
        String className;
        String shortForm;
        List<MethodObfuscator> methodObfuscators;

        public ClassObfuscator() {
            methodObfuscators = new ArrayList<MethodObfuscator>();
        }
    }
    public static class MethodObfuscator {
        String methodName;
        String shortForm;
    }

    public static void createMap(File mappingFile) {

        BufferedReader br = null;
        FileReader fr = null;
        try {

            fr = new FileReader(mappingFile);
            br = new BufferedReader(fr);
            String sCurrentLine;


            while ((sCurrentLine = br.readLine()) != null) {
                ClassObfuscator classObfuscator;
                if(sCurrentLine.contains(".")) { //Class path has . in the package name
                    //This is a class name
                    classObfuscator = new ClassObfuscator();
                    classObfuscators.add(classObfuscator);
                    String[] classArgs = sCurrentLine.split("->");
                    for(String classArg : classArgs) {
                        if(!classArg.trim().isEmpty()) {
                            if(classObfuscator.className == null || classObfuscator.className.isEmpty()) {
                                classObfuscator.className = classArg.trim();
                            } else {
                                int removeColon = classArg.lastIndexOf(":");
                                if(removeColon > -1) {
                                    classObfuscator.shortForm = classArg.substring(0,removeColon).trim();
                                } else {
                                    classObfuscator.shortForm = classArg.trim();
                                }
                            }
                        }
                    }
                } else {
                    String[] methodArgs = sCurrentLine.split(" ");
                    MethodObfuscator methodObfuscator = new MethodObfuscator();
                    methodObfuscator.methodName = methodArgs[1].substring(0,methodArgs[1].indexOf("(")).trim();
                    methodObfuscator.shortForm = methodArgs[3].trim();
                    classObfuscators.get(classObfuscators.size() - 1).methodObfuscators.add(methodObfuscator);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File mappingFile = new File("/Users/Hitesh Sethiya/Desktop/mapping.txt");
        createMap(mappingFile);
        String input = in.nextLine();
        int fnNameStartsAt = input.lastIndexOf(".");
        String className = input.substring(0, fnNameStartsAt);
        String fnName = input.substring(fnNameStartsAt + 1);
        StringBuilder builder = new StringBuilder();
        for(ClassObfuscator classObfuscator : classObfuscators) {
            if(className.equals(classObfuscator.className)) {
                builder.append(classObfuscator.shortForm);
                for(MethodObfuscator methodObfuscator : classObfuscator.methodObfuscators) {
                    if(fnName.equals(methodObfuscator.methodName)) {
                        builder.append(".")
                                .append(methodObfuscator.shortForm);
                        break;
                    }
                }
                break;
            }
        }
        if(builder.toString().isEmpty()) {
            System.out.println("Invalid qualified method name or this method doesn't exist in the mapping.");
        } else {
            System.out.println(builder);
        }

    }
}
