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
 * @Title: I18nApplicationLocale.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey_dai 
 * @date 2012-2-27
 * @version V1.0 
 */
package com.openthinks.libs.i18n;

import java.util.Locale;
import java.util.Observable;

/**
 * A holder for application can dynamic change its locale, and immediately change application locale language.
 * 
 * For application use, for example a UI:<BR>
 * <blockquote>
 * <pre>
 * 	class UI extends JFrame implements Observer{
 * 		private JButton button;
 * 		private JLabel label;
 * 		
 * 		public UI(){
 * 			//initialize component
 * 			//register to I18nApplicationLocale
 * 			I18nApplicationLocale.getInstance().addObserver(this);
 * 		}
 * 		
 * 		// Overrides Observer
 *		public void update(Observable o, Object argument) {
 *			setLocaleMessage();
 * 		}
 * 		
 * 		public void setLocaleMessage(){
 * 			button.setText(I18n.getMessage(DefaultBundleMessageType.UI,"2000"));
 * 			label.setText(I18n.getMessage(DefaultBundleMessageType.UI,"2001"));
 * 		}
 * 	}
 * 
 * </pre>
 * </blockquote>
 * 
 * For change application locale, <code>I18nApplicationLocale.getInstance().changeLocale(locale)</code>
 * @author dailey_dai
 */
public class I18nApplicationLocale extends Observable {
	private Locale currentLocale = Locale.getDefault();

	private static class I18nApplicationLocaleContainer {
		private static I18nApplicationLocale instance = new I18nApplicationLocale();
	}

	/**
	 * get a singleton instance
	 * @return I18nApplicationLocale
	 */
	public static I18nApplicationLocale getInstance() {
		return I18nApplicationLocaleContainer.instance;
	}

	protected I18nApplicationLocale() {
	}

	/**
	 * get application current locale
	 * @return Locale
	 */
	public Locale getCurrentLocale() {
		return (Locale) currentLocale.clone();
	}

	/**
	 * change a new locale, if it change successfully, it will notify all registered observer.
	 * @param locale Locale new locale wanted to change
	 */
	public void changeCurrentLocale(Locale locale) {
		if (locale != null && !currentLocale.equals(locale)) {
			this.currentLocale = locale;
			super.setChanged();
		}
		super.notifyObservers(this.currentLocale);
	}

}
