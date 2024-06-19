package org.example.marcheur_blanc;

public class Lieu {
    private String name;

    public Lieu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "name='" + name + '\'' +
                '}';
    }
}
