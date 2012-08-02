/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.rules;

import com.google.inject.ImplementedBy;

/**
 *
 * @author juho
 */
@ImplementedBy(TelesinaHandRaterImpl.class)
public interface TelesinaHandRater {
	
	public int getHighcardValue(int card);
	public int getPairhandValue(int[] hand);
}
