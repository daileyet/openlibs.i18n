/**   
 *  Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
* @Title: AbstractBundleMessageType.java 
* @Package openthinks.libs.i18n.implement.bundle 
* @author dailey.yet@outlook.com  
* @date 2015-7-24
* @version V1.0   
*/
package openthinks.libs.i18n.implement.bundle;

/**
 * The implements need support the method value() to return 
 * the string as format : <strong>[type:]&lt;full-path&gt;</strong>
 * For example<BR>
 * Log:resource/i18n/Log
 * @author dailey.yet@outlook.com
 */
public abstract class AbstractBundleMessageType implements IBundleMessageType {

	/* (non-Javadoc)
	 * @see openthinks.libs.i18n.implement.bundle.IBundleMessageType#getPackName()
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

	/* (non-Javadoc)
	 * @see openthinks.libs.i18n.implement.bundle.IBundleMessageType#getMessageType()
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

}
