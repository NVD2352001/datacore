package com.trucdulieu.commoncategory.config;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static UserContext getUserContext() {
        return userContext.get();
    }

    public static void setUserContext(UserContext context) {
        userContext.set(context);
    }

    public static void clear() {
        userContext.remove();
    }
}
