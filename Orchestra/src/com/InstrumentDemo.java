package com;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class InstrumentDemo {

	public static void main(String[] args) throws NumberFormatException, BrokenInstrumentException {
		// this is used to ensure we always get 2 decimal places in our
		// hoursplayed.
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		// Double.valueOf(twoDForm.format(<double>));

		// Violin and Viola tests
		Violin myViolin = new Violin();
		Viola myViola = new Viola();

		System.out.println("Violin has been played "
				+ myViolin.getHoursPlayed() + " out of "
				+ myViolin.getMaxHoursPlayable() + " hours.");
		System.out.println("Viola has been played " + myViola.getHoursPlayed()
				+ " out of " + myViola.getMaxHoursPlayable() + " hours.");

		try {
			myViolin.practiceInstrument(1.7);
			myViolin.perform();
			myViola.practiceInstrument(3.6);
			myViola.perform();

			System.out
					.println("Violin has been played "
							+ Double.valueOf(twoDForm.format(myViolin
									.getHoursPlayed())) + " out of "
							+ myViolin.getMaxHoursPlayable() + " hours.");
			System.out.println("Viola has been played "
					+ Double.valueOf(twoDForm.format(myViola.getHoursPlayed()))
					+ " out of " + myViola.getMaxHoursPlayable() + " hours.");

			// Checking BrokenInstrumentException
			// break both instruments - only one should break and exception
			// should happen
			myViolin.practiceInstrument(1000);
			myViola.practiceInstrument(1000);
		} catch (BrokenInstrumentException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Violin is broken: " + myViolin.isBroken());
		System.out.println("Viola is broken: " + myViola.isBroken());

		// Ensure Violin and Viola extend Instrument
		Instrument myViolinInstrument = myViolin;
		Instrument myViolaInstrument = myViola;
		System.out.println(myViolinInstrument.getMaxHoursPlayable());
		System.out.println(myViolaInstrument.getMaxHoursPlayable());

		// Now check Orchestra Class - new Orchestra with 2 Viola objects and 3
		// Violin objects
		Orchestra myOrchestra = new Orchestra(2, 3);

		// test getter
		ArrayList<Instrument> myOrchestraInstruments = myOrchestra
				.getInstruments();
		int totalMaxHoursPlayable = 0;
		for (Instrument i : myOrchestraInstruments)
			totalMaxHoursPlayable += i.getMaxHoursPlayable();
		System.out.println("Throughout our orchestra, we have "
				+ totalMaxHoursPlayable + " playable hours");

		// test practice and perform
		myOrchestra.orchestraPractice(30.7);
		myOrchestra.performShow();

		double currentlyPlayed = 0;
		// output results
		for (Instrument i : myOrchestraInstruments)
			currentlyPlayed += i.getHoursPlayed();

		System.out.println("Throughout our orchestra, we have played "
				+ currentlyPlayed + " hours");
	}

}

/*
 * Expected Output: Violin has been played 0.0 out of 85 hours. Viola has been
 * played 0.0 out of 120 hours. Violin has been played 4.55 out of 85 hours.
 * Viola has been played 6.8 out of 120 hours. Unable to play with a broken
 * instrument Violin is broken: true Viola is broken: false 85 120 Throughout
 * our orchestra, we have 495 playable hours Throughout our orchestra, we have
 * played 168.45 hours
 */
