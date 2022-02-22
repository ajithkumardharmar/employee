package com.mobilesalesapp.util;



public class EncryptionAndDecryption {
	private  String cred;
	private  char[] chars;
	private char[] let;
	private String encryptedPassword;
	
	EncryptionAndDecryption() {
		cred="oracle";
		chars=cred.toCharArray();
		let=new char[chars.length];
		
		int i=0;
		for(char c : chars) {
			c+=7;
			let[i]=c;
			i++;
		}
		encryptedPassword=String.valueOf(let);
	
	}
	public  String decryt() {
		
		chars=encryptedPassword.toCharArray();
		let=new char[chars.length];
		int i=0;
		for(char c : chars) {
			c-=7;
			let[i]=c;
			i++;
		}
		return String.valueOf(let);
	}

}
