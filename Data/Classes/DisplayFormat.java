
package com.domain.project;

import java.util.List;

public class DisplayFormat{
   	private List bkgdLayers;
   	private boolean disableGeolocator;
   	private boolean exclusiveLayers;
   	private List viewDefinitions;
   	private Viewport viewport;

 	public List getBkgdLayers(){
		return this.bkgdLayers;
	}
	public void setBkgdLayers(List bkgdLayers){
		this.bkgdLayers = bkgdLayers;
	}
 	public boolean getDisableGeolocator(){
		return this.disableGeolocator;
	}
	public void setDisableGeolocator(boolean disableGeolocator){
		this.disableGeolocator = disableGeolocator;
	}
 	public boolean getExclusiveLayers(){
		return this.exclusiveLayers;
	}
	public void setExclusiveLayers(boolean exclusiveLayers){
		this.exclusiveLayers = exclusiveLayers;
	}
 	public List getViewDefinitions(){
		return this.viewDefinitions;
	}
	public void setViewDefinitions(List viewDefinitions){
		this.viewDefinitions = viewDefinitions;
	}
 	public Viewport getViewport(){
		return this.viewport;
	}
	public void setViewport(Viewport viewport){
		this.viewport = viewport;
	}
}
