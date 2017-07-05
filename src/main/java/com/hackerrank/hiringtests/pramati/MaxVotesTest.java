import java.util.*;
import java.util.stream.Collectors;

public class MaxVotesTest {
    public static void main(String[] args) {
        String[] votes = {"a", "b", "c", "b", "d", "a", "b", "c", "c"};
        List<String> voteList = Arrays.asList(votes);
        Map<String, Long> voteCountMap = voteList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Long max = voteCountMap.values().stream().max(Comparator.comparing(Long::longValue)).get();
        Map<String, Long> maxVotesMap = voteCountMap.entrySet().stream().filter(e -> e.getValue() ==
                max).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        List<String> maxVotedMembers = maxVotesMap.keySet().stream().collect(java.util.stream.Collectors.toList());
        Collections.sort(maxVotedMembers);
        System.out.println(maxVotedMembers.get(maxVotedMembers.size() - 1));
    }
}
