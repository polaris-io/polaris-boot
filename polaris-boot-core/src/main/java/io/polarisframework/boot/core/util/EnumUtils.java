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
package io.polarisframework.boot.core.util;

import io.polarisframework.boot.core.lang.ValuedEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

/**
 * EnumUtils provides the operations for {@link ValuedEnum}
 * such as value of, is valid...
 *
 * @author  Nielson Ge
 * @since   0.0.0.1
 */
public abstract class EnumUtils {

    private static final Logger logger = LoggerFactory.getLogger(EnumUtils.class);

    public static <T extends ValuedEnum<V>, V> T valueOf(Class<T> clazz, V value) {
        if (clazz == null) {
            logger.warn("Enumeration class is null.");
            return null;
        }

        return Stream.of(clazz.getEnumConstants())
                .filter(x -> x.equals(value))
                .findFirst()
                .orElse(null);
    }

    public static <T extends ValuedEnum<V>, V> boolean isValid(Class<T> clazz, V value) {
        return valueOf(clazz, value) != null;
    }
}
