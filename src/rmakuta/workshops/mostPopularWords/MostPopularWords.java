package rmakuta.workshops.mostPopularWords;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostPopularWords {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            String[] strings = new String[links.size()];
            int i = 0;
            List<String> stringList = new ArrayList<>();
            List<Integer> intList = new ArrayList<>();
            for (Element elem : links) {
                strings[i] = elem.text();
                strings[i] = strings[i].toLowerCase();
                strings[i] = strings[i].replaceAll("!", "");
                strings[i] = strings[i].replaceAll("\"", "");
                strings[i] = strings[i].replaceAll("\'", "");
                strings[i] = strings[i].replaceAll("\\.", "");
                strings[i] = strings[i].replaceAll("\\,", "");
                strings[i] = strings[i].replaceAll("\\?", "");
                strings[i] = strings[i].replaceAll("\\:", "");
                strings[i] = strings[i].replaceAll("\\-", "");
                strings[i] = strings[i].replaceAll("\\+", "");
                strings[i] = strings[i].replaceAll("\\[", "");
                strings[i] = strings[i].replaceAll("\\]", "");
                String[] tmpStrArr = strings[i].split(" ");

                for (String s: tmpStrArr){
                    stringList.add(s);
                }
                i++;
            }

            for (int j=0; j<stringList.size(); j++){
                if(stringList.get(j).length() < 4){
                    intList.add(j);
                }
            }

            removeIndexes(intList, stringList);

            printWords(stringList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeIndexes(List<Integer> intList, List<String> stringList){
        int i = 0;
        for (Integer il: intList){
            stringList.remove(stringList.get(il - i++));
        }
    }

    public static void printWords(List<String> stringList){
        for (String s: stringList){
            System.out.println(s + ": " + s.length());
        }
    }
}
