package cn.believeus.system.observer;

import java.util.Observable;
import java.util.Observer;
import org.springframework.stereotype.Component;


// 观察者模式：1.由变化引起的变化，2.类和类之间分清界限
@Component
public class BelieveusObserver implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		
	}

}
