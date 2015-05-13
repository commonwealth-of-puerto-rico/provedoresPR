
package com.domain.project;

import java.util.List;

public class Plot{
   	private List descriptionColumns;
   	private Number locationId;
   	private Number titleId;

 	public List getDescriptionColumns(){
		return this.descriptionColumns;
	}
	public void setDescriptionColumns(List descriptionColumns){
		this.descriptionColumns = descriptionColumns;
	}
 	public Number getLocationId(){
		return this.locationId;
	}
	public void setLocationId(Number locationId){
		this.locationId = locationId;
	}
 	public Number getTitleId(){
		return this.titleId;
	}
	public void setTitleId(Number titleId){
		this.titleId = titleId;
	}
}
