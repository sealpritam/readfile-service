package com.practice.readfile.domain;

public class BaseRecord {
	
	private Header header;
	private Footer footer;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Footer getFooter() {
		return footer;
	}
	public void setFooter(Footer footer) {
		this.footer = footer;
	}
	@Override
	public String toString() {
		return "BaseRecord [header=" + header + ", footer=" + footer + "]";
	}
	
}
