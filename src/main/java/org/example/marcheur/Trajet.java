package org.example.marcheur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trajet {

    public List<String> marche(String lieuDepart, String lieuDestination, List<Object> carte) {
        List<String> simpleStrings = extractStringLocations(carte);

        List<String> st1 = getPath(simpleStrings, lieuDepart);

        List<String> targetStrings = new ArrayList<>(simpleStrings);
        List<List<String>> targetLists = Arrays.asList(
                Arrays.asList("Balancoire", "Esti", "Boulvard")
        );

        List<String> rp = findRelevantPaths(carte, targetStrings, targetLists);

        List<String> st1Mod = modifyPath(st1, rp);

        appendDestinationPath(st1Mod, targetLists, lieuDestination);

        return st1Mod;
    }

    private List<String> extractStringLocations(List<Object> carte) {
        List<String> simpleStrings = new ArrayList<>();
        for (Object element : carte) {
            if (element instanceof String) {
                simpleStrings.add((String) element);
            }
        }
        return simpleStrings;
    }

    private List<String> getPath(List<String> simpleStrings, String lieuDepart) {
        List<String> path = new ArrayList<>();
        int indexDepart = simpleStrings.indexOf(lieuDepart);
        if (indexDepart == -1) return path;

        for (int i = indexDepart; i >= 0; i--) {
            path.add(simpleStrings.get(i));
        }
        for (int i = 1; i <= indexDepart; i++) {
            path.add(simpleStrings.get(i));
        }
        for (int i = indexDepart + 1; i < simpleStrings.size(); i++) {
            path.add(simpleStrings.get(i));
        }
        for (int i = simpleStrings.size() - 2; i >= indexDepart; i--) {
            path.add(simpleStrings.get(i));
        }
        return path;
    }
    private List<String> findRelevantPaths(List<Object> carte, List<String> targetStrings, List<List<String>> targetLists) {
        List<String> rp = new ArrayList<>();
        for (int i = 0; i < carte.size(); i++) {
            Object current = carte.get(i);
            if (targetStrings.contains(current)) {
                if (isRelevantAdjacent(carte, targetLists, i - 1) || isRelevantAdjacent(carte, targetLists, i + 1)) {
                    rp.add((String) current);
                }
            }
        }
        return rp;
    }

    // Check if adjacent element is a relevant list
    private boolean isRelevantAdjacent(List<Object> carte, List<List<String>> targetLists, int index) {
        return index >= 0 && index < carte.size() && carte.get(index) instanceof List && targetLists.contains(carte.get(index));
    }

    // Modify the path based on occurrences in rp
    private List<String> modifyPath(List<String> path, List<String> rp) {
        List<String> modifiedPath = new ArrayList<>();
        if (rp.isEmpty()) return path;
        int occurrence = 0;
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i).equals(rp.get(0))) {
                occurrence++;
                if (occurrence == 2) {
                    return path.subList(0, i + 1);
                }
            }
        }
        return path;
    }

    private void appendDestinationPath(List<String> st1Mod, List<List<String>> targetLists, String lieuDestination) {
        for (List<String> list : targetLists) {
            int index = list.indexOf(lieuDestination);
            if (index != -1) {
                for (String loc : list) {
                    if (!loc.equals(lieuDestination)) {
                        st1Mod.add(loc);
                    }
                }
                st1Mod.add(lieuDestination);
                break;
            }
        }
    }
}
