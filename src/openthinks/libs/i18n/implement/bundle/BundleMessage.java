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
 * @Title: BundleMessage.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey_dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

import openthinks.libs.i18n.AbstractMessage;
import openthinks.libs.i18n.IMessage;

/**
 * Bundle message hold bundle file i18n message.
 * @author dailey_dai
 */
public class BundleMessage extends AbstractMessage implements IMessage {
	public static BundleMessage generateBundleMessage(ResourceBundle bundle, String id) {
		BundleMessage instance = new BundleMessage(id, bundle.getString(id), bundle.getLocale());
		return instance;
	}

	public BundleMessage(){}
	
	/**
	 * @param id
	 * @param content
	 * @param locale
	 */
	public BundleMessage(String id, String content, Locale locale) {
		super(id, content, locale);
	}

	/**
	 * @param id
	 * @param content
	 */
	public BundleMessage(String id, String content) {
		super(id, content);
	}

}
