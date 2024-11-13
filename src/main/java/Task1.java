import java.util.*;

public class Task1 {
    /*
        Skriv en algoritme, der tager en string som input og returnerer det oftest forekommende ord. Stringen er
        almindelig tekst (store og små bogstaver), og ord er adskilte af blanke, kommaer, punktummer eller kombinationer
        af disse (se eksempel nedenfor – du kan antage, at der altid er en blank imellem to ord, og at den sidste
        karakter altid er et punktum). Ord antages at være ens, selv om nogle forekomster begynder med lille bogstav og
        andre med stort bogstav.
        Du kan antage som precondition for algoritmen, at input parameteren kun indeholder små bogstaverer [az] store
        bogstaver [A-Z], blanke, kommaer (,) og punktummer (.).

        Eksempel:
        {The cattle were running back and forth, but there was no wolf to be seen, heard, or smelled, so the shepherd
        decided to take a little nap in a bed of grass and early summer flowers. Soon he was awakened by a sound he had
        never heard before.}
        Det korrekte svar I dette eksempel er ordet a, som forekommer tre gange.
     */

    public static void main(String[] args) {
        System.out.println((dominantWord("The cattle were running back and forth, but there was no wolf to be seen, heard, or smelled, so the shepherd decided to take a little nap in a bed of grass and early summer flowers. Soon he was awakened by a sound he had never heard before.")));
    }

    public static String dominantWord(String s) {

        //We convert the string to a char array to go through and remove '.' and ','. We also make the string lower case.
        char[] dirtyCharArray = s.toLowerCase().toCharArray();
        List<Character> cleanCharacterArray = new ArrayList<>();

        for (char c : dirtyCharArray) {
            if (c != ',' && c != '.') {
                cleanCharacterArray.add(c);
            }
        }

        //After removing all '.' and ',' we build a string again, using Java's StringBuilder
        StringBuilder sb = new StringBuilder();

        for (Character c : cleanCharacterArray) {
            sb.append(c);
        }

        //Then we use the String.split method to make a String array of all the words.
        String[] words = sb.toString().split(" ");

        //Now we put the words in a HashMap to count each occurrence of a word. We also keep track of the highest count so far.
        //The task does not ask us to consider that more than one word can occur the most times, so we just find one
        //single word with most occurences.
        HashMap<String, Integer> uniqueWordCount = new HashMap<>();
        String highestCountWord = "";

        for (String word : words) {
            if (uniqueWordCount.containsKey(word)) {
                uniqueWordCount.put(word, (uniqueWordCount.get(word))+1);
                if (uniqueWordCount.get(word) > uniqueWordCount.get(highestCountWord)) {
                    highestCountWord = word;
                }
            }
            else {
                uniqueWordCount.put(word, 1);
                if (Objects.equals(highestCountWord, "")) {
                    highestCountWord = word;
                }
            }
        }
        return highestCountWord;
    }

}
