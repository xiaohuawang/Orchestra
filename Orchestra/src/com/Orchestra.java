package com;

import java.util.ArrayList;

public class Orchestra {

	ArrayList<Instrument> instruments = new ArrayList<Instrument>();

	// Ex. Orchestra(2, 1) would create 2 new Viola, 1 new Violin
	public Orchestra(int numberOfViola, int numberOfViolin) {
		for (int i = 0; i < numberOfViola; i++) {
			instruments.add(new Viola());
		}
		for (int i = 0; i < numberOfViolin; i++) {
			instruments.add(new Violin());
		}
	}

	public ArrayList<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(ArrayList<Instrument> instruments) {
		this.instruments = instruments;
	}

	// for each Instrument in instruments,
	// try to practiceInstrument for the amount of time passed into this
	// function
	// If a BrokenInstrumentException occurs, print the exceptions getMessage()
	// and replaceInstrument
	// return the number of Instrument objects replaced

	public int orchestraPractice(double hours) throws BrokenInstrumentException {
		int numbersOfReplaced = 0;
		for (int i = 0; i < instruments.size(); i++) {
			instruments.get(i).practiceInstrument(hours);
			if (instruments.get(i).isBroken) {
				instruments.get(i).replaceInstrument();
				numbersOfReplaced++;
			}
		}
		return numbersOfReplaced;
	}

	// If a BrokenInstrumentException occurs, print the exceptions getMessage()
	// and return false
	// If a BrokenInstrumentException does not occur for all of the instruments,
	// return true
	
	public boolean performShow() throws BrokenInstrumentException {
		for (int i = 0; i < instruments.size(); i++) {
			instruments.get(i).perform();
		}
		for (int i = 0; i < instruments.size(); i++) {
			if (instruments.get(i).isBroken) {
				System.out
						.println(new BrokenInstrumentException().getMessage());
				return false;
			}
		}

		return true;
	}
}
