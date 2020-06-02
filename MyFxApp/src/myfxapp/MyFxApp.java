package myfxapp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
public class MyFxApp 
{
    public static void main(String args[]) throws Exception
    {
        //Loading the OpenCV core library
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        VideoCapture capture = new VideoCapture();
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH,640);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT,480);
        
        // Reading the next video frame from the camera
        Mat matrix = new Mat();
        capture.read(matrix);
        // If camera is opened
        if( capture.isOpened()){
        // If there is next video frame
        if (capture.read(matrix)){

        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", matrix, matOfByte);
        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();
        //Preparing the Buffered Image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);
        //Instantiate JFrame
        JFrame frame = new JFrame();
        //Set Content to the JFrame
        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
        frame.pack();
        frame.setVisible(true);}}
        System.out.println("Image Loaded");
    }
}