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
public class BrowseSubPages {
    
    public static void browse() throws MalformedURLException, IOException, InterruptedException{
        for(int i=0;i<Variables.pagesToView.size();i+=2){
            read(Variables.pagesToView.get(i));
        }
    }
    
    private static void read(String Link) throws MalformedURLException, IOException, InterruptedException {
        URL oracle=new URL(Link);

        //System.out.println("</html>");
        
        try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()))) {
            String inputLine;
            Contact pom=new Contact();
            while (true) {
                //System.out.println(inputLine); 
                inputLine = in.readLine();
                //System.out.println(inputLine);
                //System.out.println(inputLine);
                if (Functions.isName(inputLine)){
                    
                }
                
                if (Functions.isMail(inputLine)){
                    Variables.mails.add("http://"+Functions.extractMail(inputLine));
                    pom.mail=Functions.extractMail(inputLine);
                    //System.out.println(pom.mail);
                }
                else if(Functions.isName(inputLine)){
                    pom.name= Functions.extractName(inputLine);
                    //System.out.println(pom.name);
                }
                
                
                if (Functions.porovnaj("</html>",inputLine)) {
                    Thread.sleep(10000);
                    break;
                }
            }
            Variables.contacts.add(pom);
            if (!pom.mail.equals("")){
                System.out.println(pom.name);
                System.out.println(pom.mail);
            }
         }
    }
}

