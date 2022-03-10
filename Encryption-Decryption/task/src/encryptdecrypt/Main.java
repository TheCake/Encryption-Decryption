package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Main class for text encryption or decryption
 * works simply by shifting char values
 * either by unicode value (char cast to int)
 * or a-z, A-Z, (every other char is left the same)
 * Takes arguments from command line such as
 *  -mode   - specifies mode used, either "enc" for encryption or "dec" for decryption
 *  -key    - integer value
 *  -data   - String text in quotes written in command line
 *  -in     - file name with the location of text data, works instead of -data
 *  -out    - if present, outputs the data into the specified file name
 *  -alg    - specifies algorithm used, either "unicode" or "shift"
 *
 * @author Filip Hajek
 */
public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String message = "";
        String inFileName = null;
        String outFileName = null;
        String alg = "shift";
        EncryptorDecryptor encDecAlgo = new EncryptorDecryptor();
        encDecAlgo.setMethod(new ShiftEncDecMethod());


        if (Arrays.asList(args).contains("-mode")) {
            mode = args[Arrays.asList(args).indexOf("-mode")+1];
            if(!mode.equals("enc") && !mode.equals("dec")) {
                mode = "enc";
            }
        }
        if (Arrays.asList(args).contains("-key")) {
            try {
                key = Integer.parseInt(args[Arrays.asList(args).indexOf("-key") + 1]);
            } catch (Exception ignored) {
                key = 0;
            }
        }
        if (Arrays.asList(args).contains("-data")) {
            try {
                message = args[Arrays.asList(args).indexOf("-data")+1];                } catch (Exception ignored) {
            }
        } else if (Arrays.asList(args).contains("-in")) {
            try {
                inFileName = args[Arrays.asList(args).indexOf("-in")+1];                } catch (Exception ignored) {
            }
        }
        if (Arrays.asList(args).contains("-out")) {
            try {
                outFileName = args[Arrays.asList(args).indexOf("-out")+1];                } catch (Exception ignored) {
            }
        }
        if (Arrays.asList(args).contains("-alg")) {
            try {
                alg = args[Arrays.asList(args).indexOf("-alg")+1];                } catch (Exception ignored) {
            }
            if(alg.equals("unicode")) {
                encDecAlgo.setMethod(new UnicodeEncDecMethod());
            }
        }

        if (inFileName != null) {
            try {
                message = readFileAsString(inFileName);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        }


        if (mode.equals("dec")) {
            print(encDecAlgo.dec(message, key), outFileName);
        } else {
            print(encDecAlgo.enc(message, key), outFileName);
        }

    }

    /**
     *  Method to print the message to either file or stdout
     *
     * @param message       String message we want to print
     * @param outFileName   String name of a file (if not null) to print message to
     */
    public static void print(String message, String outFileName) {
        if (outFileName != null) {
            File file = new File(outFileName);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(message);
            } catch (IOException e) {
                System.out.printf("An exception occurred %s", e.getMessage());
            }
        } else {
            System.out.println(message);
        }
    }

    /**
     * Converts file to String text
     *
     * @param fileName      file name
     * @return              Returns String text from the File
     * @throws IOException  Whether there was any hiccup during reading
     */
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
