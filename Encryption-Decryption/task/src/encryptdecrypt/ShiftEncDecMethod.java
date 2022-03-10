package encryptdecrypt;

/**
 * Concrete strategy Class of a Strategy pattern
 * used to encrypt and decrypt in Shifting letters from a-z and A-Z
 * all other chars are left unchanged
 */
public class ShiftEncDecMethod implements EncDecMethod {

    @Override
    public String enc(String message, int key) {
        String result = "";

        for(int i = 0; i < message.length(); i++) {
            if (Character.isLowerCase(message.charAt(i))) {
                if(message.charAt(i) + key > 122) {
                    result += (char) (Math.abs(message.charAt(i) + key - 26));
                    //// unicode alphabet index is 97 - 122 = 26
                } else {
                    result += (char) (message.charAt(i) + key);
                }
            } else if (Character.isUpperCase(message.charAt(i))) {
                if(message.charAt(i) + key > 90) {
                    result += (char) (Math.abs(message.charAt(i) + key - 26));
                    //// unicode alphabet index is 65 - 90 = 26
                } else {
                    result += (char) (message.charAt(i) + key);
                }
            } else {
                result += message.charAt(i);
            }
        }

        return result;
    }

    @Override
    public String dec(String message, int key) {
        String result = "";

        for(int i = 0; i < message.length(); i++) {
            if (Character.isLowerCase(message.charAt(i))) {
                if(message.charAt(i) - key < 97) {
                    result += (char) (Math.abs(message.charAt(i) - key + 26));
                    //// unicode alphabet index is 97 - 122 = 26
                } else {
                    result += (char) (message.charAt(i) - key);
                }
            } else if (Character.isUpperCase(message.charAt(i))) {
                if(message.charAt(i) - key < 65) {
                    result += (char) (Math.abs(message.charAt(i) - key + 26));
                    //// unicode alphabet index is 65 - 90 = 26
                } else {
                    result += (char) (message.charAt(i) - key);
                }
            } else {
                result += message.charAt(i);
            }
        }

        return result;
    }
}
