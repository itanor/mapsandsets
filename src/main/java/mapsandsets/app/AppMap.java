package mapsandsets.app;

import static java.lang.String.join;

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
    System.out.println("containsKey: " + containsKey);

    boolean containsValue = hashMap.containsValue("new-key-new-key-new-key");
    System.out.println("containsValue: " + containsValue);

    Set<Entry<String, String>> entrySet = hashMap.entrySet();
    entrySet.forEach(entry -> {
      System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
      if ("new-key-new-key-new-key".equals(entry.getValue())) {
        entry.setValue("updated-key"); // changes in entrySet reflects also on map
      }
    });
    printMap(hashMap);

    Map<String, String> copy = new HashMap<>();
    copy.putAll(hashMap);
    boolean equals = hashMap.equals(copy);
    System.out.println("equals: " + equals);

    String bla = hashMap.get("bla");
    System.out.println("bla: " + bla);
  }

  private static void printMap(Map<String, String> map) {
    map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
  }
}
