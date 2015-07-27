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
 * @Title: IBundleMessageType.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey 
 * @date 2012-11-1
 * @version V1.0 
 */
package com.openthinks.libs.i18n.implement.bundle;

import com.openthinks.libs.i18n.IMessageType;

/**
 * Used to implemented for customized {@link IMessageType}<BR>
 * Need to use a combination of {@link BundleMessageContext}<BR>
 * Useage:<BR>
 * <code>
  	public enum DefaultBundleMessageType implements IBundleMessageType {<BR>
 	&nbsp;LOG, EXCEPTION, UI;<BR><BR>
 	
	&nbsp;public String value() {<BR>
	  &nbsp;&nbsp;return toString() + ":" + BASE_PACK_DIR + toString();<BR>
	&nbsp;}<BR><BR>
	
	&nbsp;public String getPackName() {<BR>
	  &nbsp;&nbsp;String packName = null;<BR>
	  &nbsp;&nbsp;String val = value();<BR>
	  &nbsp;&nbsp;if (val != null) {<BR>
	   &nbsp;&nbsp;&nbsp;int split = val.indexOf(":");<BR>
	   &nbsp;&nbsp;&nbsp;if (-1 != split) {<BR>
	    &nbsp;&nbsp;&nbsp;&nbsp;packName = val.substring(split + 1);<BR>
	   &nbsp;&nbsp;&nbsp;}<BR>
	  &nbsp;&nbsp;}<BR>
		&nbsp;&nbsp;return packName;<BR>
	  &nbsp;}<BR><BR>
	
	  &nbsp;public String getPackType() {<BR>
	   &nbsp;&nbsp;String packType = null;<BR>
	   &nbsp;&nbsp;String val = value();<BR>
	   &nbsp;&nbsp;if (val != null) {<BR>
	    &nbsp;&nbsp;&nbsp;int split = val.indexOf(":");<BR>
	    &nbsp;&nbsp;&nbsp;if (-1 != split) {<BR>
		 &nbsp;&nbsp;&nbsp;&nbsp;packType = val.substring(0, split);<BR>
		 &nbsp;&nbsp;&nbsp;}<BR>
	    &nbsp;&nbsp;}<BR>
	    &nbsp;&nbsp;return packType;<BR>
	  &nbsp;}<BR><BR>

	  &nbsp;public static final String BASE_PACK_DIR = "resource/i18n/";	<BR>
	  
   }
 * </code>
 * @author dailey
 *
 */
public interface IBundleMessageType extends IMessageType {

	/**
	 * get bundle message pack name
	 * @return String
	 */
	public String getPackName();

	/**
	 * get bundle message pack type
	 * @return String
	 */
	public String getMessageType();

}
