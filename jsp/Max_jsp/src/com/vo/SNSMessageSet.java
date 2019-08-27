package com.vo;

import java.util.List;
/*
 * List<SNSMessageSet>
 * 
 */
public class SNSMessageSet {
	private SNS_MsgVO msgVO = null;
	private List<SNS_RepleVO> reList = null;
	
	public SNS_MsgVO getMsgVO() {
		return msgVO;
	}
	public void setMsgVO(SNS_MsgVO msgVO) {
		this.msgVO = msgVO;
	}
	public List<SNS_RepleVO> getReList() {
		return reList;
	}
	public void setReList(List<SNS_RepleVO> reList) {
		this.reList = reList;
	}
	
}
