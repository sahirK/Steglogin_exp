/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sa2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
//import java.awt.Image;
//import java.io.;
/**
 *
 * @author user
 */
public class imagehandle {


    public BufferedImage user_space(BufferedImage image)
    {
        BufferedImage newimg= new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_3BYTE_BGR);

   Graphics2D graphics=newimg.createGraphics();
   graphics.drawRenderedImage(image,null);
   graphics.dispose();
   return newimg;

    }


    public boolean setimage(BufferedImage image,File file,String ext)
    {
        try
        {
            file.delete();
            ImageIO.write(image,ext,file);
            return true;
        }
        catch(Exception e)
        { return false;
        }

    }

public BufferedImage getimage(String f)
{
    BufferedImage image=null;
    File file=new File(f);
    try
    {
        image=ImageIO.read(file);


 }
    catch(Exception e)
    {
System.out.println("error in gettinimage "+e);
    }
return image;
}
public String imagepath(String path,String name,String ext)
{
    return path+"/"+name+"."+ext;
}

}




