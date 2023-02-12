package org.metatrans.apps.maze.events;


import org.metatrans.commons.events.Event_Base;
import org.metatrans.commons.events.api.IEvent_Base;


public interface IEvent_MOS extends IEvent_Base {
	
	
	public int WIN_GAME_STEPS_250 = 1;
	public int WIN_GAME_STEPS_500 		= 2;
	public int WIN_GAME_STEPS_750 		= 3;
	public int WIN_GAME_STEPS_1000 		= 4;
	public int WIN_GAME_STEPS_2500 		= 5;
	public int WIN_GAME_STEPS_5000 		= 6;
	public int WIN_GAME_STEPS_7500 		= 7;
	public int WIN_GAME_STEPS_10000 	= 8;
	public int WIN_GAME_STEPS_25000		= 9;
	public int WIN_GAME_STEPS_50000		= 10;
	public int WIN_GAME_STEPS_75000		= 11;
	public int WIN_GAME_STEPS_100000	= 12;

	IEvent_Base EVENT_GAME_WIN_STEPS_250 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_250,
			STR_WIN_GAME, "STEPS_250"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_500 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_500,
			STR_WIN_GAME, "STEPS_500"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_750 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_750,
			STR_WIN_GAME, "STEPS_750"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_1000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_1000,
			STR_WIN_GAME, "STEPS_1000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_2500 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_2500,
			STR_WIN_GAME, "STEPS_2500"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_5000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_5000,
			STR_WIN_GAME, "STEPS_5000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_7500 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_7500,
			STR_WIN_GAME, "STEPS_7500"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_10000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_10000,
			STR_WIN_GAME, "STEPS_10000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_25000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_25000,
			STR_WIN_GAME, "STEPS_25000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_50000= new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_50000,
			STR_WIN_GAME, "STEPS_50000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_75000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_75000,
			STR_WIN_GAME, "STEPS_75000"
	);

	IEvent_Base EVENT_GAME_WIN_STEPS_100000 = new Event_Base(
			WIN_GAME, WIN_GAME_STEPS_100000,
			STR_WIN_GAME, "STEPS_100000"
	);
}
