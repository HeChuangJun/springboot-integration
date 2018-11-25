package study.mqtt.utils;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckEmqThread {
	@Scheduled(fixedRate = 1000)
	public void run() {
		try {				
			boolean findProcess = ProcesstUtils.findProcess("erl.exe");
			if(ProcesstUtils.getIsrestart()==1){
				try {
					ProcesstUtils.setIsrestart(2);
					ProcesstUtils.killProc("erl.exe");
					Thread.sleep(1000);	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(!findProcess){
				try {
					System.out.println("isIsrestart"+ProcesstUtils.getIsrestart());
					if(ProcesstUtils.getIsrestart()==0){
						ProcesstUtils.setIsrestart(1);
						ProcesstUtils.executeCmd("cmd /k start C:\\emq.bat");
						Thread.sleep(1000);	
					}else{
						ProcesstUtils.executeCmd("C:\\emqttd\\bin\\emqttd start");						
						Thread.sleep(1000);	
					}												
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	

}
