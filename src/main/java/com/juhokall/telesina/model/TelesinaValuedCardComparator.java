/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import java.util.Comparator;

/**
 *
 * @author juho
 */
public class TelesinaValuedCardComparator implements Comparator<TelesinaValuedCard> {

	@Override
	public int compare(TelesinaValuedCard t, TelesinaValuedCard t1) {
		return t.getValue() - t1.getValue();
	}
	
}
