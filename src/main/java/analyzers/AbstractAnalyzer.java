package analyzers;

import java.util.StringTokenizer;

/**
 * Интерфейс для анализаторов различных типов данных.
 */
public interface AbstractAnalyzer {

    void checkOnCoincidence(StringTokenizer tokenizer, String resource);

    void countNumberOfWords(StringTokenizer tokenizer, String resource);
}
