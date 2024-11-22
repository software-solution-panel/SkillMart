package com.swlc.skillmart.util;


import java.util.regex.Pattern;

public class MobileNumberValidator {
    private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^[0-9]{10}$");
    public static boolean isValidMobileNumber(String mobileNumber) {
        return MOBILE_NUMBER_PATTERN.matcher(mobileNumber).matches();
    }
}
