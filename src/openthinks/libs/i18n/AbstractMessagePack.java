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
 * @Title: AbstractMessagePack.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.text.MessageFormat;

/**
 * @author dailey
 *
 */
public abstract class AbstractMessagePack implements IMessagePack {

	protected String packName;

	/**
	 * 
	 */
	protected AbstractMessagePack() {
		super();
	}

	/**
	 * @param packName
	 */
	protected AbstractMessagePack(String packName) {
		super();
		this.packName = packName;
	}

	@Override
	public String getPackName() {
		return packName;
	}

	@Override
	public void setPackName(String packName) {
		if (packName != null && !packName.equals(this.packName)) {
			this.packName = packName;
		}

	}

	/* (non-Javadoc)
	 * @see i18n.IMessagePack#format(java.lang.String, java.lang.Object[])
	 */
	@Override
	public String format(IMessage message, Object... args) {
		if (message == null)
			return null;
		if (args == null || args.length == 0) {
			return message.getContent();
		}
		return MessageFormat.format(message.getContent(), args);
	}

}