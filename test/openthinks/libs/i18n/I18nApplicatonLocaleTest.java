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
 * @Title: I18nApplicatonLocaleTest.java 
 * @Package i18n 
 * @Description: TODO
 * @author dailey dai 
 * @date 2012-2-27
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dailey dai
 *
 */
public class I18nApplicatonLocaleTest {
	Observer obsever1, observer2;
	Result result;

	@Before
	public void setUp() {
		result = new Result();
		obsever1 = new UIExample1(result);
		observer2 = new UIExample2(result);
		I18nApplicationLocale.getInstance().addObserver(obsever1);
		I18nApplicationLocale.getInstance().addObserver(observer2);
	}

	@Test
	public void testChangeCurrentLocale() {
		Locale actual = I18nApplicationLocale.getInstance().getCurrentLocale();
		Locale expected = Locale.getDefault();
		Assert.assertEquals(expected, actual);

		I18nApplicationLocale.getInstance().changeCurrentLocale(Locale.ITALIAN);
		int actualCount = result.getResult();
		int expectedCount = 2;
		Assert.assertEquals(expectedCount, actualCount);
	}

}

class Result {
	private AtomicInteger count = new AtomicInteger(0);

	public void increament() {
		count.addAndGet(1);
	}

	public int getResult() {
		return count.get();
	}
}

class UIExample1 implements Observer {
	private Result result;

	/**
	 * 
	 */
	public UIExample1(Result result) {
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		result.increament();
		System.out.println(this.getClass() + " update called.");
	}

}

class UIExample2 implements Observer {
	private Result result;

	/**
	 * 
	 */
	public UIExample2(Result result) {
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		result.increament();
		System.out.println(this.getClass() + " update called.");
	}

}