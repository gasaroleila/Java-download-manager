import java.net.URL;
import java.util.Vector;

public class Downloader {
    Vector<URL> listOfURLs = new Vector<URL>();
    int sizeOfUrls = listOfURLs.size();

    public Downloader(URL link) {
    }

    public void startDownload(URL link) {
        for(int i=0; i<sizeOfUrls; i++) {
            new Downloader(listOfURLs.get(i));
       }
    }
}
