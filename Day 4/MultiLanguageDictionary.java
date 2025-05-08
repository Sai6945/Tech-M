package Day5;

import java.util.*;

//Generic Multi-Language Dictionary
class MultiLanguageDictionary<T extends String, U extends String> {
 private TreeMap<T, U> dictionary = new TreeMap<>();

 public void addWord(T word, U meaning) {
     dictionary.put(word, meaning);
 }

 public void displayDictionary() {
     System.out.println("Dictionary Entries:");
     for (Map.Entry<T, U> entry : dictionary.entrySet()) {
         System.out.println(entry.getKey() + " - " + entry.getValue());
     }
 }

 public void displaySortedByLength() {
     List<Map.Entry<T, U>> sortedEntries = new ArrayList<>(dictionary.entrySet());
     
     sortedEntries.sort(Comparator.comparingInt(e -> e.getKey().length()));
     
     System.out.println("\nDictionary Sorted by Word Length:");
     for (Map.Entry<T, U> entry : sortedEntries) {
         System.out.println(entry.getKey() + " - " + entry.getValue());
     }
 }

 public static void main(String[] args) {
     MultiLanguageDictionary<String, String> dictionary = new MultiLanguageDictionary<>();
     dictionary.addWord("Bonjour", "Hello (French)");
     dictionary.addWord("Hola", "Hello (Spanish)");
     dictionary.addWord("Ciao", "Hello (Italian)");
     dictionary.addWord("Hallo", "Hello (German)");

     dictionary.displayDictionary();
     dictionary.displaySortedByLength();
 }
}