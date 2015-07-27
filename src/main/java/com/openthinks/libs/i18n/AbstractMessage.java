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
 * @Title: AbstractMessage.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package com.openthinks.libs.i18n;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author dailey
 *
 */
public abstract class AbstractMessage implements IMessage {

	protected Serializable id;
	protected String content;
	protected Locale locale;

	protected AbstractMessage() {
		super();
	}

	protected AbstractMessage(Serializable id, String content) {
		this(id, content, I18nApplicationLocale.getInstance().getCurrentLocale());
	}

	protected AbstractMessage(Serializable id, String content, Locale locale) {
		super();
		this.id = id;
		this.content = content;
		this.locale = locale;
	}

	@Override
	public Serializable getMessageId() {
		return id;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	public String format(Object... args) {
		if (args == null || args.length == 0) {
			return getContent();
		}
		return MessageFormat.format(getContent(), args);
	}

}