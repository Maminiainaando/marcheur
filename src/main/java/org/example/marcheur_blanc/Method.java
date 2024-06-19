package org.example.marcheur_blanc;

import java.util.*;
import java.util.stream.Collectors;

public class Method {
    public static List<String> marche(Lieu depart,Lieu destination) {
        Lieu hei = new Lieu("hei");
        Lieu sekolintsika = new Lieu("sekolintsika");
        Lieu marais = new Lieu("marais");
        Lieu pullman = new Lieu("pullman");
        Lieu balancoire = new Lieu("balancoire");
        Lieu esti = new Lieu("esti");
        Lieu boulevard = new Lieu("boulevard");
        Lieu nexta = new Lieu("nexta");
        List<Lieu> maraisHei = Arrays.asList(marais, sekolintsika, hei);

        List<Lieu> pullmanHei = Arrays.asList(pullman, hei);
        List<Lieu> pullmanBalancoire = Arrays.asList(pullman, balancoire);
        List<Lieu> pullmanNextA = Arrays.asList(pullman, nexta);

        List<Lieu> balancoireEsti = Arrays.asList(balancoire, esti);
        List<Lieu> balancoireBoulevard = Arrays.asList(balancoire, boulevard);
        List<Lieu> balancoirePullman = Arrays.asList(balancoire, pullman);
        List<Lieu> balancoireHei = Arrays.asList(balancoire, hei);

        Rue andriatsioharana = new Rue(pullmanHei);
        List<String> andriatsioharanaString=new ArrayList<>();
        for (Lieu lieu : andriatsioharana.getLieuList()) {
            andriatsioharanaString.add(lieu.getName());
        }

        Rue ranaivo = new Rue(pullmanBalancoire);
        List<String> ranaivoString=new ArrayList<>();
        for (Lieu lieu : ranaivo.getLieuList()) {
            ranaivoString.add(lieu.getName());
        }

        Rue avantLeChoixAleatoire = new Rue(maraisHei);
        List<String> avantLeChoixAleatoireString = new ArrayList<>();
        for (Lieu lieu : avantLeChoixAleatoire.getLieuList()) {
            avantLeChoixAleatoireString.add(lieu.getName());
        }

        Rue BE = new Rue(balancoireEsti);
        List<String> beString=new ArrayList<>();
        for (Lieu lieu : BE.getLieuList()) {
            beString.add(lieu.getName());
        }

        Rue BB = new Rue(balancoireBoulevard);
        List<String> bbString=new ArrayList<>();
        for (Lieu lieu : BB.getLieuList()) {
            bbString.add(lieu.getName());
        }

        Rue BP = new Rue(balancoirePullman);
        List<String> bpString=new ArrayList<>();
        for (Lieu lieu : BP.getLieuList()) {
            bpString.add(lieu.getName());
        }

        Rue BH = new Rue(balancoireHei);
        List<String> bhString=new ArrayList<>();
        for (Lieu lieu : BH.getLieuList()) {
            bhString.add(lieu.getName());
        }

        Rue PN = new Rue(pullmanNextA);
        List<String> pnString=new ArrayList<>();
        for (Lieu lieu : PN.getLieuList()) {
            pnString.add(lieu.getName());
        }

        List<String> result = new ArrayList<>();

        List<Rue> croisementPullman = Arrays.asList(ranaivo, PN, andriatsioharana);
        List<Rue> croisementBalancoire = Arrays.asList(BE, BB, BP, BH);
        List<Rue> croisementHei = Arrays.asList(andriatsioharana, avantLeChoixAleatoire, BH);

        String stringDepart = depart.getName();
        String stringDestination = destination.getName();
        List<String> manipulation=new ArrayList<>();

        int indexDepart = avantLeChoixAleatoireString.indexOf(stringDepart);
        int indexDestination = avantLeChoixAleatoireString.indexOf(stringDestination);

        if (avantLeChoixAleatoireString.contains(stringDepart)) {
            if (avantLeChoixAleatoireString.contains(stringDestination)) {
                if (indexDepart < indexDestination) {
                    for (int i = indexDepart; i <= indexDestination; i++) {
                        result.add(avantLeChoixAleatoireString.get(i));
                        System.out.println(avantLeChoixAleatoireString.get(i));
                    }
                }
                else {
                    for (int i = indexDepart; i >= indexDestination; i--) {
                        result.add(avantLeChoixAleatoireString.get(i));
                        System.out.println(avantLeChoixAleatoireString.get(i));
                    }
                }
            }else {}

        }
        else{
            result.add(stringDepart);
            if(stringDepart.equals(pullman.getName())){
                Collections.shuffle(croisementPullman,new Random(System.nanoTime()));
                if(croisementPullman.get(0).getLieuList().get(0).getName()==stringDepart){
                    for (int i = 1; i < croisementPullman.get(0).getLieuList().size(); i++) {
                        if(croisementPullman.get(0).getLieuList().get(i).getName()==destination.getName()){
                            break;
                        }
                        else{
                            result.add(croisementPullman.get(0).getLieuList().get(i).getName());
                            Collections.shuffle(croisementBalancoire,new Random(System.nanoTime()));
                            if(croisementPullman.get(0).getLieuList().get(croisementPullman.get(0).getLieuList().size()-1).equals(balancoire.getName())){
                                if(croisementBalancoire.get(0).getLieuList().get(0).getName()==croisementPullman.get(0).getLieuList().get(croisementPullman.get(0).getLieuList().size()-1).getName()){
                                    for (int j = 1; j < croisementBalancoire.get(0).getLieuList().size(); j++) {
                                        if(croisementBalancoire.get(0).getLieuList().get(i).getName()==destination.getName()){
                                            break;
                                        }else {
                                            result.add(croisementBalancoire.get(0).getLieuList().get(j).getName());
                                            Collections.shuffle(croisementHei,new Random(System.nanoTime()));

                                            if(croisementHei.get(0).getLieuList().get(croisementHei.get(0).getLieuList().size()-1).equals(hei.getName())){
                                                if(croisementHei.get(0).getLieuList().get(i).getName()==destination.getName()){
                                                    break;
                                                }else {
                                                    result.add(croisementHei.get(0).getLieuList().get(j).getName());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return result;
        }

    public static void main(String[] args) {
        Marcheur marcheur=new Marcheur();
        Lieu marais=new Lieu("pullman");
        Lieu hei=new Lieu("esti");
       System.out.println(marche(marais,hei));
    }
}
