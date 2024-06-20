import org.example.marcheur.Trajet;
import org.example.marcheur_blanc.Lieu;
import org.example.marcheur_blanc.Marcheur;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class MarcheTest {
    @Test
    public void resteImmobile() {
        Lieu depart= new Lieu("hei");
        Lieu destination=new Lieu("hei");
        Marcheur bajni=new Marcheur();
        List<String> immobile=Arrays.asList(depart.getName());
        assertEquals(immobile,bajni.marcheSansCarte(depart,destination));
    }
    @Test
    public void heiVersEsti(){
        Marcheur bajni=new Marcheur();
        Lieu depart= new Lieu("hei");
        Lieu destination=new Lieu("esti");
        List<String> result=bajni.marcheSansCarte(depart,destination);
        assertEquals(depart.getName(),result.get(0));
        assertEquals(destination.getName(),result.get(result.size()-1));
    }
    @Test
    public void arriverAlaDestination(){
        Marcheur bajni=new Marcheur();
        Lieu depart= new Lieu("hei");
        Lieu destination=new Lieu("nexta");
        List<String> result=bajni.marcheSansCarte(depart,destination);
        assertEquals(destination.getName(),result.get(result.size()-1));
    }
    @Test
    public void neSautePasUneLieu(){
        Marcheur bajni=new Marcheur();
        Lieu depart= new Lieu("marais");
        Lieu destination=new Lieu("hei");
        Lieu sekolintsika=new Lieu("sekolintsika");
        List<String> immobile=Arrays.asList(depart.getName(),sekolintsika.getName(),destination.getName());
        assertEquals(immobile,bajni.marcheSansCarte(depart,destination));
    }
}
