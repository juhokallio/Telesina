/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;

/**
 *
 * @author juho
 */
@ImplementedBy(TelesinaAIImpl.class)
public interface TelesinaAI {

	public Solution getSolution(Situation situation);
}
