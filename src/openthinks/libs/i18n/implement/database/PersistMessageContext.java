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
 * @Title: PersistMessageContext.java 
 * @Package i18n.implement.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.database;

import openthinks.libs.i18n.AbstractMessageContext;
import openthinks.libs.i18n.IMessage;
import openthinks.libs.i18n.IMessagePack;
import openthinks.libs.i18n.IMessageType;
import openthinks.libs.i18n.MessagePackManager;
import openthinks.libs.i18n.implement.database.query.QueryEngine;
import openthinks.libs.utilities.Checker;

/**
 * @author dailey
 * 
 */
public class PersistMessageContext extends AbstractMessageContext {

	/**
	 * 
	 */
	public PersistMessageContext() {
		super();
	}

	public PersistMessageContext(final QueryEngine queryEngine) {
		super();
		QueryEngine.registerQueryEngine(queryEngine);
	}

	/**
	 * @param messagePackManager
	 */
	public PersistMessageContext(MessagePackManager messagePackManager) {
		super(messagePackManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see i18n.IMessageContext#getMessagePack(i18n.IMessageType)
	 */
	@Override
	public IMessagePack getMessagePack(IMessageType messageType) {
		Checker.require(messageType).isExtendsFrom(IPersistMessageType.class);
		IPersistMessageType persistMessageType = (IPersistMessageType) messageType;
		Class<? extends IMessage> entityClass = persistMessageType.getMessageEntityClass();
		String persistName = persistMessageType.getPersistName();
		PersistMessagePack messagePack = new PersistMessagePack();
		messagePack.setPackName(persistName);
		messagePack.setPersistMessageClassType(entityClass);
		return messagePack;

	}

	@Override
	public MessagePackManager getPackManager() {
		if (messagePackManager == null) {
			messagePackManager = new PersistMessagePackManager();
		}
		return messagePackManager;
	}

}
