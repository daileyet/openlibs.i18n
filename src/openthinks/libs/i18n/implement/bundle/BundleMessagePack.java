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
 * @Title: BundleMessagePack.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey_dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.bundle;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import openthinks.libs.i18n.AbstractMessagePack;
import openthinks.libs.i18n.IMessage;

/**
 * Use {@link ResourceBundle} to implement the function of i18n.
 * @author dailey_dai
 */
public class BundleMessagePack extends AbstractMessagePack {
	
	public BundleMessagePack(String packName) {
		super(packName);
	}

	/* (non-Javadoc)
	 * @see i18n.IMessagePack#getMessage(java.util.Locale, java.lang.String, java.lang.Object[])
	 */
	@Override
	public IMessage getMessage(Locale locale, Serializable messageId) {
		ResourceBundle resource = getResourceBundle(locale);
		BundleMessage bundleMessage = BundleMessage.generateBundleMessage(resource, (String) messageId);
		return bundleMessage;
	}

	/**
	 * @param locale Locale
	 * @return ResourceBundle
	 */
	private ResourceBundle getResourceBundle(Locale locale) {
		ResourceBundle resource = ResourceBundle.getBundle(getPackName(), locale);
		return resource;
	}

}
