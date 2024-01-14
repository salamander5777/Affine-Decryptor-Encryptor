//This Java program was created in order to solve an Affine cipher when provided the values of 'a' and 'b' and is based on the code that I had created to solve for question #3 in my fall 2023 CIS3362 course.
//Created by Michael Gilday.

import java.util.Scanner;
 
class AffineEncryptor{
  static String encryptor(String current, int a, int b){
    //The string value created below will hold our 'plain' text. The value assigned to it in the 'for' loop below will be output at the end of this function.
    String text = "";

    //The code below was established to match the Affine function of 'y = a*x+b mod 26', where 'a' and 'b' are the parameters used assigned to the encryption process while the mod 26 puts the character within a range of 1~26 (A valid number of the alphabet) and is increased by 64 to put it within the ascii alphabetical range -1. This will cause the correct output for the encryption involved in Affine functions.
    for (int i = 0; i < current.length(); i++){
      int encryptedChar = ((((a * current.charAt(i)) + b) % 26) + 64);

      //This 'if' statement is used to verify that there are no outputs of '@' and are instead outputs of 'Z'.
      if (encryptedChar == '@'){
        encryptedChar = 'Z';
      }
      text += (char) encryptedChar;
    }
    return text;
  }
 
  public static void main(String[] args)
  {
    //The below segment of code is used to create the necessary scanner for reading input as well as prompting for the entry of the encrypted message, a value, and b value.
    Scanner input = new Scanner(System.in);
    System.out.println("'A' value: ");
    String inputA = input.next();
    System.out.println("'B' value: ");
    String inputB = input.next();
    System.out.println("Enter the text that needs to be encrypted: ");
    String current = input.next();

    //Parsing the input strings for A and B so that they are readable as integers in the encryption function.
    int a = Integer.parseInt(inputA);
    int b = Integer.parseInt(inputB);

    //The encryption function is called using the input values of 'A', 'B', and the plain message, which should output the proper encryption.
    System.out.println(encryptor(current, a, b));
    
    input.close();
  }
}