/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.ai.Strategy;

/**
 *
 * @author juho
 */
public class StrategyCrawlerImpl implements StrategyCrawler{
	private StrategyFactory strategyFactory;

	@Inject
	public StrategyCrawlerImpl(StrategyFactory strategyFactory) {
		this.strategyFactory = strategyFactory;
	}

	
	@Override
	public int crawlStrategy(Strategy strategy) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
