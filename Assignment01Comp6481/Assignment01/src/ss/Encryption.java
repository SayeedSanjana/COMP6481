package ss;

public class Encryption
{
	public class PolyalphabeticCipher {
	    
	    public static String encrypt(String plaintext, int key) {
	        StringBuilder ciphertext = new StringBuilder();
	        for (int i = 0; i < plaintext.length(); i++) {
	            char currentChar = plaintext.charAt(i);
	            char encryptedChar = shiftCharacter(currentChar, key + (i % 3));
	            ciphertext.append(encryptedChar);
	        }
	        return ciphertext.toString();
	    }
	    
	    private static char shiftCharacter(char character, int shift) {
	        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	        int index = (indexOf(alphabet, character) + shift) % 26;
	        if (index < 0) index += 26; // handle negative indexes
	        return alphabet[index];
	    }
	    
	    private static int indexOf(char[] array, char target) {
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == target) {
	                return i;
	            }
	        }
	        return -1; // character not found
	    }

	    public static void main(String[] args) {
	        String plaintext = "themthenthey";
	        int key = 1;
	        String ciphertext = encrypt(plaintext, key);
	        System.out.println("Ciphertext: " + ciphertext);
	    }
	}
      
}