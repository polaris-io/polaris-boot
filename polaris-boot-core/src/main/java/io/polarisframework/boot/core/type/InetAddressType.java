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
package io.polarisframework.boot.core.type;

import io.polarisframework.boot.core.lang.ValuedEnum;

/**
 * Network address type enumeration.
 *
 * @author  Nielson Ge
 * @since   0.0.0.1
 */
public enum InetAddressType implements ValuedEnum<Byte> {
    IPv4((byte)0),
    IPv6((byte)1);

    protected final byte value;

    InetAddressType(byte value) {
        this.value = value;
    }

    @Override
    public Byte getValue() {
        return value;
    }
}
