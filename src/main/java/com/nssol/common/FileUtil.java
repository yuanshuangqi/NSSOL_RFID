package com.nssol.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

	public static String readFile(String path)
    {
        StringBuffer sb=new StringBuffer();
        String tempstr=null;
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            File file=new File(path);
            if(file.exists()) {
            	fis = new FileInputStream(file);
                br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
                while((tempstr=br.readLine())!=null) {
                    sb.append(tempstr);
                }
            }
        } catch(IOException ex) {
        	return null;
        } finally {
        	if(fis!=null) {
        		try {
					fis.close();
				} catch (IOException e) {
					return null;
				}
        	}
        	if(br!=null) {
        		try {
        			br.close();
				} catch (IOException e) {
					return null;
				}
        	}
        }
        return sb.toString();
    }
}
