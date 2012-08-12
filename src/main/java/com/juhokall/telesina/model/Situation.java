/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

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
	}

	public Situation(int playersCount) {
		this(playersCount, Telesina.DEFAULT_STACK);
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
}
