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
 * @Title: MessageEntity.java 
 * @Package i18n.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package com.openthinks.libs.i18n.database;

import java.util.Locale;

import com.openthinks.libs.i18n.IMessage;
import com.openthinks.libs.sql.entity.Entity;
import com.openthinks.libs.utilities.LocaleUtils;

/**
 * 
 * @author dailey
 */
public class MessageEntity extends Entity implements IMessage {

	private String message_id;
	private String message_locale;
	private String message_content;

	@Override
	public String getContent() {
		return message_content;
	}

	@Override
	public Locale getLocale() {
		return LocaleUtils.langToLocale(message_locale);
	}

	@Override
	public String getMessageId() {
		return message_id;
	}

	public void setMessageId(String messageId) {
		this.message_id = messageId;
	}

	public void setLocale(String locale) {
		this.message_locale = locale;
	}

	public void setContent(String content) {
		this.message_content = content;
	}

	@Override
	public String toString() {
		return "MessageEntity [messageId=" + message_id + ", locale=" + message_locale + ", content=" + message_content
				+ "]";
	}
}
