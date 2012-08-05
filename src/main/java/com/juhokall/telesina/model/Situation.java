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

	Map<Integer, Player> players;
	List<Integer> playerIds;
	int street;
	int potSize;
	int activePlayerId;	
	Player activePlayer;

	public Situation(int playersCount) {
	
		players = new HashMap<Integer, Player>();
		playerIds = new ArrayList<Integer>();
		for (int i = 0; i < playersCount; i++) {
			players.put(i, new Player());
			playerIds.add(i);
			System.out.println("pelaaja " + i);
		}
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
