package com.patc.model;

import com.patc.enums.RequestType;

import java.util.List;
import java.util.Objects;

public class SelectRequestBody {
    private RequestType type;
    private String name;
    private List<String> names;
    private boolean isUser;

    public SelectRequestBody(RequestType type, String name, List<String> names, boolean isUser) {
        this.type = type;
        this.name = name;
        this.names = names;
        this.isUser = isUser;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SelectRequestBody that = (SelectRequestBody) o;
        return isUser == that.isUser && type == that.type && Objects.equals(name, that.name) && Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, names, isUser);
    }

    @Override
    public String toString() {
        return "APIRequestBody{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", names=" + names +
                ", isUser=" + isUser +
                '}';
    }
}