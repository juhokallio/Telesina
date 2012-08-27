/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juho
 */
public class Situation {

	private Map<Integer, Player> players;
	private List<Integer> playerIds;
	private int street;
	private int potSize;
	private int activePlayerId;
	private int playerCount;
	private Player activePlayer;
	private Solution lastSolution;
	private int playersLeft;

	public Situation(int playerCount, int stackSizes) {
		Player temp;

		players = new HashMap<Integer, Player>();
		playerIds = new ArrayList<Integer>();
		for (int i = 0; i < playerCount; i++) {
			temp = new Player();
			temp.setStack(stackSizes);
			players.put(i, temp);
			playerIds.add(i);
		}
		this.playerCount = playerCount;
		activePlayer = players.get(0);
		activePlayerId = 0;
		potSize = playerCount * Telesina.DEFAULT_ANTE;
		street = 0;
		lastSolution = new Solution(SolutionType.CHECK);
		playersLeft = playerCount;
	}

	public Solution getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(Solution lastSolution) {
		this.lastSolution = lastSolution;
	}

	public Situation(int playersCount) {
		this(playersCount, Telesina.DEFAULT_STACK);
	}

	@Override
	public Situation clone() {
		Situation s = new Situation(playerCount);
		s.setStreet(street);
		s.setPotSize(potSize);
		s.setPlayerCount(playerCount);
		List<Integer> ids = new ArrayList<Integer>();
		Map<Integer, Player> ps = new HashMap<Integer, Player>();
		for(int id : playerIds) {
			ids.add(id);
			ps.put(id, players.get(id).clone());
		}
		s.setPlayerIds(ids);
		s.setPlayers(ps);
		s.setActivePlayer(activePlayer.clone());
		s.setActivePlayerId(activePlayerId);
		s.setPlayersLeft(playersLeft);
		return s;
	}
	public void decreasePlayersLeft() {
		playersLeft--;
	}
	public int getPlayersLeft() {
		return playersLeft;
	}
	public void moveToNextStreet() {
		street++;
	}

	public void setPlayersLeft(int playersLeft) {
		this.playersLeft = playersLeft;
	}

	public void setPlayers(Map<Integer, Player> players) {
		this.players = players;
	}

	public void setPlayerIds(List<Integer> playerIds) {
		this.playerIds = playerIds;
	}

	public void setActivePlayerId(int activePlayerId) {
		this.activePlayerId = activePlayerId;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public void setActivePlayer(Player activePlayer) {
		for(int i = 0; i < playerCount; i++) {
			Player p = players.get(i);
			if(p == activePlayer) {
				activePlayerId = i;
			}
		}
		this.activePlayer = activePlayer;
	}

	public Map<Integer, Player> getPlayers() {
		return players;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public Player getPlayer(int playerId) {
		return players.get(playerId);
	}

	public List<Integer> getPlayerIds() {
		return playerIds;
	}

	public int getActivePlayerId() {
		return activePlayerId;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(int activePlayerId) {
		this.activePlayer = players.get(activePlayerId);
	}

	public void removePlayer(int playerNumber) {
		players.remove(playerNumber);
		playerIds.remove(playerNumber);
	}

	public void removeActivePlayer() {
		players.remove(activePlayerId);
		playerCount--;
		playerIds.remove(activePlayerId);
	}

	public void addToPot(int amount) {
		potSize += amount;
	}

	public int getPotSize() {
		return potSize;
	}

	public void setPotSize(int potSize) {
		this.potSize = potSize;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}
	public Player[] getNonActivePlayers() {
		Player[] naPlayers = new Player[playerCount - 1];
		int i = 0;
		for(int playerNumber : players.keySet()) {
			if(playerNumber != activePlayerId) {
				naPlayers[i++] = players.get(playerNumber);
			}
		}
		return naPlayers;
	}
}
