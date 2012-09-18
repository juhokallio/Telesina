/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.google.inject.ImplementedBy;

/**
 * A class to transform some of the game objects to more human readable form.
 * @author juho
 */
@ImplementedBy(TextualHumanizer.class)
public interface TelesinaHumanizer {
	/**
	 * Method that makes single card more human readable.
	 * @param card Telesina card
	 * @return Human readable text presentation.
	 */
	public String humanizeCard(int card);
}
