package com.sharedclasses;

import java.security.SecureRandom;

public class UniqueCodeService {
    private static final String CODE_CHARACTERS = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
    private static final int CODE_LENGTH = 6;

    private static final SecureRandom random = new SecureRandom();



    public static String generateUniqueCode() {
        StringBuilder codeBuilder = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CODE_CHARACTERS.length());
            char randomChar = CODE_CHARACTERS.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();
    }
}
