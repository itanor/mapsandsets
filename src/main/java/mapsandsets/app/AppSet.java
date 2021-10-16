package mapsandsets.app;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Spliterator;

public class AppSet {
  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    hashSet.add("a");
    hashSet.add("c");
    hashSet.add("v");
    hashSet.add("z");
    hashSet.add("b");

    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.addAll(hashSet);

    out.println("hashSet size: " + hashSet.size());
    out.println("linkedHashSet size: " + linkedHashSet.size());
    hashSet.clear();
    out.println("hashSet size: " + hashSet.size());
    out.println("linkedHashSet size: " + linkedHashSet.size());

    hashSet.add("a");
    hashSet.add("b");
    hashSet.add("c");
    hashSet.add("v");
    hashSet.add("z");

    boolean containsA = hashSet.contains("a");
    out.println("containsA: " + containsA);

    boolean containsAll = hashSet.containsAll(linkedHashSet);
    out.println("containsAll: " + containsAll);
    containsAll = hashSet.containsAll(Set.of("a", "b", "c", "v", "z", "s"));
    out.println("containsAll: " + containsAll);

    boolean hashSetEqualsLinkedHashSet = hashSet.equals(linkedHashSet);
    out.println("hashSetEqualsLinkedHashSet: " + hashSetEqualsLinkedHashSet);

    boolean empty = hashSet.isEmpty();
    out.println("empty: " + empty);

    Iterator<String> iterator = hashSet.iterator();
    while (iterator.hasNext()) {
      iterator.next();
      iterator.remove(); // changes in iterator also reflect on set
    }
    empty = hashSet.isEmpty();
    out.println("empty: " + empty);

    hashSet.add("a");
    hashSet.add("b");
    hashSet.add("c");
    hashSet.add("v");
    hashSet.add("z");
    hashSet.add("0");
    hashSet.add("1");

    boolean removed = hashSet.remove("z");
    out.println("removed: " + removed);

    boolean removedVandC = hashSet.removeAll(Set.of("v", "c"));
    out.println("removedVandC: " + removedVandC);

    hashSet.removeIf(e -> {
      String number = "-?\\d+(\\.\\d+)?";
      return e.matches(number);
    });
    hashSet.forEach(out::println);

    hashSet.add("g");
    hashSet.add("k");

    boolean retainAll = hashSet.retainAll(Set.of("g", "k"));
    out.println("retainAll: " + retainAll);
    hashSet.forEach(out::println);

    Spliterator<String> spliterator = hashSet.spliterator();
    spliterator.tryAdvance(out::println);
    spliterator.tryAdvance(out::println);
    spliterator.tryAdvance(out::println);
  }
}
