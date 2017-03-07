package QuanBo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * 从网页下载文档
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 downLoad();
    }
    public static void downLoad() {
		try {
			URL url=new URL("http://www.madore.org/~david/math/padics.pdf");
			URLConnection conn=url.openConnection();
			conn.setConnectTimeout(5*1000);
			conn.connect();
			int fileLength=conn.getContentLength();
			System.out.println("文件大小"+(fileLength/1024)+"kb");
			System.out.println("开始下载");
			InputStream is=conn.getInputStream();
	        BufferedInputStream bis=new BufferedInputStream(is,10000);
			FileOutputStream fos=new FileOutputStream("new_padics.pdf");
			BufferedOutputStream bos=new BufferedOutputStream(fos,10000);
		   byte[] input=new byte[1000];
		    int a;
			while ((a=bis.read(input))!=-1) {
				bos.write(input,0,a);
				bos.flush();
			}
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			is.close();
			
			System.out.println("文件下载完成");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
