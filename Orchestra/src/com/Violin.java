package com;

public class Violin extends Instrument{

	public Violin(){
		super();
		hoursPlayed=0;
		maxHoursPlayable=85;
	}
	public void perform() throws BrokenInstrumentException {
		hoursPlayed=hoursPlayed+2.85;
		if(hoursPlayed>maxHoursPlayable){
			isBroken=true;
			throw (new BrokenInstrumentException());
		}
	}

}
