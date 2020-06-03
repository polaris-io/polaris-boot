/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.polarisframework.boot.core.lang;

import io.polarisframework.boot.core.constant.SerializableConst;

/**
 * Class is general service exception which is associated
 * with status code.
 *
 * @author  Nielson Ge
 * @since   0.0.0.1
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = SerializableConst.DEFAULT_VERSION_UID;

    protected long statusCode;

    public ServiceException(long statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public ServiceException(long statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public ServiceException(long statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public ServiceException(long statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public long getStatusCode() {
        return statusCode;
    }
}
