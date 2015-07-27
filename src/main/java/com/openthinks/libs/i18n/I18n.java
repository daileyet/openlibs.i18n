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
 * @Title: I18n.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey_dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package com.openthinks.libs.i18n;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.openthinks.libs.i18n.implement.bundle.BundleMessageContext;
import com.openthinks.libs.i18n.implement.bundle.IBundleMessageType;

/**
 * Help for multi-languages, use this class as entry.
 * @author dailey_dai
 *
 */
public final class I18n {

	private static IMessageContext messageContext = null;
	private static Lock lock = new ReentrantLock();

	private I18n() {
	}

	/**
	 * get message by message pack/persist name,locale,message id and arguments.
	 * it will check the {@link IMessageContext}, if user not call the method <BR>
	 * {@code I18n.configurePackContext(IMessageContext messageContext)} to set a message context;<BR>
	 * it will use the default message context {@link BundleMessageContext}
	 * @param packName String message pack/persist name
	 * @param locale Locale special locale
	 * @param messageId message key id
	 * @param args message format arguments
	 * @return String the final i18n message for the special locale
	 */
	public static String getMessage(String packName, Locale locale, String messageId, Object... args) {
		checkMessageContext();
		MessagePackManager packManager = messageContext.getPackManager();
		IMessagePack messagePack = packManager.getMessagePack(packName);
		IMessage message = messagePack.getMessage(locale, messageId);
		return messagePack.format(message, args);
	}

	/**
	 * get message by message pack/persist name,{@code Locale.getDefault()},message id and arguments.
	 * @param packName String message pack/persist name
	 * @param messageId String message key id
	 * @param args Object[] message format arguments
	 * @return String the final i18n message for the default locale
	 */
	public static String getMessage(String packName, String messageId, Object... args) {
		return getMessage(packName, I18nApplicationLocale.getInstance().getCurrentLocale(), messageId, args);
	}

	/**
	 * get message by message entity class type, locale, message id and arguments.<BR>
	 * it is best to use it as retrieve persist message from database.
	 * @param <T> subclass for IMessage
	 * @param entityClazz  Entity message class type
	 * @param locale Locale
	 * @param messageId String
	 * @param args Object[]
	 * @return String the final i18n message for the special locale
	 */
	public static <T extends IMessage> String getMessage(Class<T> entityClazz, Locale locale, String messageId,
			Object... args) {
		checkMessageContext();
		MessagePackManager packManager = messageContext.getPackManager();
		IMessagePack messagePack = packManager.getMessagePack(entityClazz.getName());
		IMessage message = messagePack.getMessage(locale, messageId);
		return messagePack.format(message, args);
	}

	public static <T extends IMessage> String getMessage(Class<T> entityClazz, String messageId, Object... args) {
		return getMessage(entityClazz, I18nApplicationLocale.getInstance().getCurrentLocale(), messageId, args);
	}

	/**
	 * get message by message type, locale,message id and arguments.
	 * @param messageType IMessageType
	 * @param locale Locale special locale
	 * @param messageId message key id
	 * @param args message format arguments
	 * @return String the final i18n message for the special locale
	 */
	public static String getMessage(IMessageType messageType, Locale locale, String messageId, Object... args) {
		checkMessageContext();
		IMessagePack messagePack = messageContext.getMessagePack(messageType);
		IMessage message = messagePack.getMessage(locale, messageId);
		return messagePack.format(message, args);
	}

	/**
	 * get message by message type,{@code Locale.getDefault()},message id and arguments.
	 * @param messageType IMessageType
	 * @param messageId message key id
	 * @param args message format arguments
	 * @return String the final i18n message for the default locale
	 */
	public static String getMessage(IMessageType messageType, String messageId, Object... args) {
		return getMessage(messageType, I18nApplicationLocale.getInstance().getCurrentLocale(), messageId, args);
	}

	public static ResourceBundle getResourceBundle(String packName, Locale locale) {
		return ResourceBundle.getBundle(packName, locale);
	}

	public static ResourceBundle getResourceBundle(String packName) {
		return ResourceBundle.getBundle(packName, I18nApplicationLocale.getInstance().getCurrentLocale());
	}

	/**
	 * get {@link ResourceBundle} instance by the instance of {@link IBundleMessageType} and the special {@link Locale}
	 * @param messageType {@link IBundleMessageType}
	 * @param locale {@link Locale}
	 * @return {@link ResourceBundle} the final i18n resource bundle for the special locale
	 */
	public static ResourceBundle getResourceBundle(IBundleMessageType messageType, Locale locale) {
		return ResourceBundle.getBundle(messageType.getPackName(), locale);
	}

	/**
	 * get {@link ResourceBundle} instance by the instance of {@link IBundleMessageType} and the default/current locale maintain by {@link I18nApplicationLocale}
	 * @param messageType {@link IBundleMessageType}
	 * @return	{@link ResourceBundle} the final i18n resource bundle for the default/current locale maintain by {@link I18nApplicationLocale}
	 */
	public static ResourceBundle getResourceBundle(IBundleMessageType messageType) {
		return ResourceBundle.getBundle(messageType.getPackName(),
				I18nApplicationLocale.getInstance().getCurrentLocale());
	}

	/**
	 * Set i18n message context.
	 * @param messageContext IMessageContext
	 */
	public static void configurePackContext(IMessageContext messageContext) {
		if (messageContext != null && !messageContext.equals(I18n.messageContext)) {
			lock.lock();
			try {
				I18n.messageContext = messageContext;
			} finally {
				lock.unlock();
			}
		}
	}

	private static IMessageContext checkMessageContext() {
		if (messageContext == null) {
			useDefaultContext();
		}
		return messageContext;
	}

	private static void useDefaultContext() {
		lock.lock();
		try {
			if (messageContext == null) {
				I18n.messageContext = new BundleMessageContext();
			}
		} finally {
			lock.unlock();
		}
	}

}
