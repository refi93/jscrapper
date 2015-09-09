/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jscrapper;

/**
 *
 * @author raf
 */
public class Contact {
    String name="";
    String address="";
    String mail="";
    String phone="";
    
    public Contact(String name,String address,String mail,String phone){
        this.name=name;
        this.mail=mail;
        this.address=address;
        this.phone=phone;
    }
    
    public Contact(){
       // do nothing 
    }
}
