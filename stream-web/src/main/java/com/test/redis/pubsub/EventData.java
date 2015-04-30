package com.test.redis.pubsub;

public class EventData {

	private String name;
	private Long time;
	private Long count;
	
	public EventData(){
		
	}
	
	public EventData(long count){
		this.name="Test";
		this.time= System.currentTimeMillis();
		this.count=count;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "EventData [name=" + name + ", time=" + time + ", count="
				+ count + "]";
	}
	
}
