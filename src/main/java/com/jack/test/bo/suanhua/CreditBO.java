package com.jack.test.bo.suanhua;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 算话征信报告-信贷信息
 * @author YM10177
 *
 */
public class CreditBO {
	public Map<String,Indicator> indicator;
	public OverdueInfo overdueInfo;
	public DebtInfoContainer debtInfo;
	public RemoteCreditInfo remoteCreditInfo;
	public List<CreditInfo> creditInfos;
	public List<GuaranteeInfo> guaranteeInfos;
	/**
	 * 算话征信报告-对外担保信息明细
	 * @author YM10177
	 *
	 */
	public static class GuaranteeInfo{
		public String orgCode;
		public BigDecimal creditLimit;
		public String dateOpened;
		public String dateClosed;
		public BigDecimal occurSum;
		public String guaranteeType;
		public BigDecimal balance;
		public String updateDate;
	}
	/**
	 * 算话征信报告-信贷信息明细
	 * @author YM10177
	 *
	 */
	public static class CreditInfo{
		public CreditDetail creditDetail;
		public RepayStatus repayStatus;
		public List<Overdue> overdues;
		/**
		 * 算话征信报告-信贷信息
		 * @author YM10177
		 *
		 */
		public static class CreditDetail{
			public String creditType;
			public int accountStatus;
			public int guaranteeWay;
			public String repayFreq;
			public String orgCode;
			public String dateOpened;
			public String dateClosed;
			public BigDecimal creditLimit;
			public int balance;
			public int loanTerm;
			public int periodNumber;
			public String billingDate;
			public BigDecimal scheduledAmount;
			public BigDecimal actualPayAmount;
			public String actualPayDate;
			public int maxOverdueTimes;
			public int nowOverdueTimes;
			public BigDecimal nowOverdueAmount;
			public BigDecimal maxOverdueAmount;
		}
		/**
		 * 算话征信报告-24个月还款状态
		 * @author YM10177
		 *
		 */
		public static class RepayStatus{
			public String start;
			public String end;
			public String M1;
			public String M2;
			public String M3;
			public String M4;
			public String M5;
			public String M6;
			public String M7;
			public String M8;
			public String M9;
			public String M10;
			public String M11;
			public String M12;
			public String M13;
			public String M14;
			public String M15;
			public String M16;
			public String M17;
			public String M18;
			public String M19;
			public String M20;
			public String M21;
			public String M22;
			public String M23;
			public String M24;
		}
		/**
		 * 算话征信报告-逾期信息记录
		 * @author YM10177
		 *
		 */
		public static class Overdue{
			public int nowOverdueTimes;
			public BigDecimal nowOverdueAmount;
			public String billingDate;
		}
	}
	/**
	 * 算话征信报告-长期未更新信贷概要
	 * @author YM10177
	 *
	 */
	public static class RemoteCreditInfo{
		public int unSettledNum;
		public BigDecimal unSettledBalance;
		public int agentNum;
		public BigDecimal agentBalance;
		public int guaranteeNum;
		public BigDecimal guaranteeBalance;
		public int overdueNum;
		public int maxOverdueTimes;
		public BigDecimal maxOverdueAmount;
	}
	public static class DebtInfoContainer{
		public Map<String,DebtInfo> unSettled;
		public DebtInfo guarantee;
	}
	/**
	 * 算话征信报告-授信及负债概要
	 * @author YM10177
	 *
	 */
	public static class DebtInfo{
		public int orgNum;
		public int total;
		public BigDecimal creditLimit;
		public BigDecimal balance;
	}
	/**
	 * 算话征信报告-信用提示
	 * @author YM10177
	 *
	 */
	public static class Indicator{
		public int total;
		public int unSettledTotal;
		public int guaranteeTotal;
	}
	/**
	 * 算话征信报告-逾期及违约概要
	 * @author YM10177
	 *
	 */
	public static class OverdueInfo{
		public int badDebtNum;
		public BigDecimal badDebtBalance;
		public int offNum;
		public BigDecimal offBalance;
		public int agentNum;
		public BigDecimal agentBalance;
		public int overdueNum;
		public int maxOverdueTimes;
		public BigDecimal maxOverdueAmount;
	}
}
