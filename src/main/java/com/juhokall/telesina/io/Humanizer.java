/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.io;

/**
 *
 * @author juho
 */
public interface Humanizer {
	public Object humanizeCard(int card);
	public int dehumanizeCard(Object card);
}
