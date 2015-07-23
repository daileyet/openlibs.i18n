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
 * @Title: Checker.java 
 * @Package utilities 
 * @Description: TODO
 * @author dailey dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.utilities;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

import openthinks.libs.exception.CheckerNoPassException;

/**
 * @author dailey dai
 *
 */
public class Checker {

	public static <T> Requirer<T> require(T requireObject) {
		return new Requirer<T>(requireObject);
	}

	
	public static void main(String[] args) {
		Checker.require(null).notNull("test");
	}
	
	public static boolean isArray(Object checkObj){
		try{
			Array.getLength(checkObj);
			return true;
		}catch(IllegalArgumentException e){
			return false;
		}
		
	}

	public static class Requirer<T> {
		private T requireObject = null;

		public Requirer(T requireObject) {
			super();
			this.requireObject = requireObject;
		}

		public void notNull(String... args) {
			
			if (requireObject == null) {
				throw new CheckerNoPassException(CommonUtilities.getCurrentInvokerMethod(),CommonUtilities.toString4Array(args));
			}
		}
		
		
		public void equalTo(T comparedObj){
			if(requireObject==comparedObj){
				return;
			}
			if(requireObject!=null && requireObject.equals(comparedObj)){
				return;
			}
			if(Checker.isArray(requireObject) && Checker.isArray(comparedObj)){
				if(Arrays.deepEquals((Object[])requireObject,(Object[]) comparedObj)){
					return;
				}
			}
			//TODO compare collection
			
			throw new CheckerNoPassException();
		}

		/**
		 * check the call object extends or implements from the paremeter class
		 * @param clzz parent class
		 */
		public void isExtendsFrom(Class<?> clzz) {
			if (clzz == null || requireObject.getClass() == null) {
				throw new CheckerNoPassException();
			} else if (!clzz.isAssignableFrom(requireObject.getClass())) {
				throw new CheckerNoPassException(CommonUtilities.getCurrentInvokerMethod(),requireObject.getClass() + ":" + requireObject
						+ " need extends or implements " + clzz);
			}
		}

		/**
		 * when the call object is File type, check the file exist in local
		 */
		public void needExist() {
			if (requireObject instanceof File) {
				if (!((File) requireObject).exists()) {
					throw new CheckerNoPassException(CommonUtilities.getCurrentInvokerMethod(),requireObject + " does not exist.");
				}
			}
		}

		public void inScope(int min, int max) {
			notNull();
			if (Integer.valueOf(requireObject.toString()) < min || Integer.valueOf(requireObject.toString()) > max) {
				throw new CheckerNoPassException(CommonUtilities.getCurrentInvokerMethod(),requireObject + " not between " + min + " and " + max);
			}
		}

	}

}
