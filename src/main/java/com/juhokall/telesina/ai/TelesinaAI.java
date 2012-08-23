/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 * The class that binds all the other structures finally together.
 * @author juho
 */
@ImplementedBy(TelesinaAISimple.class)
public interface TelesinaAI {
/**
 * Returns a concrete recommended solution out of a situation and the active player's hole card.
 * @author juho
 */
	public Solution getSolution(Situation situation, int holeCard);
}
