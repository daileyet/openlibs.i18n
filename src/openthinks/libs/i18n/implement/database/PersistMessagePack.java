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
 * @Title: PersistMessagePack.java 
 * @Package i18n.implement.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.database;

import java.io.Serializable;
import java.util.Locale;

import openthinks.libs.i18n.AbstractMessagePack;
import openthinks.libs.i18n.IMessage;
import openthinks.libs.i18n.implement.database.query.QueryEngine;

/**
 * @author dailey
 *
 */
public final class PersistMessagePack extends AbstractMessagePack {

	private Class<? extends IMessage> persistMessageClassType = PersistMessage.class;

	/**
	 * 
	 */
	public PersistMessagePack() {
		super();
	}

	/**
	 * @param packName
	 */
	public PersistMessagePack(String packName) {
		super(packName);
		tryTranslateMessageClass();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void tryTranslateMessageClass() {

		try {
			persistMessageClassType = (Class<? extends IMessage>) Class.forName(packName);
		} catch (ClassNotFoundException e) {
			persistMessageClassType = PersistMessage.class;
		}

	}

	/**
	 * @param persistMessageClassType
	 */
	public PersistMessagePack(Class<? extends IMessage> persistMessageClassType) {
		super();
		this.persistMessageClassType = persistMessageClassType;
	}

	/**
	 * @return the persistMessageClassType
	 */
	public Class<? extends IMessage> getPersistMessageClassType() {
		return persistMessageClassType;
	}

	/**
	 * @param persistMessageClassType the persistMessageClassType to set
	 */
	public void setPersistMessageClassType(Class<? extends IMessage> persistMessageClassType) {
		this.persistMessageClassType = persistMessageClassType;
	}

	/* (non-Javadoc)
	 * @see i18n.IMessagePack#getMessage(java.util.Locale, java.lang.String)
	 */
	@Override
	public IMessage getMessage(Locale locale, Serializable messageId) {
		if (getPersistMessageClassType() != PersistMessage.class
				|| !PersistMessage.class.equals(getPersistMessageClassType())) {
			return queryPersistMessage(locale, messageId);
		}
		String content = queryContent(messageId, locale);
		IMessage message = new PersistMessage(messageId, content, locale);
		return message;
	}

	/**
	 * get {@link IMessage} object from stored db by ORM tool.
	 * @param locale Locale
	 * @param messageId String
	 * @return {@link IMessage}
	 */
	protected IMessage queryPersistMessage(Locale locale, Serializable messageId) {
		return QueryEngine.get().query(persistMessageClassType, messageId, locale);
	}

	/**
	 * query localization message content from stored db directly
	 * @param messageId String
	 * @param locale Locale
	 * @return String
	 */
	protected String queryContent(Serializable messageId, Locale local) {
		return QueryEngine.get().query(packName, messageId, local);
	}

}
