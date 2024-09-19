import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestJavaPrograms {

  public static boolean Testing(String exercise) {

    // File paths
    String studentProgramPath = "exercises/Exercise_" + exercise + ".java"; // Path to student's Java program
    String professorProgramPath = "key/Key_" + exercise + ".java"; // Path to professor's Java program
    String studentOutput = "outputs/studentOutput.txt";
    String professorOutput = "outputs/professorOutput.txt";

    boolean value = false;

    try {
      // Compile and run the professor's program
      compileAndRun(professorProgramPath, professorOutput);

      // Compile and run the student's program
      compileAndRun(studentProgramPath, studentOutput);

      // Compare outputs
      value = compareOutputs(professorOutput, studentOutput, exercise);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Clean up
      cleanUp(studentProgramPath, professorProgramPath, studentOutput, professorOutput);
    }
    return value;
  }

  private static void compileAndRun(String programPath, String outputPath) throws Exception {
    // Compile the program
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    int result = compiler.run(null, null, null, programPath);
    if (result != 0) {
      System.err.println("Compilation failed for " + programPath);
      return;
    }

    // Run the program
    String className = programPath.substring(0, programPath.lastIndexOf('.')).replace(File.separatorChar, '.');
    ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".", className);
    pb.redirectOutput(new File(outputPath));
    pb.redirectErrorStream(true);
    Process process = pb.start();
    process.waitFor();
  }

  private static boolean compareOutputs(String professorOutputPath, String studentOutputPath, String exercise)
      throws IOException {
    String professorOutput = new String(Files.readAllBytes(Path.of(professorOutputPath)));
    String studentOutput = new String(Files.readAllBytes(Path.of(studentOutputPath)));

    if (professorOutput.equals(studentOutput)) {
      System.out.println("TEST FOR exercise-" + exercise + " PASSED!");
      return true;
    } else {

      System.out.println("TEST FOR exercise-" + exercise + " FAILED!");
      System.out.println("YOUR CODES OUTPUT:");
      System.out.println(studentOutput);
      return false;
    }
  }

  private static void cleanUp(String studentProgramPath, String professorProgramPath, String studentOutput,
      String professorOutput) {
    // Delete output files
    deleteFile(studentOutput);
    deleteFile(professorOutput);

    // Delete compiled class files
    deleteClassFile(studentProgramPath);
    deleteClassFile(professorProgramPath);
  }

  private static void deleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists() && file.delete()) {
    } else {
      System.err.println("Failed to delete: " + filePath);
    }
  }

  private static void deleteClassFile(String programPath) {
    String classFilePath = programPath.substring(0, programPath.lastIndexOf('.')) + ".class";
    File classFile = new File(classFilePath);
    if (classFile.exists() && classFile.delete()) {
    } else {
      System.err.println("Failed to delete: " + classFilePath);
    }
  }
}
