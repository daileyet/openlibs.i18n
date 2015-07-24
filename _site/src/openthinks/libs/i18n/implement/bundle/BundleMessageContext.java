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
 * @Title: BundleMessageContext.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey_dai 
 * @date Apr 16, 2012
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.bundle;

import openthinks.libs.i18n.AbstractMessageContext;
import openthinks.libs.i18n.IMessagePack;
import openthinks.libs.i18n.IMessageType;
import openthinks.libs.i18n.MessagePackManager;
import openthinks.libs.utilities.Checker;

/**
 * @author dailey_dai
 *
 */
public class BundleMessageContext extends AbstractMessageContext {
	/**
	 * 
	 */
	public BundleMessageContext() {
	}

	public BundleMessageContext(MessagePackManager messagePackManager) {
		this.messagePackManager = messagePackManager;
	}

	@Override
	public IMessagePack getMessagePack(IMessageType messageType) {
		Checker.require(messageType).isExtendsFrom(IBundleMessageType.class);
		String packName = getPackName((IBundleMessageType) messageType);
		Checker.require(packName).notNull();
		return getPackManager().createMessagePack(packName);
	}

	/**
	 * @param messageType IMessageType
	 * @return String
	 */
	String getPackName(IBundleMessageType messageType) {
		return messageType.getPackName();
	}

	@Override
	public MessagePackManager getPackManager() {
		if (messagePackManager == null) {
			messagePackManager = new BundleMessagePackManager();
		}
		return messagePackManager;
	}

}
