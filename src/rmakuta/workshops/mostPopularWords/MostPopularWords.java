package rmakuta.workshops.mostPopularWords;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class MostPopularWords {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            FileWriter fileWriter = new FileWriter("popular_words.txt", true);

            for (Element elem : links) {
                String[] row = elem.text().split("[ :!?;,\\.\"]+");
                for (int i=0; i<row.length; i++){
                    row[i] = row[i].toLowerCase();
                    if(row[i].length() > 3){
                        fileWriter.append(row[i] + "\n");
                    }
                }
            }
            fileWriter.close();

            String[] excludedWords = {"jest", "które", "tylko", "przez", "żeby", "gwałt", "takiego"};
            File file = new File("popular_words.txt");
            Scanner scan = new Scanner(file);
            FileWriter fileFilteredWriter = new FileWriter("filtered_popular_words.txt", true);

            while (scan.hasNextLine()){
                String word = scan.nextLine();
                int index = 0;
                for (String e: excludedWords){
                    if(!word.equals(e)){
                        index++;
                    }
                }
                if(index == excludedWords.length){
                    fileFilteredWriter.append(word + "\n");
                }
            }
            fileFilteredWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
