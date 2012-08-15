/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Strategy;
import java.util.Set;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juho
 */
public class StrategyFactorySimpleTest {
	StrategyFactorySimple strategyFactory;

	@Before
	public void initialize() {
		Injector injector = Guice.createInjector();
		strategyFactory = injector.getInstance(StrategyFactorySimple.class);
	}	

	@Test
	public void simpleStrategyFactoryTest1() {
		Situation situation = new Situation(2);
		Set<Strategy> strategies = strategyFactory.getStrategies(situation);
		int combinations = AISettings.DEFAULT_1ST_ACTION_PERCENTAGES.length ^ AISettings.DEFAULT_BREAKPOINTS.length; 
		Assert.assertEquals(combinations, strategies.size());
	}
}
