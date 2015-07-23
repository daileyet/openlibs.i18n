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
 * @Title: I18nTest.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.util.Locale;

import openthinks.libs.i18n.bundle.DefaultBundleMessageType;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dailey dai
 *
 */
public class I18nTest {
	static String BASE_PACK_DIR = DefaultBundleMessageType.BASE_PACK_DIR;
	static String LOG_PACK_NAME = "Log";

	
	@Test
	public void testGetMessage2() {
		String actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.UK, "1000");
		String expected = "Test log1_EN_GB";
		Assert.assertEquals(expected, actual);
		actual = I18n.getMessage(DefaultBundleMessageType.LOG, Locale.CHINA, "1000");
		expected = "\u6D4B\u8BD5\u65E5\u5FD71";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetMessage() {
		String actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, Locale.CHINA, "1000");
		String expected = "测试日志1";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, Locale.UK, "1000");
		expected = "Test log1_EN_GB";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, Locale.CHINESE, "1000");
		expected = "测试日志1_ZH";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, Locale.FRANCE, "1000");
		expected = "Test log1";
		Assert.assertNotSame(expected, actual);

		actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, "1003");
		expected = "Test {0} log";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetDefaultMessage() {
		String actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, "1000");
		String expected = "测试日志1";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetFormatMessage() {
		String actual = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, "1003", "the third");
		String expected = "Test the third log";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetLogMessage() {
		String actual = I18n.getMessage(DefaultBundleMessageType.LOG, "1000");
		String expected = "测试日志1";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(DefaultBundleMessageType.LOG, "1003");
		expected = "Test {0} log";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(DefaultBundleMessageType.LOG, "1003", "3");
		expected = "Test 3 log";
		Assert.assertEquals(expected, actual);

		actual = I18n.getMessage(DefaultBundleMessageType.LOG, "1003", 3);
		expected = "Test 3 log";
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetUIMessage() {
		String actual = I18n.getMessage(DefaultBundleMessageType.UI, "2000");
		String expected = "Test UI.";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetExceptionMessage() {
		String actual = I18n.getMessage(DefaultBundleMessageType.EXCEPTION, "3000");
		String expected = "Test Exception.";
		Assert.assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		System.out.println(Locale.CHINESE);
		System.out.println(Locale.CHINA);
		System.out.println(Locale.US);
	}

}
