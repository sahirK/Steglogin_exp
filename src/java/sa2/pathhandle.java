/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sa2;

/**
 *
 * @author user
 */
public class pathhandle

{

        
    
    
    
    
    
    public static String slashcon(String path)
{
    String s=path;
    char[] ns;
    ns=s.toCharArray();
    int len=ns.length;
    for(int i=0;i<len;i++)
    {

       int cc=(int)(ns[i]);
       if(cc==92)
       {
           ns[i]='/';

       }


    }
    String f=new String(ns);

    return f;









}





}
