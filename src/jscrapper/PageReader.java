/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jscrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author raf
 */
public class PageReader {
    
    
    
    public static void read(String Link) throws MalformedURLException, IOException, InterruptedException {
        URL oracle=new URL(Link);

        //System.out.println("</html>");
        
        try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()))) {
            String inputLine;
            while (true) {
                //System.out.println(inputLine); 
                inputLine = in.readLine();
                //System.out.println(inputLine);
                if (Functions.isLink(inputLine)){
                    String pom="http://"+Functions.extractLink(inputLine);
                    
                    Variables.pagesToView.add(pom.replaceAll("&amp;", "&"));
                    //System.out.println(Functions.extractLink(inputLine));
                }
                
                if (Functions.porovnaj("</html>",inputLine)) {
                    Thread.sleep(10000);
                    break;
                }
            }
        }
    }
}
