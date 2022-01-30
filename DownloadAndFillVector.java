import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;


public class DownloadAndFillVector {
    public static void main(String[] args) throws IOException {
//        System.out.println("there");
        Vector<URL> listOfURLs = new Vector<URL>();
        File f = new File("C:/Users/uwamg/Desktop/site.html");

        Document doc; // set proper Charset (2nd param) and BaseUri (3rd param) here

        {
            try {
                doc = Jsoup.parse(f, null, "");
//            Elements elements = (Elements) doc.select("a");
                for (Element element : doc.select("a")) {
                    // Do something with your links here ...
//                    if(element.attr("href")) {
                        listOfURLs.add((new URL(element.attr("href"))));
                        System.out.println(element.attr("href"));
//                    }
                }

                for (URL listOfURL : listOfURLs) {
                    System.out.print(listOfURL + " ");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
