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
 * @Title: IQueryer.java 
 * @Package i18n.implement.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.database.query;

import java.io.Serializable;
import java.util.Locale;

import openthinks.libs.i18n.IMessage;

/**
 * @author dailey
 *
 */
public interface IQueryer {

	/**
	 * query entity which implemented {@link IMessage} by message id and locale.<BR>
	 * it is best use it when the implements is by ORM framework like Hibernate etc.
	 * @param entityClass corresponding database table
	 * @param id		message id
	 * @param locale    message locale
	 * @return
	 */
	<T extends IMessage> T query(Class<T> entityClass, Serializable messageId, Locale locale);

	/**
	 * query message content by tableName and message id, locale.
	 * @param tableName
	 * @param id
	 * @param locale
	 * @return
	 */
	String query(String tableName, Serializable messageId, Locale locale);

}
