package com.hechuangjun.mqtt.utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


@Component
public class ProcesstUtils {
	private static int isrestart = 0;//判断是不是重启
	
	
	public static int getIsrestart() {
		return isrestart;
	}
	public static void setIsrestart(int isrestart) {
		ProcesstUtils.isrestart = isrestart;
	}
	private static Logger logger = LoggerFactory.getLogger(ProcesstUtils.class);
	/**
     * @desc 启动进程
     * @author zp
     * @date 2018-3-29
     */
    public static void startProc(String processName) { 
    	ClassPathResource classPathResource = new ClassPathResource(processName);
    	
    	logger.info("启动应用程序：" + processName);  
         if (StringUtils.isNotBlank(processName)) {  
             try {  
            	 File file = classPathResource.getFile();
                 Desktop.getDesktop().open(file);  
             } catch (Exception e) {  
                 e.printStackTrace();  
                 logger.error("应用程序：" + processName + "不存在！");  
             }  
         }   
    }
    /**
     * @desc 杀死进程
     * @author zp
     * @throws IOException 
     * @date 2018-3-29
     */
    public static void killProc(String processName) throws IOException {  
    	logger.info("关闭应用程序：" + processName);  
        if (StringUtils.isNotBlank(processName)) {  
            executeCmd("taskkill /F /IM " + processName);  
        } 
    }
    /**
     * @desc 执行cmd命令 
     * @author zp
     * @throws  
     * @date 2018-3-29
     */
    public static String executeCmd(String command) throws IOException {  
    	logger.info("Execute command : " + command);  
        Runtime runtime = Runtime.getRuntime();  
        Process process = runtime.exec("cmd /c " + command);  
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));  
        String line = null;  
        StringBuilder build = new StringBuilder();  
        while ((line = br.readLine()) != null) {  
        	logger.info(line);  
            build.append(line);  
        }  
        try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return build.toString();  
    }  
    /**
     * @desc 判断进程是否开启
     * @author zp
     * @date 2018-3-29
     */
    public static boolean findProcess(String processName) {
        BufferedReader bufferedReader = null;
        try {
            Process proc = Runtime.getRuntime().exec("tasklist -fi " + '"' + "imagename eq " + processName +'"');
            bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception ex) {}
            }
        }
    }
}
