package analyzers;

import java.util.*;

/**
 * Анализатор текстовых файлов, который наследуется от абстрактного анализатора.
 */
public class TextFileAnalyzer implements AbstractAnalyzer {

    private HashMap<String, String> tokensInResource = new HashMap<>();
    private HashMap<String, Integer> numberOfTokens = new HashMap<>();

    /**
     * Проверка на совпадение токенов в файлах.
     * @param tokenizer объект, хранящий в себе токены строки.
     * @param resource название ресурса.
     */
    @Override
    public void checkOnCoincidence(StringTokenizer tokenizer, String resource) {
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().toLowerCase();
            if (!tokensInResource.containsKey(token)) {
                tokensInResource.put(token, resource);
            } else {
                if (tokensInResource.get(token).equals(resource))
                    System.out.println("Совпадение слова '" + token + "' в файле " + tokensInResource.get(token));
                else
                    System.out.println("Совпадение слова '" + token + "' в файлах " + tokensInResource.get(token) + " и '" + resource + "'.");
                System.exit(0);
            }
        }
    }

    /**
     * Вывод на экран количество вхождений каждого слова.
     * @param tokenizer объект, хранящий в себе токены строки.
     * @param resource название ресурса.
     */
    @Override
    public void countNumberOfWords(StringTokenizer tokenizer, String resource) {
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().toLowerCase();
            if (!numberOfTokens.containsKey(token)) {
                numberOfTokens.put(token, 1);
                System.out.println("Слово '" + token + "' встречается " + numberOfTokens.get(token) + " раз.");
            } else {
                numberOfTokens.put(token, numberOfTokens.get(token) + 1);
                System.out.println("Слово '" + token + "' встречается " + numberOfTokens.get(token) + " раз.");
            }
        }
    }
}