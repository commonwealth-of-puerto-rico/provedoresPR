
package com.domain.project;

import java.util.List;

public class Grants{
   	private List flags;
   	private boolean inherited;
   	private String type;

 	public List getFlags(){
		return this.flags;
	}
	public void setFlags(List flags){
		this.flags = flags;
	}
 	public boolean getInherited(){
		return this.inherited;
	}
	public void setInherited(boolean inherited){
		this.inherited = inherited;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
}
