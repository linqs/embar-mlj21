/*
 * This file is part of the PSL software.
 * Copyright 2011-2015 University of Maryland
 * Copyright 2013-2018 The Regents of the University of California
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.linqs.psl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * A utility to help build hash codes for objects.
 * This class borrows the methodology from org.apache.commons.lang3.builder.HashCodeBuilder.
 * We do not just directly use that class and instead choose a static class to reduce
 * allocations in high-traffic code like atoms or ground rules.
 *
 * When adding to a hash code, the previous value can be supplied as the |start| parameter.
 * Therefore, calls can be nested:
 * int myHashCode = HashCode.build(HashCode.build(a), b);
 */
public class Hash {
	// Static only.
	private Hash() {}

	public static String md5(String data) {
		return bytesToHex(compute(data, "MD5"));
	}

	public static String md5(byte[] data) {
		return bytesToHex(compute(data, "MD5"));
	}

	public static String sha(String data) {
		return bytesToHex(compute(data, "SHA-1"));
	}

	public static String sha(byte[] data) {
		return bytesToHex(compute(data, "SHA-1"));
	}

	public static String sha256(String data) {
		return bytesToHex(compute(data, "SHA-256"));
	}

	public static String sha256(byte[] data) {
		return bytesToHex(compute(data, "SHA-256"));
	}

	// Taken from: http://www.baeldung.com/sha-256-hashing-java
	public static String bytesToHex(byte[] data) {
		StringBuffer builder = new StringBuffer();

		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(0xff & data[i]);
			if (hex.length() == 1) {
				builder.append('0');
			}
			builder.append(hex);
		}

		return builder.toString();
	}

	public static byte[] compute(String data, String algorithm) {
		return compute(data.getBytes(StandardCharsets.UTF_8), algorithm);
	}

	public static byte[] compute(byte[] data, String algorithm) {
		MessageDigest digest = null;

		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}

		return digest.digest(data);
	}
}
