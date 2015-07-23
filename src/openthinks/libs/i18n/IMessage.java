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
 * @Title: IMessage.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.io.Serializable;
import java.util.Locale;

/**
 * Represent every message under a locale
 * @author dailey dai
 *
 */
public interface IMessage {
	/**
	 * message unique key
	 * @return Serializable
	 */
	public Serializable getMessageId();

	/**
	 * message origin content for {@code getLocale()}
	 * @return String
	 */
	public String getContent();

	/**
	 * message locale
	 * @see Locale
	 * @return java.util.Locale
	 */
	public Locale getLocale();

	//	/**
	//	 * format message origin content by arguments
	//	 * @param args arguments for message format
	//	 * @see MessageFormat
	//	 * @return String
	//	 */
	//	public String format(Object... args);

}
