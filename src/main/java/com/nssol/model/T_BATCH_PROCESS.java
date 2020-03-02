package com.nssol.model;

import com.nssol.common.Constant;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class T_BATCH_PROCESS implements Serializable {

	private static final long serialVersionUID = 7287641570441977129L;

	private String id;

	private String batch_id;

	private int process_flag;

	private Timestamp process_time;

	private int isDel;

	private String creater;

	private Timestamp createTime;

	private String modifyer;

	private Timestamp modifyTime;


	public T_BATCH_PROCESS(){
		id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		createTime = new Timestamp(System.currentTimeMillis());
		modifyTime = createTime;
		isDel = 0;
		creater  = Constant.BATCH_USER;
		modifyer = Constant.BATCH_USER;
	}
	public T_BATCH_PROCESS(String BATCH_ID){
		id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		createTime = new Timestamp(System.currentTimeMillis());
		modifyTime = createTime;
		isDel = 0;
		batch_id = BATCH_ID;
		creater  = Constant.BATCH_USER;
		modifyer = Constant.BATCH_USER;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public int getProcess_flag() {
		return process_flag;
	}

	public void setProcess_flag(int process_flag) {
		this.process_flag = process_flag;
	}

	public Timestamp getProcess_time() {
		return process_time;
	}

	public void setProcess_time(Timestamp process_time) {
		this.process_time = process_time;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}


	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}
}
