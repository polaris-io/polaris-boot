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

import io.polarisframework.boot.core.type.InetAddressType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Various network utilities.
 *
 * @author  Nielson Ge
 * @since   0.0.0.1
 */
public abstract class NetUtils {

    private static final Logger logger = LoggerFactory.getLogger(NetUtils.class);

    public static InetAddress getLocalInetAddress(InetAddressType addressType, String interfaceName) {
        if (EnumUtils.isValid(InetAddressType.class, addressType.getValue())) {
            return null;
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                if (StringUtils.isNotBlank(interfaceName)) {
                    if (!interfaceName.equals(networkInterface.getName())) {
                        continue;
                    }
                }

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();

                    if ((addressType == InetAddressType.IPv4 && address instanceof Inet4Address) ||
                            (addressType == InetAddressType.IPv6 && address instanceof Inet6Address)) {
                        if (address.isLinkLocalAddress() || address.isLoopbackAddress() || address.isAnyLocalAddress()) {
                            continue;
                        }
                        return address;
                    }
                }
            }

            return null;
        } catch (Exception ex) {
            logger.error("Fail to get network address: {}", ex.getLocalizedMessage());
            return null;
        }
    }

    public static InetAddress getLocalInetAddress(InetAddressType addressType) {
        return getLocalInetAddress(addressType, null);
    }
}
