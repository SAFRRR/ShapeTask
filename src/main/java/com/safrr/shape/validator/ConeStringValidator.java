package com.safrr.shape.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConeStringValidator {
    public static final String PARAMS_PATTERN = "\\s*-?\\d+\\.?\\d*\\s+-?\\d+\\.?\\d*\\s+-?\\d+\\.?\\d*\\s+-?\\d+\\.?\\d*\\s*";
    public static boolean isCone(String line) {
        Pattern pattern = Pattern.compile(PARAMS_PATTERN);
        Matcher matcher = pattern.matcher(line.trim());
        boolean isMatches = matcher.matches();
        return isMatches;
    }
}