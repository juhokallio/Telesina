/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class PlayerTest {

	@Test
	public void removeFromStackTest1() {
		int stackSize = 50;
		Player player = new Player(stackSize);
		int betSize = 30;
		int takenAmount = player.removeFromStack(betSize);
		Assert.assertEquals(betSize, takenAmount);
	}
	@Test
	public void removeFromStackTest2() {
		int stackSize = 10;
		Player player = new Player(stackSize);
		int betSize = 30;
		int takenAmount = player.removeFromStack(betSize);
		Assert.assertEquals(stackSize, takenAmount);
	}
}
