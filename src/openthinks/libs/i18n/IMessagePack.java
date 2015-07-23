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
 * @Title: IMessagePack.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey_dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * Hold multi-languages messages
 * @author dailey_dai
 *
 */
public interface IMessagePack {

	/**
	 * get message pack unique name
	 * @return String message pack name
	 */
	public String getPackName();

	/**
	 * set message pack unique name
	 * @param packName String
	 */
	public void setPackName(String packName);

	/**
	 * get message holder by {@link Locale} and message unique key id
	 * @param locale Locale
	 * @param messageId message unique key
	 * @return IMessage
	 */
	public IMessage getMessage(Locale locale, Serializable messageId);
	
	/**
	 * format message origin content by arguments
	 * @param message IMessage for example {0} xx {1}.
	 * @param args arguments for message format
	 * @see MessageFormat
	 * @return String
	 */
	public String format(IMessage message,Object... args);

}
