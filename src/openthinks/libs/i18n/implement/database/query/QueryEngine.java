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
 * @Title: QueryEngineJDBC.java 
 * @Package i18n.implement.database 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n.implement.database.query;

import java.io.Serializable;
import java.util.Locale;

import openthinks.libs.i18n.I18n;
import openthinks.libs.i18n.IMessage;

/**
 * Queryer engine for persist message, which {@link IQueryer} can retrieve it from database.
 * @author dailey
 *
 */
public abstract class QueryEngine {

	/**
	 * get queryer which could retrieve persist message from database.
	 * @return IQueryer
	 */
	public abstract IQueryer getQueryer();

	public static IQueryer get() {
		if (queryEngineImpl == null) {
			return useDefaultQueryEngine().getQueryer();
		}
		return queryEngineImpl.getQueryer();
	}

	/**
	 * 
	 */
	private static QueryEngine useDefaultQueryEngine() {
		return new DefaultBundleQueryEngine();
	}

	private static QueryEngine queryEngineImpl;

	public static void registerQueryEngine(QueryEngine queryEngineImpl) {
		QueryEngine.queryEngineImpl = queryEngineImpl;
	}

	protected static class DefaultBundleQueryEngine extends QueryEngine {

		/* (non-Javadoc)
		 * @see i18n.implement.database.QueryEngine#getQueryer()
		 */
		@Override
		public IQueryer getQueryer() {
			return new IQueryer() {

				@Override
				public String query(String packName, Serializable messageId, Locale locale) {
					String id = String.valueOf(messageId);
					return I18n.getMessage(packName, locale, id);
				}

				@Override
				public <T extends IMessage> T query(Class<T> entityClass, Serializable messageId, Locale locale) {
					throw new UnsupportedOperationException();
				}
			};
		}

	}

}
