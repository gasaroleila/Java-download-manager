import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

public class Downloader {


    public Downloader(URL link) {
    }

    public void startDownload(URL link) throws IOException {

        try {
            URLConnection connection = link.openConnection();
            int size = connection.getContentLength();
//            double percCount = 0.0;

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            File file = new File("./site.html");
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String line = null;
            while ((line = reader.readLine())!=null) {
                writer.write(line);
//                percCount += line.getBytes();
//                if (size > 0) {
//                    System.out.println("Percentace: " + (percCount / size * 100.0) + "%");
//                }
            }

            Vector<URL> listOfURLs = new DownloadAndFillVector().extractLinks(file,link);
            int sizeOfUrls = listOfURLs.size();

            for(int i=0; i<sizeOfUrls; i++) {
                URLConnection connection2 = listOfURLs.get(i).openConnection();
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
                String path = "./site";
                File file2 = new File(path+i+".html");
                FileWriter fw2 = new FileWriter(file2);
                BufferedWriter writer2 = new BufferedWriter(fw2);
                String line2 = null;
                while ((line2 = reader2.readLine())!=null) {
                    writer2.write(line2);
                }
            }
        }catch (Exception e) {
            System.out.println("Site couldn't be downloaded fully!!");
        }

    }


}
