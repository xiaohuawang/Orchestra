package com;

public abstract class Instrument {
	
	protected double hoursPlayed=0.0;
	protected int maxHoursPlayable=0;
	protected boolean isBroken=false;
	
	public double getHoursPlayed() {
		return hoursPlayed;
	}
	public void setHoursPlayer(double hoursPlayer) {
		this.hoursPlayed = hoursPlayer;
	}
	public int getMaxHoursPlayable() {
		return maxHoursPlayable;
	}
	public void setMaxHoursPlayable(int maxHoursPlayable) {
		this.maxHoursPlayable = maxHoursPlayable;
	}
	public boolean isBroken() {
		return isBroken;
	}
	public void setBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}
	
	public void replaceInstrument(){
		hoursPlayed=0;
		isBroken=false;
	}
	
	public void practiceInstrument(double hoursPracticed) throws BrokenInstrumentException{

		hoursPlayed=hoursPlayed+hoursPracticed;
		if(hoursPlayed>maxHoursPlayable){
			isBroken =true;
			throw (new BrokenInstrumentException());
		}
	}
	public abstract void perform() throws BrokenInstrumentException ;
	//Possible to throw BrokenInstrumentException 
}






