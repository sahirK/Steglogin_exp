/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sa2;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author user
 */
public class shadigest
{




public static String getDigestedPassword (String password)
{
         try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            String saltedPassword = "let's-add-some-salt-to-go-with-it-and-make-it-more-secure-"+password;
             byte[] digest = md5.digest(saltedPassword.getBytes("UTF-8"));
             return new String(Base64.encode(digest));
         } catch (NoSuchAlgorithmException nsaex) {
             System.err.println("Could not create MessageDigest for SHA-256 ???");
         } catch (UnsupportedEncodingException ueex) {
            System.err.println("Unsupported encoding US-ASCII ???");
         }
         return null;
     }
}






