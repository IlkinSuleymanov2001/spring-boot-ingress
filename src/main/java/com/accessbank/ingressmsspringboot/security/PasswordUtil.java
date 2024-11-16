package com.accessbank.ingressmsspringboot.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    public static String hashPassword(String password) {
        try {

            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(password.getBytes());
            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password with salt", e);
        }
    }


    // Method to verify a password against the stored hash
    public static boolean verifyPassword(String inputPassword, String storedPassword) {
        if (hashPassword(inputPassword).equals(storedPassword)) {
            return true;
        }
        return false;
    }

}
