package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	boolean repeat = false;
	access user1 = new access("", false, 1);
	access user2 = new access("", false, 2);
	Scanner scS = new Scanner(System.in);
	Scanner scI = new Scanner(System.in);

    System.out.println("Welcome.");
        do {
            System.out.println("Are you user1 or user2?");
            int user = scI.nextInt();

            System.out.println("Type a word to encrypt.");
            String word = scS.nextLine();

            System.out.println("Press 1 to give the other user permission to decrypt your word?");
            int permission = scI.nextInt();
            boolean perm;

            if (permission == 1) {
                perm = true;
            }
            else {
                perm = false;
            }

            if (user == 1) {
                user1 = new access(word, perm, 1);
            }
            else if (user == 2) {
                user2 = new access(word, perm, 2);
            }

            if (repeat) {
                System.out.println("(1) to see encrypted word, (2) to read other user's word?");
                int read = scI.nextInt();
                if (read == 1) {
                    if (user == 1) {
                        System.out.println(user1.returnWord());
                    }
                    if (user == 2) {
                        System.out.println(user2.returnWord());
                    }
                }
                else if (read == 2) {
                    if (user == 1) {
                        System.out.println(user2.returnMessage(2));
                    }
                    if (user == 2) {
                        System.out.println(user1.returnMessage(1));
                    }
                }

            }

            System.out.println("Press 1 to exit program, 0 to continue");
            int loop = scI.nextInt();
            repeat = loop != 1;

        } while (repeat);
    }
}
