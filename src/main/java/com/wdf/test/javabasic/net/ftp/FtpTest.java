package com.wdf.test.javabasic.net.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
/**
 * 
 * @Package: com.wdf.test.javabasic.net.ftp
 * @ClassName: FtpTest
 * @Description: 
 * @author: WDF
 * @date: 2020年7月22日 上午10:13:37
 * @version: V1.0
 */

/**
 * Ftp访问 <br/>
 * Created by claireliu on 2017/5/23.
 */
public class FtpTest {


 
	private static Logger log = Logger.getLogger(FtpTest.class);
 
	static FTPClient ftp;
	
	public static void main(String[] args) {
		FtpTest.downFileSimpleFile("/", "20880210219128550156_20200721.csv.zip", "D:\\urp\\reconfile");
	}
 
	public static boolean getConnect() {
		boolean result = false;
		try {
			int port = 21;
			String address = "172.16.1.206";
			String userName = "urp_recon";
			String userPassword = "dwurp_recon";
			ftp = new FTPClient();
			ftp.connect(address, port);
			ftp.login(userName, userPassword);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlEncoding("GBK");
			// 调用FTPClient.enterLocalPassiveMode();这个方法的意思就是每次数据连接之前，ftp
			// client告诉ftp server开通一个端口来传输数据。为什么要这样做呢，因为ftp
			// server可能每次开启不同的端口来传输数据，但是在linux上，由于安全限制，可能某些端口没有开启，所以就出现阻塞（会出现下载不了的情况或者listfiles为空。）。
			ftp.enterLocalPassiveMode();
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return result;
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("op<getConnect> getConnect fail", e);
		}
		return result;
	}
 
	 
	/**
	 * 下载
	 * @param remotePath ftp服务器上的路径
	 * @param fileName 文件名
	 * @param localPath 本地的存储路径。
	 * @return 成功与否
	 */
	public static boolean downFileSimpleFile(String remotePath, String fileName, String localPath) {
		boolean success = false;
		OutputStream is = null;
		try {
			getConnect();
			String remoteFileName =  remotePath + File.separator + fileName;
			File localFile = new File(localPath + File.separator + fileName);
			is = new FileOutputStream(localFile);
 
			ftp.setBufferSize(1024);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			ftp.retrieveFile(remoteFileName, is);
 
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(is);
		}
		return success;
	}
 
	private static void close(OutputStream is) {
		try {
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
		if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
		if (ftp.isConnected()) {
            try {
                ftp.disconnect();
            } catch (IOException ioe) {
            }
        }
	}
 
 
 
}
