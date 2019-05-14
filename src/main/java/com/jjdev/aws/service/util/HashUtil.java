package com.jjdev.aws.service.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class HashUtil {

	public static String getSecureHash(String text) {
		return DigestUtils.sha256Hex(text);
	}

}
