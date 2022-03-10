package encryptdecrypt;

/**
 * Context Class of a Strategy pattern used to encrypt and decrypt in different ways
 */
public class EncryptorDecryptor {
    private EncDecMethod method;

    /**
     * Sets which class implementing EncDecMethod interface we want to use
     *
     * @param method    Which class implementing EncDecMethod we want to use
     */
    public void setMethod(EncDecMethod method) {
        this.method = method;
    }

    /**
     *  Common encrypt method using enc method we specified
     *
     * @param message   message to encrypt
     * @param key       key by which to encrypt to message
     * @return          returns the encrypted text String
     */
    public String enc(String message, int key) {
        return this.method.enc(message, key);
    }

    /**
     * Common decrypt method using dec method we specified
     *
     * @param message   message to decrypt
     * @param key       key by which to decrypt to message
     * @return          return the decrypted text String
     */
    public String dec(String message, int key) {
        return this.method.dec(message, key);
    }

}
