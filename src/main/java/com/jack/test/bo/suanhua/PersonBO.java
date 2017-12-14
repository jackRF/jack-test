package com.jack.test.bo.suanhua;

import java.util.List;

/**
 * 算话征信报告-身份信息概要
 * @author YM10177
 *
 */
public class PersonBO {
	public Identification identification;
	public List<Occupation> occupations;
	public List<ContactAddress> contactAddresses;
	public List<Estate> estates;
	/**
	 * 算话征信报告-身份信息
	 * @author YM10177
	 *
	 */
	public static class Identification {
		public int gender;
		public String birthday;
		public String idType;
		public String idCard;
		public int marriage;
		public int eduLevel;
	}
	/**
	 * 算话征信报告-职业信息
	 * @author YM10177
	 *
	 */
	public static class Occupation {
		public String company;
		public String companyAddress;
		public String updateTime;
	}
	/**
	 * 算话征信报告-通讯地址信息
	 * @author YM10177
	 *
	 */
	public static class ContactAddress {
		public String contactAddress;
		public String updateTime;
	}
	/**
	 * 算话征信报告-居住地址信息
	 * @author YM10177
	 *
	 */
	public static class Estate {
		public String address;
		public String condition;
		public String updateTime;
	}
}
