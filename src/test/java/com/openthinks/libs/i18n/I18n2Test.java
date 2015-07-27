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
 * @Title: I18n2Test.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey_dai 
 * @date Apr 16, 2012
 * @version V1.0 
 */
package com.openthinks.libs.i18n;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

import com.openthinks.libs.i18n.bundle.DefaultBundleMessageType;
import com.openthinks.libs.i18n.bundle.MyBundleMessageType;
import com.openthinks.libs.i18n.implement.database.PersistMessage;

/**
 * @author dailey_dai
 *
 */
public class I18n2Test {

	@Test
	public void testGetMessage() {
		String actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.UK, "1000");
		String expected = "Test log1_EN_GB";
		Assert.assertEquals(expected, actual);
		actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.CHINA, "1000");
		expected = "\u6D4B\u8BD5\u65E5\u5FD71";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFormatMsg() {
		String actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.ITALY, "1004");
		String expected = "Test {0} log at {0}";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.ITALY, "1004", "Hello");
		expected = "Test Hello log at Hello";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCustomizeMessageType() {
		String actual = I18n.getMessage(MyBundleMessageType.MY, Locale.UK, "2000");
		String expected = "Test Customize.";
		Assert.assertEquals(expected, actual);
		actual = I18n.getMessage(MyBundleMessageType.MY, "2000");
		expected = "Test Customize.";
		if (Locale.getDefault() == Locale.CHINA) {
			expected = "客制化.";
		}
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetMessageByEntityClass() {
		Throwable t = null;
		try {
			I18n.getMessage(PersistMessage.class, "1000");
		} catch (Exception e) {
			t = e;
		}
		Assert.assertNotNull(t);
		Assert.assertTrue(t.getClass() == MissingResourceException.class);

	}

}
