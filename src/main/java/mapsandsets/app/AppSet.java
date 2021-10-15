package mapsandsets.app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AppSet {
  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    hashSet.add("a");
    hashSet.add("c");
    hashSet.add("v");
    hashSet.add("z");
    hashSet.add("b");

    System.out.println("without order set");
    hashSet.forEach(System.out::println);

    Set<String> treeSet = new TreeSet<>();
    treeSet.add("z");
    treeSet.add("c");
    treeSet.add("b");
    treeSet.add("v");
    treeSet.add("a");

    System.out.println("with order set");
    treeSet.forEach(System.out::println);

    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.addAll(hashSet);
  }
}
