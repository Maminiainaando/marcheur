package org.example.marcheur_blanc;

import java.util.*;
import java.util.stream.Collectors;

public class Method {
    public static List<String> marche(Lieu depart, Lieu destination) {
        Lieu hei = new Lieu("hei");
        Lieu sekolintsika = new Lieu("sekolintsika");
        Lieu marais = new Lieu("marais");
        Lieu pullman = new Lieu("pullman");
        Lieu balancoire = new Lieu("balancoire");
        Lieu esti = new Lieu("esti");
        Lieu boulevard = new Lieu("boulevard");
        Lieu nexta = new Lieu("nexta");
        List<Lieu> maraisHei = Arrays.asList(marais, sekolintsika, hei);

        List<Lieu> heiPullman=Arrays.asList(hei,pullman);
        List<Lieu> heiBalancoire=Arrays.asList(hei,balancoire);
        List<Lieu> heiMarais=Arrays.asList(hei,sekolintsika,marais);

        List<Lieu> pullmanHei = Arrays.asList(pullman,hei);
        List<Lieu> pullmanBalancoire = Arrays.asList(pullman,balancoire);
        List<Lieu> pullmanNextA = Arrays.asList(pullman,nexta);

        List<Lieu> balancoireEsti = Arrays.asList(balancoire,esti);
        List<Lieu> balancoireBoulevard = Arrays.asList(balancoire,boulevard);
        List<Lieu> balancoirePullman = Arrays.asList(balancoire,pullman);
        List<Lieu> balancoireHei = Arrays.asList(balancoire,hei);

        Rue andriatsioharana = new Rue(pullmanHei);
        List<String> andriatsioharanaString = new ArrayList<>();
        for (Lieu lieu : andriatsioharana.getLieuList()) {
            andriatsioharanaString.add(lieu.getName());
        }

        Rue ranaivo = new Rue(pullmanBalancoire);
        List<String> ranaivoString = new ArrayList<>();
        for (Lieu lieu : ranaivo.getLieuList()) {
            ranaivoString.add(lieu.getName());
        }

        Rue avantLeChoixAleatoire = new Rue(maraisHei);
        List<String> avantLeChoixAleatoireString = new ArrayList<>();
        for (Lieu lieu : avantLeChoixAleatoire.getLieuList()) {
            avantLeChoixAleatoireString.add(lieu.getName());
        }

        Rue BE = new Rue(balancoireEsti);
        List<String> beString = new ArrayList<>();
        for (Lieu lieu : BE.getLieuList()) {
            beString.add(lieu.getName());
        }

        Rue BB = new Rue(balancoireBoulevard);
        List<String> bbString = new ArrayList<>();
        for (Lieu lieu : BB.getLieuList()) {
            bbString.add(lieu.getName());
        }

        Rue BP = new Rue(balancoirePullman);
        List<String> bpString = new ArrayList<>();
        for (Lieu lieu : BP.getLieuList()) {
            bpString.add(lieu.getName());
        }
        Rue HB=new Rue(heiBalancoire);
        List<String> hbString = new ArrayList<>();
        for (Lieu lieu : HB.getLieuList()) {
            hbString.add(lieu.getName());
        }
        Rue HP=new Rue(heiPullman);
        List<String> hpString = new ArrayList<>();
        for (Lieu lieu : HP.getLieuList()) {
            hpString.add(lieu.getName());
        }
        Rue HM=new Rue(heiMarais);
        List<String> hmString = new ArrayList<>();
        for (Lieu lieu : HM.getLieuList()) {
            hmString.add(lieu.getName());
        }
        Rue BH = new Rue(balancoireHei);
        List<String> bhString = new ArrayList<>();
        for (Lieu lieu : BH.getLieuList()) {
            bhString.add(lieu.getName());
        }

        Rue PN = new Rue(pullmanNextA);
        List<String> pnString = new ArrayList<>();
        for (Lieu lieu : PN.getLieuList()) {
            pnString.add(lieu.getName());
        }

        List<String> result = new ArrayList<>();

        List<Rue> croisementPullman = Arrays.asList(ranaivo, PN, andriatsioharana);
        List<Rue> croisementBalancoire = Arrays.asList(BE, BB, BP, BH);
        List<Rue> croisementHei = Arrays.asList(HB,HP,HM);

        String stringDepart = depart.getName();
        String stringDestination = destination.getName();

        int indexDepart = avantLeChoixAleatoireString.indexOf(stringDepart);
        int indexDestination = avantLeChoixAleatoireString.indexOf(stringDestination);
        if (avantLeChoixAleatoireString.contains(stringDepart))
        {
            if (avantLeChoixAleatoireString.contains(stringDestination)) {
                if (indexDepart < indexDestination) {
                    for (int i = indexDepart; i <= indexDestination; i++) {
                        result.add(avantLeChoixAleatoireString.get(i));
                        System.out.println(avantLeChoixAleatoireString.get(i));
                    }
                } else {
                    for (int i = indexDepart; i >= indexDestination; i--) {
                        result.add(avantLeChoixAleatoireString.get(i));
                    }
                }
            }
            else {
                for (int i = indexDepart; i <= avantLeChoixAleatoireString.size() - 1; i++) {
                    result.add(avantLeChoixAleatoireString.get(i));
                }
            }
        }
        else if (stringDepart==stringDestination){
            result.add(stringDepart);
        }
        do  {
                if (result.get(result.size()-1).equals(pullman.getName()))
                {
                    Collections.shuffle(croisementPullman,new Random(System.nanoTime()));
                    System.out.println(croisementPullman.get(0));
                    result.add(croisementPullman.get(0).getLieuList().get(1).getName());
                }

                else if (result.get(result.size()-1).equals(balancoire.getName()))
                {
                    Collections.shuffle(croisementBalancoire,new Random(System.nanoTime()));
                    System.out.println(croisementPullman.get(0));
                    result.add(croisementBalancoire.get(0).getLieuList().get(1).getName());
                }

                else
                {
                    Collections.shuffle(croisementHei,new Random(System.nanoTime()));
                    System.out.println(croisementPullman.get(0));
                    if(croisementHei.get(0).getLieuList()==heiMarais){
                        result.add(croisementHei.get(0).getLieuList().get(1).getName());
                        result.add(croisementHei.get(0).getLieuList().get(2).getName());
                    }else {
                        result.add(croisementHei.get(0).getLieuList().get(1).getName());
                    }
                }

        }
        while (result.get(result.size()-1)!=destination.getName());


        /*if(result.get(result.size()-1)!=destination.getName()){
            if (result.get(result.size()-1)!=destination.getName()) {
                if (result.get(result.size()-1).equals(pullman.getName())) {
                    Collections.shuffle(croisementPullman,new Random(System.nanoTime()));
                    result.add(croisementPullman.get(0).getLieuList().get(1).getName());
                }

                else if (result.get(result.size()-1).equals(balancoire.getName())) {
                    Collections.shuffle(croisementBalancoire,new Random(System.nanoTime()));
                    result.add(croisementBalancoire.get(0).getLieuList().get(1).getName());
                }
                else if (result.get(result.size()-1).equals(hei.getName())) {
                    Collections.shuffle(croisementHei,new Random(System.nanoTime()));
                    result.add(croisementHei.get(0).getLieuList().get(1).getName());
                }
                else {
                    System.out.println("erreur");
                }
            }
            else{
                System.out.println("immobile");
            }
        }*/

        return result;
    }
    public static void main(String[] args) {
        Marcheur marcheur=new Marcheur();
        Lieu marais=new Lieu("hei");
        Lieu pullman=new Lieu("esti");
        System.out.println(marche(marais,pullman));
    }
}
