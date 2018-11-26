package com.eg.web;

public class Todo {
	private int srNo;
	private String todo;
	private String status;
	public Todo(int srNo, String todo, String status) {
		super();
		this.srNo = srNo;
		this.todo = todo;
		this.status = status;
	}
	public Todo() {
		super();
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Todo [srNo=" + srNo + ", todo=" + todo + ", status=" + status + "]";
	}
	
	
}
