//Due to the time-consuming nature of brute forcing an affine Cipher, I have decided to code up this Java program to do it for me, so that I could solve question #3 of assignment number 1 in my fall 2023 CIS3362 course.
//Created by Michael Gilday.

import java.util.Scanner;
 
class AffineDecryptor{
  static String decryption(String encryption, int a, int b){
    //The string value created below will hold our 'decrypted' text. The value assigned to it in the 'for' loop below will be output at the end of this function.
    String text = "";

    //The code below was established to match the Affine function of 'y = a*x+b mod 26', where 'a' and 'b' are the parameters used assigned to the encryption process while the mod 26 puts the character within a range of 1~26 (A valid number of the alphabet) and is increased by 65 to put it within the ascii alphabetical range.
    for (int i = 0; i < encryption.length(); i++){
      text = text + (char) ((((a * encryption.charAt(i)) + b) % 26) +65);
    }
    return text;
  }
 
  public static void main(String[] args)
  {
    //The below segment is used to define the integer values commonly associated with Affine ciphers.
    int a = 1;
    int b = 0;

    //The below segment of code is used to create the necessary scanner for reading input as well as prompting for the entry.
    Scanner input = new Scanner(System.in);
    System.out.println("Encrypted entry: ");
    String encryption = input.next();

    //This 'do-while' loop is used to repeatedly run the decryption(string, int, int) function until the value of the integer 'a' is set equal to 26, which is the maximum value of 'z' in the alphabet.
    do{
      //The below line of code is used to reset the value of b so that the new value of a is matched to the lowest value of b before entering the below internal 'do-while'.
      b = 0;
      //This internal 'do-while' loop is used to repeatedly increase the value of 'b' so that each integer value reflecting the alphabet has been gone through.
      do{
        System.out.println(decryption(encryption, a, b));
        b++;
      }while(b != 26);
      a++;
    }while(a != 26);
    
    input.close();
  }
}