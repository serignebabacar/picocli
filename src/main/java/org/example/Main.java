package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;

@CommandLine.Command(name = "example", mixinStandardHelpOptions = true, version = "Picocli example 4.0")
public class Main implements Runnable {

    @Option(names = { "-v", "--verbose" },
            description = "Verbose mode. Helpful for troubleshooting. Multiple -v options increase the verbosity.")
    private boolean verbose ;

    @Parameters(arity = "1..*", paramLabel = "FILE", description = "File(s) to process.")
    private File[] inputFiles;

    public void run() {
        System.out.println(verbose);
        if (verbose) {
            System.out.println(inputFiles.length + " files to process...");
        }
        if (verbose) {
            for (File f : inputFiles) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        // By implementing Runnable or Callable, parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.

        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}