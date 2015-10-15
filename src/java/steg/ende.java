package steg;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import sa2.pathhandle;
import sa2.imagehandle;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import sa2.shadigest;
public class ende

{

    private static String IMAGE_TYPE = "jpg";

    private static String extraStr = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";

    String text,dtext,path;

   public void setPath(String _path)
   {
       path=_path;
   }
   public void setText(String _text)
   {
      text=_text;
  }
  public void setDtext(String _dtext)
  {
    dtext=_dtext;
}
  public String getText()
  {
      return text;
  }
  public String getDtext()
  {
      return dtext;
  }
    public String getPath()
    {
        return path;
    }

    public static void hideTextDataInsideImage(String dataContents,String uname )
	{
 String extraSt = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";

            try
		{
imagehandle s=new imagehandle();
String filename=s.imagepath("C:/Users/sahir/Documents/id","css","jpg");
BufferedImage imageo=s.getimage(filename);
BufferedImage image=s.user_space(imageo);
s.setimage(image,new File(s.imagepath("C:/Users/sahir/Documents/id",uname,"jpg")),"jpg");
                String srcImagePath=s.imagepath("C:/Users/sahir/Documents/id",uname,"jpg" );

dataContents=shadigest.getDigestedPassword(dataContents);

//			dataContents = new sun.misc.BASE64Encoder().encode(dataContents.getBytes());
			extraSt = new sun.misc.BASE64Encoder().encode(extraSt.getBytes());
			FileOutputStream fos = new FileOutputStream( srcImagePath , true );
			//fos.write(extraSt.getBytes());
                       fos.write(new sun.misc.BASE64Decoder().decodeBuffer(extraSt.toString()));
			fos.write( dataContents.getBytes() );
			fos.close();
		}
		catch( FileNotFoundException fnfe )
		{
			fnfe.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

    public static String getHiddenDataFromImage(String imagePath )
	{
		String dataContents = null,finalData=null;

               // int i=0;
                //int len=imagePath.length;
                try
		{
                  

//   String nss=pathhandle.slashcon(imagePath);









			File file = new File(imagePath);
			byte[] fileData = new byte[ (int)file.length()];
			InputStream inStream = new FileInputStream( file );
			inStream.read(fileData);
			inStream.close();
			String tempFileData = new String(fileData);
			 finalData = tempFileData.substring(tempFileData
					.indexOf(extraStr)
					+ extraStr.length(), tempFileData.length());
			//byte[] temp = new sun.misc.BASE64Decoder().decodeBuffer(finalData);
			//dataContents = new String(temp);
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return finalData;
	}


}
