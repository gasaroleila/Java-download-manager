import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


public class DownloadAndFillVector {

    public DownloadAndFillVector() {

    }
    public Vector<URL> extractLinks(File siteFile) throws IOException {
        Vector<URL> listOfURLs = new Vector<URL>();
//        File f = new File("C:/Users/uwamg/Desktop/site.html");

        Document doc; // set proper Charset (2nd param) and BaseUri (3rd param) here

        {
            try {
                doc = Jsoup.parse(siteFile, null, "");
//            Elements elements = (Elements) doc.select("a");
                for (Element element : doc.select("a")) {
                    // Do something with your links here ...
                    if(element.attr("href").contains("https")|| element.attr("href").contains("http")) {
//                        System.out.println("link");
                        listOfURLs.add((new URL(element.attr("href"))));
//                        System.out.println(element.attr("href"));
                    }
//                    else {
//                        System.out.println("not url");
//                    }
                }

                for (URL listOfURL : listOfURLs) {
                    System.out.println(listOfURL + " ");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listOfURLs;

    }


}
