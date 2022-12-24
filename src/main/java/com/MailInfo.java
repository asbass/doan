package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {
	String from;
	String to;
	String[] cc;
	String[] bcc;
	String subject;
	String body;
	String[] attachments;
	public MailInfo(String to, String subject, String body) {
		super();
		this.from = "LK.SHOP <poly@fpt.edu.vn>";
		this.to = to;
		this.subject = subject;
		this.body ="Xin chào quý khách. Mật khẩu của bạn là: "+ body;
	}
}