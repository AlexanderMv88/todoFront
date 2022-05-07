package org.todoFront.entity;

import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private User user;
    private Boolean done;

    public Task(String title, String description, User user, Boolean done) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(user, task.user) && Objects.equals(done, task.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, user, done);
    }
}
