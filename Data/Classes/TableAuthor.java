
package com.domain.project;

import java.util.List;

public class TableAuthor{
   	private String displayName;
   	private String id;
   	private List rights;
   	private String roleName;
   	private String screenName;

 	public String getDisplayName(){
		return this.displayName;
	}
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public List getRights(){
		return this.rights;
	}
	public void setRights(List rights){
		this.rights = rights;
	}
 	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
 	public String getScreenName(){
		return this.screenName;
	}
	public void setScreenName(String screenName){
		this.screenName = screenName;
	}
}
