package org.example.marcheur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.carte.Carte;
public class Trajet {
  public List<String> marche(String depart,String destination) {
    Carte carte=new Carte();
   List<String> result=new ArrayList<>();
    List<String> heiPullman=Arrays.asList("balancoire","esti","boulevard","balancoire","hei","pullman");
    List<String> pullmanNextA=Arrays.asList("balancoire","esti","boulevard","balancoire","pullman","esti");
    List<String> stringList=new ArrayList<>();
    for (Object object:carte.getCarteObject()) {
      if(object instanceof String){
        stringList.add((String) object);
      }
    }

      if(stringList.contains(depart) && stringList.contains(destination)){
        int indexDepart=stringList.indexOf(depart);
        int indexDestination=stringList.indexOf(destination);
        if(indexDepart<indexDestination){
          for (int i = indexDepart; i < indexDestination ; i++) {
            result.add(stringList.get(i));
          }
        }else {
          for (int i =indexDepart; i > indexDestination ; i--) {
            result.add(stringList.get(i));
          }
        }

      }
      else if (heiPullman.contains(depart) && heiPullman.contains(destination)) {
        int indexDepart=heiPullman.indexOf(depart);
        int indexDestination=heiPullman.indexOf(destination);
        if(indexDepart<indexDestination){
          for (int i = indexDepart; i < indexDestination ; i++) {
            result.add(heiPullman.get(i));
          }
        }else {
          for (int i = indexDepart; i > indexDestination ; i--) {
            result.add(heiPullman.get(i));
          }
        }
      }
      else if (pullmanNextA.contains(depart) && pullmanNextA.contains(destination)){
        int indexDepart= pullmanNextA.indexOf(depart);
        int indexDestination= pullmanNextA.indexOf(destination);
        if(indexDepart<indexDestination){
          for (int i = indexDepart; i < indexDestination; i++) {
            result.add(pullmanNextA.get(i));
          }
        }else {
          for (int i = indexDepart; i > indexDestination; i--) {
            result.add(pullmanNextA.get(i));
          }
        }
        }
      else {
        int indexDepart= carte.getOriginalList().indexOf(depart);
        int indexDestination=carte.getOriginalList().indexOf(destination);
        if(indexDepart<indexDestination) {
          for (int i = indexDepart; i <indexDestination ; i++) {
            result.add(carte.getOriginalList().get(i));
          }
        }else {
          for (int i = indexDepart; i >indexDestination ; i--) {
            result.add(carte.getOriginalList().get(i));
          }
        }
      }
      result.add(destination);
    return result;
  }
}
