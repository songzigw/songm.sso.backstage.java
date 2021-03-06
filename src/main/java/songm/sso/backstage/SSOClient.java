/*
 * Copyright [2016] [zhangsong <songm.cn>].
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package songm.sso.backstage;

import songm.sso.backstage.entity.Attribute;
import songm.sso.backstage.entity.Session;
import songm.sso.backstage.event.ConnectionListener;

/**
 * 后台客户端接口
 *
 * @author zhangsong
 * @since 0.1, 2016-7-29
 * @version 0.1
 * 
 */
public interface SSOClient {
    
    /** 连接断开 */
    public static final int DISCONNECTED = 0;
    /** 连接上了 */
    public static final int CONNECTED = 1;
    /** 正在连接 */
    public static final int CONNECTING = 2;

    public int getConnState();
    
    public void addListener(ConnectionListener listener);

    public void connect(String key, String secret) throws SSOException;

    public void disconnect();
    
    public Session report(String sessionId) throws SSOException;
    
    public Session login(String sessionId, String userId, String userInfo) throws SSOException;
    
    public void logout(String sessionId) throws SSOException;
    
    public Session getSession(String sessionId) throws SSOException;
    
    public void setAttribute(String sessionId, String key, String value) throws SSOException;

    public Attribute getAttribute(String sessionId, String key) throws SSOException;
    
}
