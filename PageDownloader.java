import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class PageDownloader {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("https://igihe.com/");
            Downloader downloadEngine = new Downloader(url);
            downloadEngine.startDownload(url);

        }catch(Exception e) {
            System.out.println("Site couldn't be downloaded!!");
            e.printStackTrace();
        }
    }
}
