/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.TelesinaHand;

/**
 *
 * @author juho
 */
@ImplementedBy(TelesinaHandRaterImpl.class)
public interface TelesinaHandRater {
	
	public int getHighcardValue(int card);
//	public int getPairhandValue(int[] hand);
	public int getTelesinaHandValue(TelesinaHand hand);
	public int getTelesinaHandValue(int[] hand);
}
