import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class PageDownloader {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("https://igihe.com/");
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            File file = new File("C:/Users/uwamg/Desktop/site.html");
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String line = null;
            while ((line = reader.readLine())!=null) {
                writer.write(line);
                System.out.println(line);

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
