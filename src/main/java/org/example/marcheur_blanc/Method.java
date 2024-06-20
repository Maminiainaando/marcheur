package org.example.marcheur_blanc;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Method {
    public static List<String> marcheSansCarte(Lieu depart, Lieu destination) {
        Lieu hei = new Lieu("hei");
        Lieu sekolintsika = new Lieu("sekolintsika");
        Lieu marais = new Lieu("marais");
        Lieu pullman = new Lieu("pullman");
        Lieu balancoire = new Lieu("balancoire");
        Lieu esti = new Lieu("esti");
        Lieu boulevard = new Lieu("boulevard");
        Lieu nexta = new Lieu("nexta");
        List<Lieu> maraisHei = Arrays.asList(marais, sekolintsika, hei);
        List<Lieu> estiBoulevard=Arrays.asList(esti,boulevard);
        List<Lieu> estiBalancoire=Arrays.asList(esti,balancoire);
        List<Lieu> heiPullman=Arrays.asList(hei,pullman);
        List<Lieu> heiBalancoire=Arrays.asList(hei,balancoire);
        List<Lieu> heiMarais=Arrays.asList(hei,sekolintsika,marais);

        List<Lieu> boulevardEsti = Arrays.asList(boulevard,esti);
        List<Lieu> boulevardBalancoire = Arrays.asList(boulevard,balancoire);

        List<Lieu> pullmanHei = Arrays.asList(pullman,hei);
        List<Lieu> pullmanBalancoire = Arrays.asList(pullman,balancoire);
        List<Lieu> pullmanNextA = Arrays.asList(pullman,nexta);

        List<Lieu> balancoireEsti = Arrays.asList(balancoire,esti);
        List<Lieu> balancoireBoulevard = Arrays.asList(balancoire,boulevard);
        List<Lieu> balancoirePullman = Arrays.asList(balancoire,pullman);
        List<Lieu> balancoireHei = Arrays.asList(balancoire,hei);
        Rue boues=new Rue(boulevardEsti);
        List<String> bouesString = new ArrayList<>();
        for (Lieu lieu : boues.getLieuList()) {
            bouesString.add(lieu.getName());
        }
        Rue bouba=new Rue(boulevardBalancoire);
        List<String> boubaString = new ArrayList<>();
        for (Lieu lieu : bouba.getLieuList()) {
            boubaString.add(lieu.getName());
        }
        Rue EBa=new Rue(estiBalancoire);
        List<String> ebaString = new ArrayList<>();
        for (Lieu lieu : EBa.getLieuList()) {
            ebaString.add(lieu.getName());
        }
        Rue EBo=new Rue(estiBoulevard);
        List<String> eboString = new ArrayList<>();
        for (Lieu lieu : EBo.getLieuList()) {
            eboString.add(lieu.getName());
        }
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

        List<Rue> croisementPullman = Arrays.asList(ranaivo,andriatsioharana);
        List<Rue> croisementBalancoire = Arrays.asList(BE, BB, BP, BH);
        List<Rue> croisementHei = Arrays.asList(HB,HP);

        String stringDepart = depart.getName();
        String stringDestination = destination.getName();

        int indexDepart = avantLeChoixAleatoireString.indexOf(stringDepart);
        int indexDestination = avantLeChoixAleatoireString.indexOf(stringDestination);
        if(avantLeChoixAleatoireString.contains(stringDepart) && avantLeChoixAleatoireString.contains(stringDestination)){
                if (indexDepart < indexDestination) {
                    for (int i = indexDepart; i <= indexDestination; i++) {
                            result.add(avantLeChoixAleatoireString.get(i));
                    }
                }
                else {
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
        do {
            if(result.size()<=1 && stringDestination==stringDepart)
            {
              System.out.println("Reste immobile");
              break;
            }
            else if (result.get(result.size()-1).equals(hei.getName()) && stringDestination.equals(hei.getName()))
            {
                System.out.println("stop");
            }
            else if(result.get(result.size()-1).equals(pullman.getName()))
            {
                if (stringDestination.equals(nexta.getName())) {
                    result.add(PN.getLieuList().get(1).getName());
                    break;
                }
                else {
                    Collections.shuffle(croisementPullman, new Random(System.nanoTime()));
                    if(stringDestination==croisementPullman.get(0).getLieuList().get(1).getName()){
                        result.add(croisementPullman.get(0).getLieuList().get(1).getName());
                        break;
                    }else{
                        result.add(croisementPullman.get(0).getLieuList().get(1).getName());
                    }
                }
            }
            else if (result.get(result.size()-1).equals(balancoire.getName()))
            {
                Collections.shuffle(croisementBalancoire,new Random(System.nanoTime()));
                if(stringDestination==croisementBalancoire.get(0).getLieuList().get(1).getName()){
                    result.add(croisementBalancoire.get(0).getLieuList().get(1).getName());
                    break;
                }
                else{
                    result.add(croisementBalancoire.get(0).getLieuList().get(1).getName());
                }
            }
            else
            {
                Collections.shuffle(croisementHei,new Random(System.nanoTime()));
                result.add(croisementHei.get(0).getLieuList().get(1).getName());
            }
        }
        while (result.get(result.size() - 1)!=stringDestination);

        return result;
    }
}
