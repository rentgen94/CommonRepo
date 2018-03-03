package io.github.rentgen94.user;

import io.github.rentgen94.model.User;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActiveUserStore {

    private HashSet<User> users;

    private ConcurrentHashMap<String, Boolean> webSocketUrls = new ConcurrentHashMap<>();

    public ActiveUserStore() {
        users = new HashSet<>();
        webSocketUrls.put("localhost:9001", true);
        webSocketUrls.put("localhost:9002", true);
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public void setUsers(HashSet<User> users) {
        this.users = users;
    }

    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public String nextFreeWebSocket() {
        for (Map.Entry<String, Boolean> url : webSocketUrls.entrySet()) {
            if (url.getValue()) {
                return url.getKey();
            }
        }
        return "allUrlIsBusy";
    }

    public void lockUrl(String webSocketUrl) {
        webSocketUrls.put(webSocketUrl, false);
    }

    public void releaseUrl(String webSocketUrl) {
        webSocketUrls.put(webSocketUrl, true);
    }

    public ConcurrentHashMap<String, Boolean> getWebSocketUrls() {
        return webSocketUrls;
    }
}
