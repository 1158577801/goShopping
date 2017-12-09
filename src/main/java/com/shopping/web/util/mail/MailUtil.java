package com.shopping.web.util.mail;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 类名称: mailUtil 功能描述: TODO 邮件发送例子 创建人: Gavin-Nie 创建时间: 2014-12-4 上午9:20:16
 * 
 * @version V1.0
 */
public class MailUtil {
	/**
	 * 方法名: sendEmail 功能描述: TODO 发送邮件
	 * 
	 * @param: @param
	 *             userName 邮箱账号
	 * @param: @param
	 *             password 邮箱密码
	 * @param: @param
	 *             targetAddress 目标邮箱地址
	 * @param: @param
	 *             mimeDTO 邮件部分参数
	 * @return: boolean
	 * @throws GeneralSecurityException
	 */
	public static boolean sendEmail(MimeMessageVo mimeDTO) {
		try {
			Long startTime=System.currentTimeMillis();
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTPUtil.getSMTPAddress(mimeDTO.getUserName()));// SMTPUtil.SimpleMailSender(userName)
			props.setProperty("mail.smtp.auth", "true");
			props.put("mail.smtp.user", mimeDTO.getUserName());
			props.put("mail.smtp.password", mimeDTO.getPassword());
			props.setProperty("mail.transport.protocol", "smtp");
			// qq邮件发送需要ssl认证
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", true);
			props.put("mail.smtp.ssl.socketFactory", sf);
			//
			Session session = Session.getInstance(props,
					new PopupAuthenticator(mimeDTO.getUserName(), mimeDTO.getPassword()));
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(mimeDTO.getUserName()));
			msg.setRecipients(Message.RecipientType.TO, mimeDTO.getTargetAddress());
			// 把DTO设置的内容，复制到msg中
			BeanUtils.copyProperties(msg, mimeDTO);
			msg.setContent(mimeDTO.getText(), "text/html;charset=utf-8");
			// 发送邮件
			Transport.send(msg);
			Long endTime=System.currentTimeMillis();
			System.out.println("================【" + mimeDTO.getUserName() + "】发送邮件【" + mimeDTO.getTargetAddress()
					+ "】成功====================用时："+(endTime-startTime));
			return true;
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) throws InterruptedException, GeneralSecurityException {
		for (int i = 0; i < 1; i++) {
			MailUtil.sendEmail(
					new MimeMessageVo("wct23817661432@163.com", "WCT1158577801", "1158577801@qq.com", "222", "222"));
			MailUtil.sendEmail(
					new MimeMessageVo("2381766143@qq.com", "axigdkqucwpxdiif", "1158577801@qq.com", "222", "222"));
		}
	}
}
