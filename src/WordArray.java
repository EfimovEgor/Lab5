import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordArray {
    public static void main(String[] args) {
        String[] words = {"яблоко", "банан", "яблоко", "вишня", "апельсин", "груша", "яблоко", "вишня", "персик", "банан"};

        System.out.println("\nКоличество использования каждого слова:");
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
