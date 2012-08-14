/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.ai.AISettings;
import com.juhokall.telesina.model.ai.Strategy;

/**
 *
 * @author juho
 */
public class StrategyFactoryImpl implements StrategyFactory{

	@Override
	public Strategy[] getStrategies(Situation situation) {
		Strategy[] strategies = new Strategy[AISettings.STRATEGY_CANDIDATE_COUNT];
		
		HandRange heroRange = situation.getActivePlayer().getRange();
		int villainCount = situation.getPlayerCount() - 1;
		HandRange[] villainRanges = new HandRange[villainCount];
		Player[] villains = situation.getNonActivePlayers();
		for(int i = 0; i < villainCount; i++) {
			villainRanges[i] = villains[i].getRange();
		}

		if(AISettings.HEADS_UP_MODE) {
						
		}

		return strategies;
	}

	
}