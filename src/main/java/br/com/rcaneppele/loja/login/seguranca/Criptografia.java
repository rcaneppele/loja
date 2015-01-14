package br.com.rcaneppele.loja.login.seguranca;

import org.apache.commons.codec.digest.DigestUtils;

public class Criptografia {
	
	public String criptografa(String original, String saltInfo) {
		String salt = new StringBuilder(saltInfo.toUpperCase()).reverse().toString();
		return DigestUtils.sha512Hex(original + salt);
	}
	
}
