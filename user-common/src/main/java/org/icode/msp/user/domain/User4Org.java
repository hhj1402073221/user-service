package org.icode.msp.user.domain;

public class User4Org {
    private String id;
    private String name;

    public User4Org() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User4Org{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
