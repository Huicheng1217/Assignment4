package com.example.assignment4;

public class CardIdentity {
    public enum Suit{clubs,diamonds,hearts,spades};
    private char value;
    private Suit suit;
    public CardIdentity()
    {
        value='A';
        this.suit=Suit.spades;
    }
    public Suit getSuit()
    {
        return suit;
    }
    public char getValue()
    {
        return value;
    }
    private static boolean isValid(char value,Suit suit)
    {
        if (value == 'A' || value=='K' ||value=='Q' ||value=='J' ||value=='T' ||(value>='2'&&value<='9'))
        {
            return true;
        }
        return false;
    }
    public boolean set(char value,Suit suit) {
        if (isValid(value, suit)) {
            this.value = value;
            this.suit = suit;
            return true;
        }
        return false;
    }
}

