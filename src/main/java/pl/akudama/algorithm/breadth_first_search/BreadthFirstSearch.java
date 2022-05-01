package pl.akudama.algorithm.breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * BFS - Breadth-First Search give us possibility to find the shortest path between two points.
 * However, the concept of the shortest path can be defined on many ways. Using this algorithm we
 * can: - create AI for playing chess, which will calculate the shortest amount of figure movement
 * to win; - create spell checker module (min amount of changes to have proper word, i.e: reades ->
 * reader its one step to fix - found the nearest doctor Conception: Full connections of the first
 * level is checked firstly before second, thirds etc... It means connections of the first level are
 * added to the list of search before second level, etc. It will give us the nearest matched point.
 */
public class BreadthFirstSearch {

    private final String searchItem;

    private final Map<String, List<String>> graph;

    public BreadthFirstSearch(Map<String, List<String>> graph, String searchItem) {
        this.graph = graph;
        this.searchItem = searchItem;
    }

    public boolean searchFrom(String key) {
        if (null == key || null == graph || null == searchItem) {
            return false;
        }

        Deque<String> deque = new ArrayDeque<>(graph.get(key));
        Set<String> searched = new HashSet<>();
        while (!deque.isEmpty()) {
            String firstValue = deque.pop();
            if (isNotInSearchedAndIsMatched(searched, firstValue)) {
                return true;
            } else {
                List<String> nextGraphKeyValues = graph.get(firstValue);
                if (nextGraphKeyValues != null && !nextGraphKeyValues.isEmpty()) {
                    deque.addAll(nextGraphKeyValues);
                    searched.add(firstValue);
                }
            }
        }
        return false;
    }

    private boolean isNotInSearchedAndIsMatched(Set<String> searched, String key) {
        return !searched.contains(key) && isMatched(key);
    }

    private boolean isMatched(String key) {
        return key.equals(searchItem);
    }
}
