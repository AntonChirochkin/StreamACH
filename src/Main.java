import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Automobile> automobileStream = Stream.of(new Automobile("Audi", 2023),
                new Automobile("BMW", 2022),
                new Automobile("MERSEDES", 2020),
                new Automobile("LADA", 2010));

        BiConsumer<Automobile, Automobile> biConsumer = (min, max) -> System.out.println(max.toString() + ", " + min.toString());
        Comparator<Automobile> automobileComparator = Comparator.comparing(Automobile::getYearRelease).thenComparing(Automobile::getBrand);
        findMinMax(automobileStream, automobileComparator, biConsumer);

        findAnEvenNumber(List.of(78, 41, 89, 90, 32, 67, 45, 44, 68, 42, 54, 77));
        findAnEvenNumber1(List.of(56, 41, 89, 91, 33, 67, 45, 44, 68, 42, 54, 77, 444));


    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
        }
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));

    }

    public static void findAnEvenNumber(List <Integer> list) {
        Stream<Integer> nam = list.stream();
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        Stream<Integer> integerStream = nam.filter(predicate);
        System.out.println("Количество четных чисел: " + integerStream.count());
    }
    public static void findAnEvenNumber1(List <Integer> list) {
       int count = (int) (list.stream().filter((n) -> (n % 2) == 0)).count();
        System.out.println("Количество четных чисел: " + count);
    }

}
