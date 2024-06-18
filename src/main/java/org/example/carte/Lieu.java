package org.example.carte;

import java.util.Arrays;
import java.util.List;

public class Lieu {
    private List<Object> carteObject= Arrays.asList(
            "marais",
            "sekolintsika",
            "hei",
            Arrays.asList("balancoire","esti","boulevard","balancoire","hei"),
            "pullman",
            Arrays.asList("balancoire","esti","boulevard","balancoire","pullman"),
            "nextA"
    );
    private List<String> originalList=Arrays.asList(
            "marais",
            "sekolintsika",
            "hei",
            "balancoire",
            "esti",
            "boulevard",
            "balancoire",
            "hei",
            "pullman",
            "balancoire",
            "esti",
            "boulevard",
            "balancoire",
            "pullman",
            "nextA"
    );

    public List<Object> getCarteObject() {
        return carteObject;
    }

    public List<String> getOriginalList() {
        return originalList;
    }

}
