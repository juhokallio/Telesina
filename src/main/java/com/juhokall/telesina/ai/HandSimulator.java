/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.model.TelesinaHand;
import com.juhokall.telesina.model.TelesinaValuedCard;

/**
 *
 * @author juho
 */
@ImplementedBy(HandSimulatorImpl.class)
public interface HandSimulator{
	public TelesinaValuedCard getValuedCard(TelesinaHand hand);
}
