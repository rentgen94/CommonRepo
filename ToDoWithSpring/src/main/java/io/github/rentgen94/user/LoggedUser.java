package io.github.rentgen94.user;

import io.github.rentgen94.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class LoggedUser implements HttpSessionBindingListener, Serializable {

    private transient User loggedUser;
    private transient ActiveUserStore activeUserStore;
    private transient Timer inspirationTimer;
    private Long delay;

    public LoggedUser(User loggedUser, ActiveUserStore activeUserStore, Long delay) {
        this.loggedUser = loggedUser;
        this.activeUserStore = activeUserStore;
        this.inspirationTimer = new Timer();
        this.delay = delay*1000;
        this.inspirationTimer.schedule(new inspirationTask(), this.delay);
    }

    public LoggedUser() {}

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        if (!activeUserStore.getUsers().contains(loggedUser)) {
            loggedUser.setWebSocketUrl(activeUserStore.nextFreeWebSocket());
            activeUserStore.lockUrl(loggedUser.getWebSocketUrl());
            activeUserStore.getUsers().add(loggedUser);
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        if (activeUserStore.getUsers().contains(loggedUser)) {
            activeUserStore.releaseUrl(loggedUser.getWebSocketUrl());
            activeUserStore.getUsers().remove(loggedUser);
        }
    }

    private class inspirationTask extends TimerTask {

        @Override
        public void run() {
            while (true) {
                if ((getSession().getLastAccessedTime() + delay) < new Date().getTime()) {
                    try {
                        getSession().isNew();
                        if (getSession() != null) {
                            getSession().invalidate();
                            break;
                        }
                    } catch (IllegalStateException e) {
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private HttpSession getSession() {
        return this.loggedUser.getSession();
    }
}