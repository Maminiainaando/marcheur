import org.example.marcheur.Marcheur;
import org.example.marcheur.Trajet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class MarcheTest {
    @Test
    public void resteImmobile() {
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("hei");
        assertEquals(immobile,bajni.marche("hei","hei"));
    }
    @Test
    public void EstiVersHei(){
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("esti","boulevard","balancoire","hei");
        assertEquals(immobile,bajni.marche("esti","hei"));
    }
    @Test
    public void heiVersEsti(){
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("hei","balancoire","boulevard","esti");
        assertEquals(immobile,bajni.marche("hei","esti"));
    }
    @Test
    public void arriverAlaDestination(){
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        assertEquals("hei",(bajni.marche("hei","esti")).get(0));
        assertEquals("esti",(bajni.marche("hei","esti")).get(bajni.marche("hei","esti").size()-1));
    }
    @Test
    public void neSautePasUneLieu(){
        Marcheur bajni=new Marcheur();
        Trajet trajett=new Trajet();
        List<String> immobile=Arrays.asList("marais","sekolintsika","hei");
        assertEquals(immobile,bajni.marche("marais","hei"));
    }
}
