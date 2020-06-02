package filedownload;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {

    public static void main(String[] args) throws IOException  {
        String url = "http://newlovewallpapers.in/images/beautiful-love-pictures-images-photos/beautiful-love-pictures-images-photos-1-1280.jpg";
        
        try {
            //downloadUsingNIO(url, "https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&h=350");
            
            downloadUsingStream(url, "/Users/jagan/desktop/image.jpg");
             Runtime.getRuntime().exec("C:\\Windows\\System32\\mspaint.exe C:\\Users\\Jagan\\Desktop\\image.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
         
    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}
