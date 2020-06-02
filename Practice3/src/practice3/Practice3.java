package practice3;

import java.awt.*;  

import java.awt.image.BufferedImage;  
import java.io.ByteArrayInputStream;  
import java.io.IOException;  
import javax.imageio.ImageIO;  
import javax.swing.*;  
import org.opencv.core.Core;  
import org.opencv.core.Mat;  
import org.opencv.core.MatOfByte;  
import org.opencv.core.MatOfRect;  
import org.opencv.core.Point;  
import org.opencv.core.Rect;  
import org.opencv.core.Scalar;  
import org.opencv.core.Size;  
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;  
import org.opencv.objdetect.CascadeClassifier;  
import org.opencv.videoio.VideoCapture;

class FacePanel extends JPanel{  
    
     private BufferedImage image;  
     // Create a constructor
 
     /*  
      * Convert a Mat into a BufferedImage.  
      *   
      * @param matrix Mat of type CV_8UC3 or CV_8UC1  
      * @return BufferedImage of type TYPE_3BYTE_BGR or TYPE_BYTE_GRAY  
      */       
     public boolean matToBufferedImage(Mat matrix) {  
          MatOfByte mb = new MatOfByte();  
          Imgcodecs.imencode(".jpg", matrix, mb);  
          try {  
               this.image = ImageIO.read(new ByteArrayInputStream(mb.toArray()));  
          } catch (IOException e) {  
               e.printStackTrace();  
               return false; // Error  
          }  
       return true; // Successful  
     }  
     @Override
     public void paintComponent(Graphics g){  
          super.paintComponent(g);   
          if (this.image==null) return;         
           g.drawImage(this.image,10,10,this.image.getWidth(),this.image.getHeight(), null);
     }
}  

class FaceDetector {  
     private final CascadeClassifier face_cascade;  
     // Create a constructor method  
     public FaceDetector(){  
         // face_cascade=new CascadeClassifier("./cascades/lbpcascade_frontalface_alt.xml");  
         
        face_cascade = new CascadeClassifier("D:\\OpenCV\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml"); 
          if(face_cascade.empty())  
          {  
               System.out.println("--(!)Error loading(!)--\n");  
                return;  
          }  
          else  
          {  
                     System.out.println("Face classifier loaded up");  
          }  
     }  
     public Mat detect(Mat inputframe){  
          Mat matrix =new Mat();  
   
          MatOfRect faces = new MatOfRect();  
          inputframe.copyTo(matrix);   
          face_cascade.detectMultiScale(matrix, faces);  
          System.out.println(String.format("Detected %s faces", faces.toArray().length));  
          for(Rect rect:faces.toArray())  
          {  
              Imgproc.rectangle(matrix, // where to draw the box
                new Point(rect.x, rect.y), // bottom left
                new Point(rect.x + rect.width, rect.y + rect.height), // top right
                new Scalar(0, 0, 255), //RGB color
                3); // Thickness
          }  
          return matrix;  
     }  
}  
public class Practice3 {  
    
      public static void main(String arg[]) throws InterruptedException{  
      // Load the native library.  
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
      //or ...     System.loadLibrary("opencv-340");       

      //make the JFrame
      JFrame frame = new JFrame("WebCam Capture - Face detection");  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
     
      FaceDetector faceDetector=new FaceDetector();  
      FacePanel facePanel = new FacePanel();  
      frame.setSize(400,400); //give the frame some arbitrary size 
      frame.setBackground(Color.BLUE);
      frame.add(facePanel,BorderLayout.CENTER);       
      frame.setVisible(true);       
      
      //Open and Read from the video stream  
       Mat webcam_image=new Mat();  
       VideoCapture webCam =new VideoCapture(0);   
   
        if(webCam.isOpened())  
          {  
           System.out.println("Found Webcam");
           Thread.sleep(500); /// This one-time delay allows the Webcam to initialize itself  
           while(true)  
           {  
        	 webCam.read(webcam_image);  
             if(!webcam_image.empty())  
              {   
            	   //Thread.sleep(200); /// This delay eases the computational load .. with little performance leakage
                   frame.setSize(webcam_image.width()+40, webcam_image.height()+60);  
                   //Apply the classifier to the captured image  
                   webcam_image = faceDetector.detect(webcam_image);  
                   //Display the image  
                   facePanel.matToBufferedImage(webcam_image);  
                   facePanel.repaint();   
              }  
              else
              {   
                   System.out.println(" --(!) No captured frame from webcam (!)--");   
                   break;   
              }  
             }  
            }
        else
        {
            System.out.println("Did not connect to camera !!");
        }
           webCam.release(); //release the webcam
      } //end main 	
}