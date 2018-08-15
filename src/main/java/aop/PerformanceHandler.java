package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
	 private Object target;  
	    public PerformanceHandler(Object object) {  
	        this.target = object;  
	    }  
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 PerformanceMonitor.begin(target.getClass().getName() + "."  
	                + method.getName());  
	        Object obj = method.invoke(target, args);  
	        PerformanceMonitor.end();  
	        return obj;  
	}

}
