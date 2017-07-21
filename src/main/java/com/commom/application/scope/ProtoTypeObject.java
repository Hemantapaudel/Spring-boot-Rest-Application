package com.commom.application.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class ProtoTypeObject {

}
