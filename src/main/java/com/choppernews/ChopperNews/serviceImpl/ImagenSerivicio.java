package com.choppernews.ChopperNews.serviceImpl;

import java.io.IOException;

import net.iharder.Base64;

public class ImagenSerivicio {

	
	public String encode(String valor) {
		return Base64.encodeBytes(valor!=null?valor.getBytes():null);
		
	}
	
	public String decode(String base64) throws Exception {
		try {
			byte[] valor = Base64.decode(base64);
			return new String(valor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
