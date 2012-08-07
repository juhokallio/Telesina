/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.google.inject.ImplementedBy;

/**
 *
 * @author juho
 */
@ImplementedBy(TextualHumanizer.class)
public interface TelesinaHumanizer {
	public String humanizeCard(int card);
	public int dehumanizeCard(String card);
}
