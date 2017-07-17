package ru.example.impls.robot;

import ru.example.interfaces.Hand;
import ru.example.interfaces.Head;
import ru.example.interfaces.Leg;
import ru.example.interfaces.Robot;

public class ModelT1000 implements Robot {

	private Hand hand;
	private Leg leg;
	private Head head;

	private String color;
	private int year;
	private boolean soundEnabled;

	public ModelT1000() {
	}

	public ModelT1000(Hand hand, Leg leg, Head head) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	public ModelT1000(String color, int year, boolean soundEnabled) {
		super();
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Leg getLeg() {
		return leg;
	}

	public void setLeg(Leg leg) {
		this.leg = leg;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	public void action() {
		head.calc();
		hand.catchSomething();
		leg.go();
		System.out.println("color: " + color);
		System.out.println("year: " + year);
		System.out.println("can play sound: " + soundEnabled);
	}

	@Override
	public void dance() {
		System.out.println("T1000 is dancing!");
	}

}
