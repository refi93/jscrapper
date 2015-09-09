/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jscrapper;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 *
 * @author raf
 */
public class Jscrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        // TODO code application logic here
        for(int i=0;i<11;i++){
            Integer x=i;
            PageReader.read(Variables.Link+x.toString());
        }
        BrowseSubPages.browse();
    }
}
