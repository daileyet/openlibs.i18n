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
 * @Title: MessagePackManager.java 
 * @Package i18n.implement.bundle 
 * @Description: TODO
 * @author dailey dai 
 * @date 2012-2-26
 * @version V1.0 
 */
package openthinks.libs.i18n;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a simple manager and factory for {@link IMessagePack}
 * @author dailey dai
 */
public abstract class MessagePackManager {
	private Map<String, IMessagePack> messagePackCache = new ConcurrentHashMap<String, IMessagePack>();
	private Lock lock = new ReentrantLock();

	/**
	 * Get {@link IMessagePack} by unique message pack name.
	 * It will retrieve firstly from inner cache.
	 * @param packName String message pack name
	 * @return IMessagePack
	 */
	public IMessagePack getMessagePack(String packName) {
		IMessagePack messagePack = messagePackCache.get(packName);
		lock.lock();
		try {
			if (messagePack == null) {
				messagePack = createMessagePack(packName);
				messagePackCache.put(packName, messagePack);
			}
		} finally {
			lock.unlock();
		}
		return messagePack;
	}

	/**
	 * Create a instance that implement for {@link IMessagePack} by its pack name.
	 * @param packName String message pack name
	 * @return IMessagePack
	 */
	public abstract IMessagePack createMessagePack(String packName);

}
