
package texteditor;

import javax.swing.JFrame;

public class TextEditor {

    
    public static void main(String[] args){
        
         textEditorGui obj = new textEditorGui();
       
        obj.setBounds(0, 0, 500, 400);
        obj.setTitle("Untitled - Notepad");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
