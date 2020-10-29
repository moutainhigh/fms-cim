package org.fms.cim.common.domain.archives;

import java.math.BigDecimal;

public class BulkRefundEntity {

	private String settlementNo;

	private BigDecimal refundMoney;

	public String getSettlementNo() {
		return settlementNo;
	}

	public void setSettlementNo(String settlementNo) {
		this.settlementNo = settlementNo;
	}

	public BigDecimal getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
}
