package com.shopping.web.util.mail;

import java.util.Date;

/**
 * 类名称: MimeMessageHelp 功能描述: TODO 邮件相关参数设置 DTO 创建人: GavinNie 创建时间: 2014-12-4
 * 上午9:29:51
 * 
 * @version V1.0
 */
public class MimeMessageVo {
	/**
	 * 变量名 userName: TODO 邮箱用户名
	 */
	private String userName;

	/**
	 * 变量名 password: TODO 邮箱地址
	 */
	private String password;

	/**
	 * 变量名 targetAddress: TODO 目标邮箱地址
	 */
	private String targetAddress;
	/**
	 * 变量名 subject: TODO 邮件标题
	 */
	private String subject;

	/**
	 * 变量名 sentDate: TODO 邮件日期
	 */
	private Date sentDate;

	/**
	 * 变量名 text: TODO 邮件内容
	 */
	private String text;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTargetAddress() {
		return targetAddress;
	}

	public void setTargetAddress(String targetAddress) {
		this.targetAddress = targetAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getSentDate() {
		return new Date();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MimeMessageVo(String userName, String password, String targetAddress, String subject, String text) {
		super();
		this.userName = userName;
		this.password = password;
		this.targetAddress = targetAddress;
		this.subject = subject;
		this.text = text;
	}

}
