package com.jj.pojo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.jj.pojo.command.charge.TrafficCommand;
import com.jj.pojo.dto.traffic.TrafficDTO;
import com.jj.pojo.dto.util.FindUserIntegralDTO;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class Helper {

	private static final String URL_PARAM_CONNECT_FLAG = "&";

	/**
	 *
	 * @方法功能说明：根据用户id获取用户的斗币数量
	 * @修改者名字：yuqz
	 * @修改时间：2016年6月23日下午4:18:58
	 * @修改内容：
	 * @参数：@param userId
	 * @参数：@return
	 * @return:Integer
	 * @throws
	 */
	public static int getDoubiByUserId(String userId){
		//根据用户ID查询用户积分
		String sr=HttpRequest.sendPost("http://portal.lof.gamewalker.cn/user/findUserIntegral.action", "userId="+Integer.parseInt(userId));
		JSONObject jsonObj = JSON.parseObject(sr);
		System.out.println("查询用户积分返回:"+sr);
		if(jsonObj.get("statusCode").equals("200")){
			try{
				return  (int) jsonObj.get("integral");
			}catch (Exception e){
				e.printStackTrace();
				return 0;
			}
		}else{
			return 0;
		}
	}

	/**
	 * 根据用户ID查询用户积分列表
	 * @param userId
	 * @return
     */
	public static FindUserIntegralDTO findUserIntegralList(String userId) {
        String sr=HttpRequest.sendPost("http://portal.lof.gamewalker.cn/user/findUserIntegralList.action", "userId="+Integer.parseInt(userId));
//		System.out.println(sr);
		FindUserIntegralDTO findUserIntegralDTO = JSON.parseObject(sr, FindUserIntegralDTO.class);
		return findUserIntegralDTO;
	}

	/**
	 * 话费充值
	 * @param trafficCommand
	 * @return
     */
	public static TrafficDTO traffic(TrafficCommand trafficCommand){
		TrafficDTO trafficDTO = new TrafficDTO();
		if(trafficCommand == null || trafficCommand.getPhone() == null || trafficCommand.getGold() == null){
			trafficDTO.setStatusCode("300");
			trafficDTO.setMessage("参数有误");
			return trafficDTO;
		}
		String param = "";
		long time = System.currentTimeMillis();
		String sign = getTrafficSign(trafficCommand, time);
		param = param + "phone=" + trafficCommand.getPhone() + "&gold=" + trafficCommand.getGold() + "&time=" + time
				+ "&sign=" + sign + "&clientId=2&userId=" + trafficCommand.getUserId() + "&fromClient=gedou";
		System.out.println("param="+param);
		String sr=HttpRequest.sendPost("http://pay.gamewalker.cn/public/traffic.action", param);
		JSONObject jsonObject = JSON.parseObject(sr);
		trafficDTO.setMessage((String) jsonObject.get("message"));
		trafficDTO.setStatusCode((String) jsonObject.get("statusCode"));
		return trafficDTO;
	}

	/**
	 * 计算话费充值的签名
	 * MD5(手机号+金额+时间戳+私钥)
	 * 私钥=fcba2f0146b34690a862f50360808bc1
	 * @return
     */
	public static String getTrafficSign(TrafficCommand trafficCommand, Long time) {
		String phone = trafficCommand.getPhone();
		String gold = String.valueOf(trafficCommand.getGold());
		String key = "fcba2f0146b34690a862f50360808bc1";
		return MD5.GetMD5Code(phone + gold + time + key);
	}

	/**
	 * 判断字符串只能由数字 字母组成
	 * @param value
	 * @return
	 */
	public static boolean checkedValue(String value){
		if(value == null){
			return true;
		}
		return !value.matches("^[A-Za-z0-9]+$");
	}


	/**
	 * 把一个日期转换为(pattern)格式 的字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String DTS(Date date,String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}


	public static long getDateTime(int year,int month ,int day,int hour,int minute,int second){
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			rightNow.setTime(simpleDate.parse(year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rightNow.getTime().getTime();
	}

	public static Date STD(String timeStr,String pattern){
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
		try {
			rightNow.setTime(simpleDate.parse(timeStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rightNow.getTime();
	}

	public static Calendar getDateCalendar(Date date){
		Calendar rightNow = Calendar.getInstance();
		try {
			rightNow.setTime(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//rightNow.get(Calendar.YEAR);
		//rightNow.get(Calendar.MONTH);
		//rightNow.get(Calendar.DAY_OF_MONTH);
		return rightNow;
	}

	/**
	 * 获取某个月的最大天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthMaxDay(int year,int month){
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
		try {
			rightNow.setTime(simpleDate.parse(year+"/"+month));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取某一天是星期几
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getDayOfWeek(int year,int month,int day){
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		try {
			rightNow.setTime(simpleDate.parse(year+"/"+month+"/"+day));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int w = rightNow.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
	}

	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getRightNowYear(){
		Calendar rightNow = Calendar.getInstance();
		try {
			rightNow.setTime(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rightNow.get(Calendar.YEAR);
	}

    public static int random(int min, int max){
        return (int) ((max + 1 - min) * Math.random() + min);
    }

    public static double random(double min, double max){
        return (max + 1 - min) * Math.random() + min;
    }

    /**
     * 获取客户端IP地址
     * @param request
     * @return
     */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getRemoteAddr();
        }
        return ip;
	 }

	  public static List URLPost(String strUrl, Map map) throws IOException {
		    String content = "";
		    content = getUrl(map);
		    String totalURL = null;

		    if(content == null || "".equals(content.trim())){
		    	totalURL = strUrl;
		    }else{
			    if(strUrl.indexOf("?") == -1) {
			      totalURL = strUrl + "?" + content;
			    } else {
			      totalURL = strUrl + "&" + content;
			    }
		    }
		    URL url = new URL(totalURL);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setDoInput(true);
		    con.setDoOutput(true);
		    con.setAllowUserInteraction(false);
		    con.setUseCaches(false);
		    con.setRequestMethod("POST");
		    con.setConnectTimeout(5000);
		    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		    List result = new ArrayList();
		    if(con.getResponseCode() == 200){
			    BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			    while (true) {
			      String line = bin.readLine();
			      if (line == null) {
			        break;
			      }
			      else {
			    	  result.add(line);
			      }
			    }
		    }

		    if (con != null) {
		    	con.disconnect();// 关闭连接
		    }

		    return (result);
	  }


	  public static List URLPost(String strUrl, Map map, String cookies) throws IOException {
		    String content = "";
		    content = getUrl(map);
		    String totalURL = null;

		    if(content == null || "".equals(content.trim())){
		    	totalURL = strUrl;
		    }else{
			    if(strUrl.indexOf("?") == -1) {
			      totalURL = strUrl + "?" + content;
			    } else {
			      totalURL = strUrl + "&" + content;
			    }
		    }
		    URL url = new URL(totalURL);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setDoInput(true);
		    con.setDoOutput(true);
		    con.setAllowUserInteraction(false);
		    con.setUseCaches(false);
		    con.setRequestMethod("POST");
		    con.setConnectTimeout(5000);
		    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		    con.setRequestProperty("Cookie", cookies);

		    List result = new ArrayList();
		    if(con.getResponseCode() == 200){
			    BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			    while (true) {
			      String line = bin.readLine();
			      if (line == null) {
			        break;
			      }
			      else {
			    	  result.add(line);
			      }
			    }
		    }

		    if (con != null) {
		    	con.disconnect();// 关闭连接
		    }

		    return (result);
	  }


	  public static List URLGet(String strUrl, Map map) throws Exception {
		    String content = "";
		    content = getUrl(map);
		    String totalURL = null;

		    if(content == null || "".equals(content.trim())){
		    	totalURL = strUrl;
		    }else{
			    if(strUrl.indexOf("?") == -1) {
			      totalURL = strUrl + "?" + content;
			    } else {
			      totalURL = strUrl + "&" + content;
			    }
		    }
		    URL url = new URL(totalURL);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setDoInput(true);
		    con.setDoOutput(true);
		    con.setAllowUserInteraction(false);
		    con.setUseCaches(false);
		    con.setRequestMethod("GET");
		    con.setConnectTimeout(5000);
		    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		    List result = new ArrayList();
		    if(con.getResponseCode() == 200){
			    BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			    while (true) {
			      String line = bin.readLine();
			      if (line == null) {
			        break;
			      }
			      else {
			    	  result.add(line);
			      }
			    }
		    }

		    if (con != null) {
		    	con.disconnect();// 关闭连接
		    }

		    return (result);
	  }

	  private static String getUrl(Map<String, String> map) {
		    if (null == map || map.keySet().size() == 0) {
		      return ("");
		    }
		    StringBuffer url = new StringBuffer();
		    Set keys = map.keySet();
		    for (Iterator i = keys.iterator(); i.hasNext(); ) {
		      String key = String.valueOf(i.next());
		      if (map.containsKey(key)) {
		    	 Object val = map.get(key);
		    	 String str = val!=null?val.toString():"";
//		    	try {
//					str = URLEncoder.encode(str, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
		        url.append(key).append("=").append(str).
		            append(URL_PARAM_CONNECT_FLAG);
		      }
		    }
		    String strURL = "";
		    strURL = url.toString();
		    if (URL_PARAM_CONNECT_FLAG.equals("" + strURL.charAt(strURL.length() - 1))) {
		      strURL = strURL.substring(0, strURL.length() - 1);
		    }
		    return (strURL);
	}

	  public static String getWebRoot() throws RuntimeException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF") - 1);
		} else {
			throw new RuntimeException("路径获取错误");
		}
		return path;
	  }

	  private static String getWebClassesPath() {
			String path = Helper.class.getProtectionDomain().getCodeSource()
					.getLocation().getPath();
			return path;
	  }


	    /**
	     * 获取配置文件内容
	     * @param propertiesName
	     * @param key
	     * @return
	     */
	    public static String getPropertiesValue(String propertiesName,String key){
	    	ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
	    	String str = rb.getString(key);
	    	rb = null;
	    	try {
				return new String(str.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "";
	    }

	    /**
	     * 本周开始时间
	     * @return
	     */
	    public static Date getNowWeekStartTime(){
	    	Calendar currentDate = new GregorianCalendar();
	    	currentDate.setFirstDayOfWeek(Calendar.MONDAY);
	    	currentDate.set(Calendar.HOUR_OF_DAY, 0);
	    	currentDate.set(Calendar.MINUTE, 0);
	    	currentDate.set(Calendar.SECOND, 0);
	    	currentDate.set(Calendar.MILLISECOND, 0);
	    	currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    	return (Date)currentDate.getTime().clone();
	    }

	    /**
	     * 本周结束时间
	     * @return
	     */
	    public static Date getNowWeekEndTime(){
	    	Calendar currentDate = new GregorianCalendar();
	    	currentDate.setFirstDayOfWeek(Calendar.MONDAY);
	    	currentDate.set(Calendar.HOUR_OF_DAY, 23);
	    	currentDate.set(Calendar.MINUTE, 59);
	    	currentDate.set(Calendar.SECOND, 59);
	    	currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	    	return (Date)currentDate.getTime().clone();
	    }

	    public static String base64Encoder(String str){
	    	return new String(new BASE64Encoder().encode(str.getBytes()));
	    }

	    public static String base64Decoder(String str) throws IOException{
	    	return new String(new BASE64Decoder().decodeBuffer(str));
	    }

	    /**
		 * http请求
		 * @param url
		 * @param data
		 * @return
		 * @throws IOException
		 */
		public static String requestSSLUrl(String url, Map<String, String> data)
				throws IOException {

			HttpsURLConnection conn;
			try {

				SSLContext sc = SSLContext.getInstance("SSL");
		        sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());

				URL requestUrl = new URL(url);
				conn = (HttpsURLConnection) requestUrl.openConnection();

				conn.setSSLSocketFactory(sc.getSocketFactory());
		        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());

			} catch (Exception e) {
				return e.getMessage();
			}

			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");

			conn.setDoInput(true);
			conn.setDoOutput(true);

			PrintWriter writer = new PrintWriter(conn.getOutputStream());
			writer.print(httpBuildQuery(data));
			writer.flush();
			writer.close();

			String line;
			BufferedReader bufferedReader;
			StringBuilder sb = new StringBuilder();
			InputStreamReader streamReader = null;
			try {
				streamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
			} catch (IOException e) {
				streamReader = new InputStreamReader(conn.getErrorStream(), "UTF-8");
			} finally {
				if (streamReader != null) {
					bufferedReader = new BufferedReader(streamReader);
					sb = new StringBuilder();
					while ((line = bufferedReader.readLine()) != null) {
						sb.append(line);
					}
				}
			}
			return sb.toString();
		}
		/**
		 * 参数编码
		 * @param data
		 * @return
		 */
		public static String httpBuildQuery(Map<String, String> data) {
			String ret = "";
			String k, v;
			Iterator<String> iterator = data.keySet().iterator();
			while (iterator.hasNext()) {
				k = iterator.next();
				v = data.get(k);
				try {
					ret += URLEncoder.encode(k, "utf8") + "=" + URLEncoder.encode(v, "utf8");
				} catch (UnsupportedEncodingException e) {
				}
				ret += "&";
			}
			return ret.substring(0, ret.length() - 1);
		}


		/**
		 * MAP排序
		 * @param oldMap
		 * @return
		 */
		public static Map<String, Integer> sortMap(Map<String, Integer> oldMap) {
	        ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(oldMap.entrySet());
	        Collections.sort(list, new Comparator<Entry<String, Integer>>() {

	            public int compare(Entry<String, Integer> arg0,  Entry<String, Integer> arg1) {
	                return arg1.getValue() - arg0.getValue();
	            }

	        });
	        Map<String, Integer> newMap = new LinkedHashMap<String, Integer>();
	        for (int i = 0; i < list.size(); i++) {
	            newMap.put(list.get(i).getKey(), list.get(i).getValue());
	        }
	        return newMap;
	    }

}
