import java.io.*;
import java.awt.* ;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class MyBrowser extends JFrame implements Runnable {
    String theURL;
    int URL_type;

    public MyBrowser(int i,String thisURL){
        this.getContentPane().setBackground( Color.white);
        URL_type=i;
        theURL=thisURL;
    }

    public void run() {
        setBackground(Color.yellow);
        setTitle("A Browser Window");
        setSize(1000,1000);
        setLayout(new BorderLayout()); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(buildHtmlPane(),BorderLayout.CENTER);
        setVisible(true);
        pack();
        
    }
///////////////////////////////////////////////////////

    public  JPanel buildHtmlPane () {
        String combined;
        java.net.URL helpURL=null;
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);   
        if (URL_type==1) {
        System.out.println("something");
        }else {
            try {
                helpURL=new  java.net.URL(theURL);
            } catch (java.net.MalformedURLException e) {
            }
            // System.out.println(helpURL);      
        }

        if (helpURL != null) {
            try {
                editorPane.setPage(helpURL);
            } catch (IOException e) {
                System.err.println("URL not valid: " + helpURL);
            }
        } else {
            System.err.println("URL is null. ");
        }
       if (URL_type==1) {
        editorPane.setPreferredSize(new Dimension(800, 800));
       }else{
        editorPane.setPreferredSize(new Dimension(1000, 1000));
       }
       editorPane.setVisible(true);
       JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //SETTING SCHEME FOR HORIZONTAL BAR
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.setVisible(true);
        leftPane.add(scrollPane);//, BorderLayout.PAGE_START);
        return leftPane;
    }

public static void main(String args[]) {
          (new Thread(new MyBrowser(2,"http://www.umsl.edu/~siegel/littleFile.html"))).start();
      }
    public int stop_thread(){
       
        return 0;
    }

}