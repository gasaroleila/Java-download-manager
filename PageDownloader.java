import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class PageDownloader {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("https://twitter.com/home");
            Downloader downloadEngine = new Downloader(url);
            downloadEngine.startDownload(url);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
