package com.company;

public class access {
    private String eMessage = "";

    private String user1Message;
    private int user1Key;
    private boolean user1Perm;

    private String user2Message;
    private int user2Key;
    private boolean user2Perm;

    private int rand = (int)(Math.random()*100);


    public access(String m, boolean p, int n) {
        char[] message = m.toCharArray();
        if (n == 1) {
            user1Perm = p;
            user1Key = rand;
            encrypt(user1Key, message);
            user1Message = eMessage;
        }
        else if (n == 2) {
            user2Perm = p;
            user2Key = rand;
            encrypt(user2Key, message);
            user2Message = eMessage;
        }
    }

    public String returnWord() {
        return eMessage;
    }

    public String returnMessage(int i) {
        if (i == 1){
            decrypt(user1Key, user1Perm, user1Message.toCharArray());
        }
        else if (i == 2){
            decrypt(user2Key, user2Perm, user2Message.toCharArray());
        }
        return eMessage;
    }

    private void encrypt(int key, char[] m) {
        encryptionMethod(key, m);
    }

    private void decrypt(int key, boolean permission, char[] m) {
        if (permission) { encryptionMethod(-key, m); }
        else { eMessage = "Decryption denied, sorry."; }

    }

    private void encryptionMethod(int position, char[] m) {
        eMessage = "";
        for (int i = 0; i < m.length; i++) {
            int convert = (int)m[i] + position;
            eMessage = eMessage + (char)convert;
        }
    }
}