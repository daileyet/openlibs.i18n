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
 * @Title: I18n3TestForDB.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-2
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.util.Locale;

import openthinks.libs.i18n.database.MessageEntity;
import openthinks.libs.i18n.database.MyPersistMessageType;
import openthinks.libs.i18n.database.QueryEngineJDBC;
import openthinks.libs.i18n.implement.database.PersistMessageContext;
import openthinks.libs.utilities.LocaleUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dailey
 * 
 */
public class I18n3TestForDB {

	@Before
	public void setUp() throws ClassNotFoundException {
		//configure method1:
		I18n.configurePackContext(new PersistMessageContext(new QueryEngineJDBC()));
		//configure method2:
		Class.forName("openthinks.libs.i18n.database.QueryEngineJDBC");
		I18n.configurePackContext(new PersistMessageContext());
	}

	@Test
	public void testForQueryFromDB() {
		String actual = I18n.getMessage("message", Locale.US, "1000");
		String expected = "Hello";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage("message", Locale.CHINA, "1000");
		expected = "你好";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage("message", "1000");
		expected = "Hello";
		if (LocaleUtils.isSame(Locale.CHINA, I18nApplicationLocale.getInstance().getCurrentLocale())) {
			expected = "你好";
		}
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage("message", "XXXX");
		Assert.assertNull(actual);

		actual = I18n.getMessage("xxx", "XXXX");
		Assert.assertNull(actual);
	}

	@Test
	public void testForQueryEntityClass() {
		String actual = I18n.getMessage(MessageEntity.class, Locale.US, "1000");
		String expected = "Hello";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(MessageEntity.class, Locale.CHINA, "1000");
		expected = "你好";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(MessageEntity.class, "1000");
		expected = "Hello";
		if (LocaleUtils.isSame(Locale.CHINA, I18nApplicationLocale.getInstance().getCurrentLocale())) {
			expected = "你好";
		}
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(MessageEntity.class, "XXXX");
		Assert.assertNull(actual);

		actual = I18n.getMessage(MessageEntity.class, "XXXX");
		Assert.assertNull(actual);
	}

	@Test
	public void testForQueryByType() {
		String actual = I18n.getMessage(MyPersistMessageType.ALL, Locale.US, "1000");
		String expected = "Hello";
		Assert.assertEquals(expected, actual);
	}

}
