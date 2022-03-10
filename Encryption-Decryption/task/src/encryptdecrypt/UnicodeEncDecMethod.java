package encryptdecrypt;

/**
 * Concrete strategy Class of a Strategy pattern
 * used to encrypt and decrypt in Unicode
 */
public class UnicodeEncDecMethod implements EncDecMethod {
    @Override
    public String dec(String message, int key) {
        String result = "";

        for(int i = 0; i < message.length(); i++) {
            result += (char) (message.charAt(i) - key);
        }

        return result;
    }

    @Override
    public String enc(String message, int key) {
        String result = "";

        for(int i = 0; i < message.length(); i++) {
            result += (char) (message.charAt(i) + key);
        }

        return result;
    }
}
