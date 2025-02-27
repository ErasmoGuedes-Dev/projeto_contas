package br.com.projetocontas.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {
    
    // Método estático para criptografar uma string usando SHA-1
    public static String encryptSHA1(String value) {
        try {
            // Criar uma instância do MessageDigest para SHA-1
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            // Executar o hash
            byte[] hash = digest.digest(value.getBytes());
            // Converter o byte array para uma string hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String valueToEncrypt = "Hello, World!";
        String encryptedValue = EncryptHelper.encryptSHA1(valueToEncrypt);
        System.out.println("Valor criptografado: " + encryptedValue);
    }
}