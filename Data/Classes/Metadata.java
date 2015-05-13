
package com.domain.project;

import java.util.List;

public class Metadata{
   	private List availableDisplayTypes;
   	private String rdfClass;
   	private String rdfSubject;
   	private RenderTypeConfig renderTypeConfig;
   	private String rowIdentifier;

 	public List getAvailableDisplayTypes(){
		return this.availableDisplayTypes;
	}
	public void setAvailableDisplayTypes(List availableDisplayTypes){
		this.availableDisplayTypes = availableDisplayTypes;
	}
 	public String getRdfClass(){
		return this.rdfClass;
	}
	public void setRdfClass(String rdfClass){
		this.rdfClass = rdfClass;
	}
 	public String getRdfSubject(){
		return this.rdfSubject;
	}
	public void setRdfSubject(String rdfSubject){
		this.rdfSubject = rdfSubject;
	}
 	public RenderTypeConfig getRenderTypeConfig(){
		return this.renderTypeConfig;
	}
	public void setRenderTypeConfig(RenderTypeConfig renderTypeConfig){
		this.renderTypeConfig = renderTypeConfig;
	}
 	public String getRowIdentifier(){
		return this.rowIdentifier;
	}
	public void setRowIdentifier(String rowIdentifier){
		this.rowIdentifier = rowIdentifier;
	}
}
