function ValidateForm() {
	//debugger;
	 var rkEncryptionKey = CryptoJS.enc.Base64.parse('u/Gu5posvwDsXUnV5Zaq4g=='); 
	 var rkEncryptionIv = CryptoJS.enc.Base64.parse('5D9r9ZVzEYYgha93/aUK2w=='); 
     var utf8Stringified = CryptoJS.enc.Utf8.parse(document.getElementById("password").value); 
	 var encrypted = CryptoJS.AES.encrypt(utf8Stringified.toString(), rkEncryptionKey,  
	 {mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7, iv: rkEncryptionIv});
	 document.getElementById("password").value =encrypted.ciphertext.toString(CryptoJS.enc.Base64); 
	/*var isValid=true;	
	isValid = Validate(); // form validation returning true or false	
	return isValid;*/   
}