package main;

import readers.TextFileReader;

import java.util.Arrays;

/**
 * Главный класс, откуда начинается чтение и анализ файлов.
 */
public class Main {

    public static void main(String[] args) {

        if (args.length >= 3 && args[0].equals("-t") && (args[1].equals("1") || args[1].equals("2"))) {
            TextFileReader textFileReader = new TextFileReader();
            textFileReader.readResources(Integer.valueOf(args[1]), Arrays.copyOfRange(args, 2, args.length));
        } else {
            System.out.println("Укажите номер задания (1 или 2), используя флаг '-t', и название(-я) ресурса(-ов) (например, -t 1 text1.txt text2.txt).");
            System.exit(-1);
        }
    }
}