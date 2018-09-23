package readers;

import analyzers.TextFileAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * В этом классе производится чтение текстовых файлов.
 */
public class TextFileReader implements AbstractReader {

    private TextFileAnalyzer textFileAnalyzer = new TextFileAnalyzer();

    /**
     * Считывание текстового ресурса построчно, и, в зависимости от задания, происходит либо подсчет каждого слова в каждом ресурсе,
     * либо идет проверка на совпадение слов в ресурсах.
     * @param resources массив названий ресурсов, которые мы получаем из командной строки.
     */
    @Override
    public void readResources(int task, String[] resources) {
        StringTokenizer stringTokenizer;
        File file;
        BufferedReader br;
        String resourceLine;
        for (String resource : resources) {
            try {
                file = new File("./Files/" + resource);
                br = new BufferedReader(new FileReader(file));
                while ((resourceLine = br.readLine()) != null) {
                    stringTokenizer = new StringTokenizer(resourceLine, " \t\n\r\f,.:;?![]'()");
                    if (task == 1)
                        textFileAnalyzer.countNumberOfWords(stringTokenizer, resource);
                    else
                        textFileAnalyzer.checkOnCoincidence(stringTokenizer, resource);
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Проверьте правильность названия(-й) ресурса(-ов).");
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (task == 1)
            System.out.println("Анализ вхождений каждого слова был завершен.");
        else
            System.out.println("Совпадений не найдено.");
    }
}