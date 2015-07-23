/**
 * Licensed to the Apache Software Foundation (ASF) under one 
 * or more contributor license agreements. See the NOTICE file 
 * distributed with this work for additional information 
 * regarding copyright ownership. The ASF licenses this file 
 * to you under the Apache License, Version 2.0 (the 
 * "License"); you may not use this file except in compliance 
 * with the License. You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License. 
 * 
 * @Title: LocaleUtils.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dailey
 *
 */
public class LocaleUtils {

	private final static Map<String, Locale> langToLocaleMap = new ConcurrentHashMap<String, Locale>();

	static {
		Field[] fields = Locale.class.getDeclaredFields();
		for (Field field : fields) {
			int modifers = field.getModifiers();
			if (Modifier.isStatic(modifers) && Modifier.isFinal(modifers) && Modifier.isPublic(modifers)) {
				try {
					field.setAccessible(true);
					Object obj = field.get(null);
					if (obj instanceof Locale) {
						langToLocaleMap.put(obj.toString(), (Locale) obj);
					}
				} catch (Exception e) {
					//igron
				}
			}
		}
	}

	public static void register(String localeToString, Locale locale) {
		langToLocaleMap.put(localeToString, locale);
	}

	/**
	 * @param locale
	 * @return
	 */
	public static Locale langToLocale(String localeToString) {
		return langToLocaleMap.get(localeToString);
	}

}
