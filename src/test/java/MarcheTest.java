import org.example.marcheur.Carte;
import org.example.marcheur.Trajet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MarcheTest {
    @Test
    public void testString() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Trajet bjani =new Trajet();
        List<String> expected=Arrays.asList("Hei", "Sekoly", "Marais", "Sekoly", "Hei", "Balancoire", "Boulvard", "Esti");

        List<String> result =bjani.marche("Hei", "Esti", carte.getCarte());
        assertEquals(expected, result);

    }
}
