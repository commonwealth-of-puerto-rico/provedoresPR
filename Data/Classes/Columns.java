
package com.domain.project;

import java.util.List;

public class Columns{
   	private String dataTypeName;
   	private String fieldName;
   	private Format format;
   	private Number id;
   	private String name;
   	private Number position;
   	private String renderTypeName;

 	public String getDataTypeName(){
		return this.dataTypeName;
	}
	public void setDataTypeName(String dataTypeName){
		this.dataTypeName = dataTypeName;
	}
 	public String getFieldName(){
		return this.fieldName;
	}
	public void setFieldName(String fieldName){
		this.fieldName = fieldName;
	}
 	public Format getFormat(){
		return this.format;
	}
	public void setFormat(Format format){
		this.format = format;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getPosition(){
		return this.position;
	}
	public void setPosition(Number position){
		this.position = position;
	}
 	public String getRenderTypeName(){
		return this.renderTypeName;
	}
	public void setRenderTypeName(String renderTypeName){
		this.renderTypeName = renderTypeName;
	}
}
