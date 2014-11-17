package cn.believeus.system.quartz;

import java.util.Observable;
import java.util.Observer;
import javax.annotation.Resource;

// Name:wuqiwei Date:2013-5-8 实现观察者模式
public class ServiceQuartz extends Observable {
	private Observer believeusObserver;
	public ServiceQuartz() {
	}
	
	public Observer getBelieveusObserver() {
		return believeusObserver;
	}

	@Resource
	public void setBelieveusObserver(Observer believeusObserver) {
		this.believeusObserver = believeusObserver;
		this.addObserver(believeusObserver);
	}


	public void executeInternal() throws Exception {
	}
}