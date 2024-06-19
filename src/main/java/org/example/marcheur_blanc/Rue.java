package org.example.marcheur_blanc;

import java.util.List;

public class Rue {
    private List<Lieu> lieuList;

    public Rue(List<Lieu> lieuList) {
        this.lieuList = lieuList;
    }

    public List<Lieu> getLieuList() {
        return lieuList;
    }

    public void setLieuList(List<Lieu> lieuList) {
        this.lieuList = lieuList;
    }

    @Override
    public String toString() {
        return "Rue{" +
                "lieuList=" + lieuList +
                '}';
    }
}
