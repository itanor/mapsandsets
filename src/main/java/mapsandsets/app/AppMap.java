package mapsandsets.app;

import static java.lang.String.join;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AppMap {

  public static void main(String[] args) {
    Map<String, String> simpleMap = Map.of("key1", "value1", "key2", "value2");
    printMap(simpleMap);

    Map<String, String> hashMap = new HashMap<>();
    hashMap.putAll(simpleMap);
    printMap(hashMap);

    hashMap.clear();

    hashMap.put("new-key", null);
    printMap(hashMap);

    hashMap.putIfAbsent("new-key", "new value");
    printMap(hashMap);

    hashMap.compute("new-key", (k, v) -> v.toUpperCase());
    printMap(hashMap);

    hashMap.computeIfAbsent("non-existent-key", k -> k.replaceAll("n", "p"));
    printMap(hashMap);

    hashMap.computeIfPresent("new-key", (k, v) -> join("-", k, k, k));
    printMap(hashMap);

    boolean containsKey = hashMap.containsKey("new-key");
    out.println("containsKey: " + containsKey);

    boolean containsValue = hashMap.containsValue("new-key-new-key-new-key");
    out.println("containsValue: " + containsValue);

    Set<Entry<String, String>> entrySet = hashMap.entrySet();
    entrySet.forEach(entry -> {
      out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
      if ("new-key-new-key-new-key".equals(entry.getValue())) {
        entry.setValue("updated-key"); // changes in entrySet reflects also on map
      }
    });
    printMap(hashMap);

    Map<String, String> copy = new HashMap<>();
    copy.putAll(hashMap);
    boolean equals = hashMap.equals(copy);
    out.println("equals: " + equals);

    String bla = hashMap.get("bla");
    out.println("bla: " + bla);

    String defaultValue = "defaultValue";
    String orDefault = hashMap.getOrDefault("bla", defaultValue);
    out.println("orDefault: " + orDefault);
    bla = hashMap.get("bla");
    out.println("bla: " + bla);

    boolean empty = hashMap.isEmpty();
    out.println("isEmpty: " + empty);

    Set<String> keySet = hashMap.keySet();
    keySet.forEach(out::println);

    hashMap.merge("some-other-key", "other-value", (k, v) -> "xpto");
    String someOtherKeyValue = hashMap.get("some-other-key");
    out.println("someOtherKey: " + someOtherKeyValue);
    hashMap.merge("some-other-key", "other-value", (k, v) -> v.toUpperCase());
    someOtherKeyValue = hashMap.get("some-other-key");
    out.println("someOtherKey: " + someOtherKeyValue);

    String removed = hashMap.remove("some-other-key");
    out.println("removed: " + removed);

    boolean removedEntry = hashMap.remove("non-existent-key", "non-associated-key");
    out.println("removedEntry: " + removedEntry);
    removedEntry = hashMap.remove("non-existent-key", "pop-existept-key");
    out.println("removedEntry: " + removedEntry);

    hashMap.put("a", "a");
    hashMap.replace("a", "aaa");
    String valueForA = hashMap.get("a");
    out.println("a: " + valueForA);
    String replacedBValue = hashMap.replace("b", "bbb");
    out.println("replacedBValue: " + replacedBValue);

    boolean replaced = hashMap.replace("a", "a-a-a", "aa-aa-aa");
    out.println("replaced: " + replaced);
    replaced = hashMap.replace("a", "aaa", "aa-aa-aa");
    out.println("replaced: " + replaced);

    out.println();

    out.println("before replaceAll");
    hashMap.values().forEach(v -> out.println(v));
    hashMap.replaceAll((k, v) -> {
      return v.replaceAll("a", "x").replaceAll("y", "b").replaceAll("c", "z");
    });
    out.println("after replaceAll");
    hashMap.values().forEach(v -> out.println(v));
  }

  private static void printMap(Map<String, String> map) {
    map.forEach((k, v) -> out.println("key: " + k + ", value: " + v));
  }
}
