package edu.ti.caih313.collections.dataobj;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class EmailAddress {
    public enum Type {HOME, WORK, SCHOOL};
    Map<Type, String> emailMap = new HashMap<>();

    public EmailAddress(String emailAddress, Type type) {
        if (!validate(emailAddress)) {
            throw new InvalidParameterException("Email address not valid: '" + emailAddress + "'");
        }
        emailMap.put(type, emailAddress);
    }

    public String getEmailAddress() {
        return getPrimaryEmailAddress();
    }

    private String getPrimaryEmailAddress() {
        String primaryEmailAddress = null;
        if (emailMap.containsKey(Type.HOME)) {
            primaryEmailAddress = emailMap.get(Type.HOME);
        } else if (emailMap.containsKey(Type.WORK)) {
            primaryEmailAddress = emailMap.get(Type.WORK);
        } else if (emailMap.containsKey(Type.SCHOOL)) {
            primaryEmailAddress = emailMap.get(Type.SCHOOL);
        }
        return primaryEmailAddress;
    }

    public String getEmailAddress(Type type) {
        return emailMap.get(type);
    }

    boolean validate(String emailAddress) {
        return (emailAddress != null) && emailAddress.contains("@");
    }
}
