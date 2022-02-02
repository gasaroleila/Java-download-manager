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
    public Vector<URL> extractLinks(File siteFile, URL siteLink) throws IOException {
        Vector<URL> listOfURLs = new Vector<URL>();
//        File f = new File("C:/Users/uwamg/Desktop/site.html");

        Document doc; // set proper Charset (2nd param) and BaseUri (3rd param) here

        {
            try {
                doc = Jsoup.parse(siteFile, null, "");
//            Elements elements = (Elements) doc.select("a");
                for (Element element : doc.select("a")) {
                    String link = element.attr("href");
                    if(!link.contains("#") && !link.contains("./") && !link.contains("https") && !link.contains("http")) {
                        link = siteLink+link;
                        listOfURLs.add((new URL(link)));
                    }
                }

                for (URL listOfURL : listOfURLs) {
                    System.out.println(listOfURL + " ");
                }

            } catch (IOException e) {
                System.out.println("Site couldn't be downloaded!!");
            }
        }

        return listOfURLs;

    }


}
