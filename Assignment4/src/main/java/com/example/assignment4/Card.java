package com.example.assignment4;

public class Card extends CardIdentity{
    private boolean cardError;
    public Card()
    {
        super();
        this.cardError=false;
    }

    public Card(char value, Suit suit)
    {
        super();
        if(!set(value,suit))
        {
            super.set('A', Suit.spades);
            this.cardError=true;
        }else{
            this.cardError=false;
        }
    }
    public boolean set(char value,Suit suit)
    {
        if(super.set(value,suit))
        {
            this.cardError=false;
            return true;
        }
        this.cardError=true;
        return false;
    }
    public boolean getCardError()
    {
        return cardError;
    }
    public boolean equals(Card card){
        if(this.getValue()==card.getValue()&&this.getSuit()==card.getSuit()&&this.getCardError()==card.getCardError())
        {
            return true;
        }
        return false;
    }
    public String toString1()
    {
        if(cardError)
        {
            return "** invalid **";
        }
        return getValue()+" of "+getSuit()+" ";
    }
}

