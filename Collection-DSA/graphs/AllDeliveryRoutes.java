import java.util.*;

public class AllDeliveryRoutes {
    public List<List<Integer>> allRoutes(Map<Integer, List<Integer>> roads, int start, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        backtrack(roads, start, target, new ArrayList<>(), new HashSet<>(), allRoutes);
        return allRoutes;
    }

    private void backtrack(Map<Integer, List<Integer>> roads, int current, int target,
                           List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    backtrack(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }
}
