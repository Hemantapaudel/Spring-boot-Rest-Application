package com.commom.application.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SingletonObject {
	
	@Autowired
	ObjectFactory< ProtoTypeObject> objectFactory;
	
	
	public void  print(){
		System.out.println(objectFactory.getObject().hashCode());
	}
	
	

}
