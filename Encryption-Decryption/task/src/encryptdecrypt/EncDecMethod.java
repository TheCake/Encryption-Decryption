package encryptdecrypt;

/**
 * Strategy interface of a Strategy pattern
 * used to encrypt and decrypt in different ways
 */
interface EncDecMethod {
    String dec(String message, int key);
    String enc(String message, int key);
}
