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
 * @Title: MyPersistMessageType.java 
 * @Package i18n.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n.database;

import openthinks.libs.i18n.IMessage;
import openthinks.libs.i18n.implement.database.IPersistMessageType;

/**
 * @author dailey
 *
 */
public enum MyPersistMessageType implements IPersistMessageType {
	ALL("message", MessageEntity.class);

	private MyPersistMessageType(String tableName, Class<? extends IMessage> entityClass) {
		this.tableName = tableName;
		this.entityClass = entityClass;
	}

	private String tableName;
	private Class<? extends IMessage> entityClass;

	@Override
	public String value() {
		return toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IMessage> Class<T> getMessageEntityClass() {
		return (Class<T>) entityClass;
	}

	@Override
	public String getPersistName() {
		return tableName;
	}

	@Override
	public String getMessageType() {
		return toString();
	}

}
