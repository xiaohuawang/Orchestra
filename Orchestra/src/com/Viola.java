package com;

public class Viola extends Instrument {

	public Viola() {
		super();
		hoursPlayed = 0;
		maxHoursPlayable = 120;
	}

	public void perform() throws BrokenInstrumentException {
		hoursPlayed=hoursPlayed+3.2;
		if(hoursPlayed>maxHoursPlayable){
			isBroken=true;
			throw (new BrokenInstrumentException());
		}
	}

}
