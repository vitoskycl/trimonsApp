package cl.trimons.crm.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class FormatUtil {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public static String formatSimpleDate(Date fecha) {
		if (fecha!=null)
			return simpleDateFormat.format(fecha);
		else
			return "";
	}
	
	public static String formatBoolean(Boolean bol) {
		return (bol?"Si":"No");
	}
}
