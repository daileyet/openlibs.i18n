package openthinks.libs.utilities;

import java.util.Collections;
import java.util.List;

public class CommonUtilities {

	@SuppressWarnings("unchecked")
	public static <T> List<T> requireNotNull(List<T> list) {
		return (List<T>) (list == null ? Collections.emptyList() : list);
	}
	
	
	/**
	 * convert array to String, join with ','
	 * 
	 * @param <T> array element type
	 * @param array T[]
	 * @return String
	 */
	public static <T> String toString4Array(T[] array) {
		StringBuffer buffer = new StringBuffer();
		if (array != null) {
			for (T t : array) {
				buffer.append(String.valueOf(t));
				buffer.append(",");
			}
			if (buffer.length() > 0)
				return buffer.substring(0, buffer.length() - 1);
		}
		return buffer.toString();
	}
	
	
	public static String format(Object arg,int width,int flag){
		
		return String.format("%"+flag+width+"d", arg);
		
	}
	
	
	public static String getCurrentInvokerMethod(){
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
}
