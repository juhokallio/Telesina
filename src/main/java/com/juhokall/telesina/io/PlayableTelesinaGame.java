/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

import com.google.inject.ImplementedBy;
import com.juhokall.telesina.game.TelesinaGame;

/**
 *
 * @author juho
 */
//@ImplementedBy(PlayableTelesinaGameImpl.class)
public interface PlayableTelesinaGame extends TelesinaGame {
 	public void dealNextStreet();	
}
