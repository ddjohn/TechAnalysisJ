package se.avelon.edge.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtil {
	private static final DajoLogger log = DajoLogger.getLogger(MyUtil.class);
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//static SimpleDateFormat dateFormat = new SimpleDateFormat(MyConfiguration.getInstance().getValue("format.date"));
	static SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//static SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat(MyConfiguration.getInstance().getValue("format.dateAndTime"));
	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	static DecimalFormat df = new DecimalFormat();
	{
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		df.setDecimalFormatSymbols(symbols);
	}
	
	public static CharSequence getURLContent(URL url) throws IOException {
		log.info("url=" + url);
		URLConnection conn = url.openConnection();
		
		conn.setConnectTimeout(2000);
	    conn.setReadTimeout(2000);
	    
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
	    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
		String encoding = conn.getContentEncoding();
		if (encoding == null) {
			encoding = "ISO-8859-1";
		}
			
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		StringBuilder sb = new StringBuilder(16384);
		try {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}
		} 
		finally {
			br.close();
		}
		return sb;
	}

	public static String getTodaysDate() {
		Calendar calendar = Calendar.getInstance();
		String dateString = dateFormat.format(calendar.getTime());		
		return dateString;
	}

	public static String getOldDate(int type, int val) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(type, -val);
		//calendar.add(Calendar.YEAR, -1); // Extra to get mean200
		return dateFormat.format(calendar.getTime());
	}

	public static Number parseN(String number) throws ParseException {
		//double d = df.parse(number).doubleValue();

		//System.out.println("==parseN: " + number + ":" + d);
		return df.parse(number);
	}
	
	public static Number parseN(String number, Number def) {
		try {
			//double d = df.parse(number).doubleValue();
			//System.out.println("--parseN: " + number + ":" + d);
			return df.parse(number);
		} 
		catch (ParseException e) {
			return def;
		}
	}
	
	public static String getTodaysDateAndTime() {
		Calendar calendar = Calendar.getInstance();
		String dateString = dateAndTimeFormat.format(calendar.getTime());		
		return dateString;
	}
}
