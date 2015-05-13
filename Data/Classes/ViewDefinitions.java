
package com.domain.project;

import java.util.List;

public class ViewDefinitions{
   	private String color;
   	private boolean flyoutsNoLabel;
   	private String highlightColor;
   	private Number opacity;
   	private Plot plot;
   	private String plotStyle;
   	private String uid;

 	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color = color;
	}
 	public boolean getFlyoutsNoLabel(){
		return this.flyoutsNoLabel;
	}
	public void setFlyoutsNoLabel(boolean flyoutsNoLabel){
		this.flyoutsNoLabel = flyoutsNoLabel;
	}
 	public String getHighlightColor(){
		return this.highlightColor;
	}
	public void setHighlightColor(String highlightColor){
		this.highlightColor = highlightColor;
	}
 	public Number getOpacity(){
		return this.opacity;
	}
	public void setOpacity(Number opacity){
		this.opacity = opacity;
	}
 	public Plot getPlot(){
		return this.plot;
	}
	public void setPlot(Plot plot){
		this.plot = plot;
	}
 	public String getPlotStyle(){
		return this.plotStyle;
	}
	public void setPlotStyle(String plotStyle){
		this.plotStyle = plotStyle;
	}
 	public String getUid(){
		return this.uid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
}
