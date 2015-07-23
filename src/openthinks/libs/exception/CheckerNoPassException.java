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
 * @Title: CheckerNoPassException.java 
 * @Package exception 
 * @author minjdai 
 * @date 2014/10/13
 * @version V1.0 
 */
package openthinks.libs.exception;

/**
 * @author minjdai
 *
 */
public class CheckerNoPassException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5943464103511793475L;

	public CheckerNoPassException() {
		super();
	}

	public CheckerNoPassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super();
	}

	public CheckerNoPassException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckerNoPassException(String causeMethod, String message) {
		super("Failed on [" + causeMethod + "] checker;" + message);
	}

	public CheckerNoPassException(Throwable cause) {
		super(cause);
	}

}
