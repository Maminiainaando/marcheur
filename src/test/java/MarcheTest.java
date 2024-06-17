import org.example.marcheur.Carte;
import org.example.marcheur.Marcheur;
import org.example.marcheur.Trajet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarcheTest {
    @Test
    public void resteImmobile() {
        Carte carte=new Carte(Arrays.asList(
                "marais",
                "sekolintsika",
                "hei",
                Arrays.asList("balancoire","esti","boulevard","balancoire","hei"),
                "pullman",
                Arrays.asList("balancoire","esti","boulevard","balancoire","pullman"),
                "nextA"
        ));
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("hei");
        assertEquals(immobile,bajni.marche("hei","hei",carte));
    }
    @Test
    public void revenir(){
        Carte carte=new Carte(Arrays.asList(
                "marais",
                "sekolintsika",
                "hei",
                Arrays.asList("balancoire","esti","boulevard","balancoire","hei"),
                "pullman",
                Arrays.asList("balancoire","esti","boulevard","balancoire","pullman"),
                "nextA"
        ));
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("pullman","hei","sekolintsika","marais");
        assertEquals(immobile,bajni.marche("pullman","marais",carte));
    }
    @Test
    public void continuerMarcher(){
        Carte carte=new Carte(Arrays.asList(
                "marais",
                "sekolintsika",
                "hei",
                Arrays.asList("balancoire","esti","boulevard","balancoire","hei"),
                "pullman",
                Arrays.asList("balancoire","esti","boulevard","balancoire","pullman"),
                "nextA"
        ));
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("marais","sekolintsika","hei","pullman");
        assertEquals(immobile,bajni.marche("marais","pullman",carte));
    }
}
