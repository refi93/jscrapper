/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jscrapper;

import org.apache.commons.lang3.StringEscapeUtils;
/**
 *
 * @author raf
 */
public class Functions {
    public static boolean isLink(String str){
        if ((str.indexOf("idp=")!=-1)&&(str.indexOf("smi=")!=-1)) return true;
        return false;
    }
    
    public static String extractLink(String str){
        String ret="";
        int begin=str.indexOf("www");
        
        if (begin==-1) return "null";
        
        for(int i=begin;((i<str.length())&&(str.charAt(i)!='\"'));i++){
            ret+=str.charAt(i);
        }
        return ret;
    }
    
    static boolean porovnaj(String a, String b){
        if ((a==null)||(b==null)) return true;
        if (a.length()!=b.length()) return false;
        for(int i=0;(i<a.length())&&(i<b.length());i++){
            char c1=a.charAt(i);
            char c2=b.charAt(i);
            if (c1!=c2) return false;
        }   
        return true;   
    }

    static boolean isMail(String str) {
        if (str.indexOf("mailto:")!=-1) return true;
        return false;
    }

    static boolean isName(String str){
        if (str.indexOf("<meta property=\"og:title\" content=\"")!=-1) {
            return true;
        }
        else return false;
    }
    
    static String unescape(String str){
        StringBuilder s=new StringBuilder(str);
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
                sb.append("&#");
                sb.append((int)c);
                sb.append(';');
            } else {
                sb.append(c);
            }
        }
        return s.toString();
    }
    
    static String extractName(String str){
        String ret="";
        if (str.length()<36) return "";
        for(int i=35;((i<str.length())&&(str.charAt(i)!='\"'));i++){
            ret+=str.charAt(i);
        }
        //unescape(ret);
        ret=StringEscapeUtils.unescapeHtml4(ret);
        //System.out.println(ret);
        return ret;
    }
    
    static String extractMail(String str) {
        String ret="";
        int begin=str.indexOf("mailto:");
        
        if (begin==-1) return "null";
        
        for(int i=begin+7;((i<str.length())&&(str.charAt(i)!='\"'));i++){
            ret+=str.charAt(i);
        }
        return ret;
    }
}
