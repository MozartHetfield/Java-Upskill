package com.javaupskill.streams.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SessionController {

    private static final Map<Integer, UserSession> userIdToSession = new HashMap<>();

    static {
        userIdToSession.put(2, new UserSession(314));
        userIdToSession.put(1, new UserSession(542));
    }

    public Optional<UserSession> getSessionForUser(int userID) {
        UserSession userSession = userIdToSession.get(userID);
        if (userSession == null) {
            return Optional.empty();
        }
        return Optional.of(userSession);
    }
}
