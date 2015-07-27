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
 * @Title: DefaultBundleMessageType.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey_dai 
 * @date Apr 16, 2012
 * @version V1.0 
 */
package com.openthinks.libs.i18n.bundle;

import com.openthinks.libs.i18n.IMessageType;
import com.openthinks.libs.i18n.implement.bundle.IBundleMessageType;

/**
 * default bundle message type enum for implementation of {@link IMessageType}
 * @author dailey_dai
 */
public enum DefaultBundleMessageType implements IBundleMessageType {
	LOG, EXCEPTION, UI;

	/* (non-Javadoc)
	 * @see i18n.IMessageType#value()
	 */
	@Override
	public String value() {
		return toString() + ":" + BASE_PACK_DIR + toString();
	}

	/**
	 * get bundle message pack name
	 * @return String
	 */
	@Override
	public String getPackName() {
		String packName = null;
		String val = value();
		if (val != null) {
			int split = val.indexOf(":");
			if (-1 != split) {
				packName = val.substring(split + 1);
			}
		}
		return packName;
	}

	/**
	 * get bundle message pack type
	 * @return String
	 */
	@Override
	public String getMessageType() {
		String packType = null;
		String val = value();
		if (val != null) {
			int split = val.indexOf(":");
			if (-1 != split) {
				packType = val.substring(0, split);
			}
		}
		return packType;
	}

	public static final String BASE_PACK_DIR = "openthinks/libs/i18n/resource/i18n/";
}
