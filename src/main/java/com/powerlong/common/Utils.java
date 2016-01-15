package com.powerlong.common;

import com.alibaba.fastjson.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by admin on 2015/8/23.
 */
public class Utils {

    /**
     * 分钟时间转换成小时分钟字符串
     * @return
     */
    public static String getTimeToString(Date timeOne,Date timeTow){
        long parkingMinute = (timeOne.getTime() - timeTow.getTime())/ 60000;
        StringBuffer sb = new StringBuffer();
        if(parkingMinute % 60 == 0) {
            return  parkingMinute/60 + "小时";
        } else {
            sb.delete(0, sb.length());
            sb.append(parkingMinute/60);
            sb.append("小时");
            sb.append(parkingMinute%60);
            sb.append("分钟");
            return sb.toString();
        }
    }
    
    
    public static String genRandomNum(int pwd_len) {
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
    

    /**
     * 分钟时间转换成小时分钟字符串
     * @return
     */
    public static String getTimeToString(long time){
        StringBuffer sb = new StringBuffer();
        if(time % 60 == 0) {
            return  time/60 + "小时";
        } else {
            sb.delete(0, sb.length());
            sb.append(time/60);
            sb.append("小时");
            sb.append(time%60);
            sb.append("分钟");
            return sb.toString();
        }
    }

    /**
     * 格式日期
     * @param date
     * @return
     */
    public static JSONObject getTimeJson(Date date) {
        JSONObject json = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        getTimeJson(Constants.JSONSTRMINUTE, calendar.get(Calendar.MINUTE), json);
        getTimeJson(Constants.JSONSTRHOUR, calendar.get(Calendar.HOUR_OF_DAY), json);
        getTimeJson(Constants.JSONSTRDAY, calendar.get(Calendar.DATE), json);
        getTimeJson(Constants.JSONSTRMONTH, calendar.get(Calendar.MONTH) + 1, json);
        getTimeJson(Constants.JSONSTRYEAR, calendar.get(Calendar.YEAR), json);
        return json;
    }

    /**
     * 处理日期
     * @param timeType
     * @param time
     * @param inputJson
     * @return
     */
    public static JSONObject getTimeJson(String timeType, int time, JSONObject inputJson) {
        if(time >= 0 && time <= 9 && (timeType.equals(Constants.JSONSTRMINUTE) || timeType.equals(Constants.JSONSTRHOUR))) {
            inputJson.put(timeType, "0" + time);
        } else {
            inputJson.put(timeType, time);
        }
        return inputJson;
    }

    public static Long getYearFirstDay() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        Date currYearFirst = calendar.getTime();
        return currYearFirst.getTime();
    }
}
