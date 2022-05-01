package pl.akudama.algorithm.breadth_first_search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BreadthFirstSearchTest {

    @Test
    void shouldFindItem_forSearchFrom() {
        // given
        String searchItem = "x";
        List<String> a = List.of("b", "c", "d");
        List<String> b = List.of("b1", "b2");
        List<String> c = List.of("c1");
        List<String> d = List.of("d1", "d2");
        List<String> c1 = List.of(searchItem);

        Map<String, List<String>> graph = Map.of("a", a, "b", b, "c", c, "d", d, "c1", c1);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, searchItem);

        // when
        boolean result = breadthFirstSearch.searchFrom("a");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void shouldNotFindItem_forSearchFrom_whenSearchItemNotMatched() {
        // given
        String searchItem = "1";
        List<String> a = List.of("b", "c", "d");
        List<String> b = List.of("b1", "b2");
        List<String> c = List.of("c1");
        List<String> d = List.of("d1", "d2");
        List<String> c1 = List.of("c1_1");

        Map<String, List<String>> graph = Map.of("a", a, "b", b, "c", c, "d", d, "c1", c1);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, searchItem);

        // when
        boolean result = breadthFirstSearch.searchFrom("a");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotFindItem_forSearchFrom_whenSearchItemIsNull() {
        // given
        List<String> a = List.of("b", "c", "d");
        List<String> b = List.of("b1", "b2");
        List<String> c = List.of("c1");
        List<String> d = List.of("d1", "d2");
        List<String> c1 = List.of("c1_1");

        Map<String, List<String>> graph = Map.of("a", a, "b", b, "c", c, "d", d, "c1", c1);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, null);

        // when
        boolean result = breadthFirstSearch.searchFrom("a");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotFindItem_forSearchFrom_whenGraphIsNull() {
        // given
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(null, "x");

        // when
        boolean result = breadthFirstSearch.searchFrom("a");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotFindItem_forSearchFrom_whenSearchItemAndGraphAreNull() {
        // given
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(null, null);

        // when
        boolean result = breadthFirstSearch.searchFrom("a");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotFindItem_forSearchFrom_whenSearchFromKeyIsNull() {
        // given
        String searchItem = "x";
        List<String> a = List.of("b", "c", "d");
        List<String> b = List.of("b1", "b2");
        List<String> c = List.of("c1");
        List<String> d = List.of("d1", "d2");
        List<String> c1 = List.of(searchItem);

        Map<String, List<String>> graph = Map.of("a", a, "b", b, "c", c, "d", d, "c1", c1);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, searchItem);

        // when
        boolean result = breadthFirstSearch.searchFrom(null);

        // then
        assertThat(result).isFalse();
    }
}
