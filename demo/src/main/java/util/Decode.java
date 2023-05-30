package util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decode {

    public static String decodeCredentials(String encodedKeyString) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedKeyString);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

}
