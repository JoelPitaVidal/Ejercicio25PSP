package Server;

public class WordUtils {
    // Método para encontrar la palabra más larga en un array de palabras
    public static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            // Comparar la longitud de cada palabra con la longitud de la palabra más larga encontrada hasta ahora
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    // Método para obtener la longitud de una palabra
    public static int getWordLength(String word) {
        return word.length();
    }
}