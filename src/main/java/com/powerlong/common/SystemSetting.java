package com.powerlong.common;

import java.io.InputStream;
import java.util.Properties;

public class SystemSetting {
	
	
	private static SystemSetting setting = null;

	public SystemSetting() {

		Properties props = new Properties();
		InputStream configStream = null;
		try {
			configStream = this.getClass().getClassLoader()
					.getResourceAsStream("config.properties");
			if (configStream == null) {
				System.out.println("找不到配置文件:" + "config.properties");
			}
			props.load(configStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (configStream != null) {
				try {
					configStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		this.key = props.getProperty("key");
		this.imageUrl = props.getProperty("imageUrl");
		this.receiveUrl = props.getProperty("receiveUrl");
	    this.monitorUrl = props.getProperty("monitorUrl");

	}

	public static synchronized SystemSetting getInstance() {
		if (setting == null) {
			setting = new SystemSetting();
		}
		return setting;

	}

	
	//签名密钥
	private String key;
	
	private String imageUrl;

	private String socketUrl;
	
	private String receiveUrl;
	
	private String monitorUrl;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSocketUrl() {
		return socketUrl;
	}

	public void setSocketUrl(String socketUrl) {
		this.socketUrl = socketUrl;
	}

	public String getReceiveUrl() {
		return receiveUrl;
	}

	public void setReceiveUrl(String receiveUrl) {
		this.receiveUrl = receiveUrl;
	}

	public String getMonitorUrl() {
		return monitorUrl;
	}

	public void setMonitorUrl(String monitorUrl) {
		this.monitorUrl = monitorUrl;
	}
}
