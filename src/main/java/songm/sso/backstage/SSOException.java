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

/**
 * 异常类
 *
 * @author  zhangsong
 * @since   0.1, 2016-8-2
 * @version 0.1
 * 
 */
public class SSOException extends Exception {

    private static final long serialVersionUID = 5118981894942473582L;

    private ErrorCode errorCode;

    private String description;

    public SSOException(ErrorCode errorCode, String description) {
        super(errorCode + ":" + description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public SSOException(ErrorCode errorCode, String description, Throwable cause) {
        super(errorCode + ":" + description, cause);
        this.errorCode = errorCode;
        this.description = description;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public static enum ErrorCode {
        // 连接-------------------
        /** 连接错误 */
        CONN_ERROR,
        
        // 授权异常---------------
        /** 授权失败 */
        AUTH_FAILURE,
        /** 授权失效 */
        AUTH_DISABLED,
        
        /** 超时 */
        TIMEOUT,
    }
}
