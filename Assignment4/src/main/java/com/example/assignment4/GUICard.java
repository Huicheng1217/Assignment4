package com.example.assignment4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class GUICard {
    private static Image[][] imagesCards = new Image[14][4];
    private static ImageView[][] imageCardViews = new ImageView[14][4];
    private static Image imageBack;
    private static ImageView imageCardBack;
    private static boolean imagesLoaded = false;

    private static String cardIValsConvertAssist = "23456789TJQKAX";
    private static String suitValsConvertAssist = "CDHS";
    private static Card.Suit suitConvertAssist[] =
            {Card.Suit.clubs, Card.Suit.diamonds, Card.Suit.hearts, Card.Suit.spades};


    static void loadCardImages() {
        if (!imagesLoaded) {
            int intSuit, intVal;
            for (intSuit = 0; intSuit < 4; intSuit++) {
                for (intVal = 0; intVal < 14; intVal++) {
                    String imagePath = "/images/" + turnIntIntoCardValueChar(intVal) + turnIntIntoCardSuitChar(intSuit) + ".gif";
                    URL imageURL = GUICard.class.getResource(imagePath);
                    if (imageURL != null) {
                        imagesCards[intVal][intSuit] = new Image(imageURL.toExternalForm());
                        imageCardViews[intVal][intSuit] = new ImageView(imagesCards[intVal][intSuit]);
                        System.out.println("Image found: " + imageURL.toExternalForm());
                    } else {
                        System.out.println("Image not found: " + imagePath);
                    }
                }
            }
            String imageBackPath = "/images/BK.gif";
            URL imageBackURL = GUICard.class.getResource(imageBackPath);
            if (imageBackURL != null) {
                imageBack = new Image(imageBackURL.toExternalForm());
                imageCardBack = new ImageView(imageBack);
            } else {
                System.out.println("Image not found: " + imageBackPath);
            }
            imagesLoaded = true;
        }
    }

    static public Image getImage(Card card) {
        loadCardImages();
        return imagesCards[valueAsInt(card)][suitAsInt(card)];
    }

    static public Image imageBack() {
        return imageBack;
    }

    static char turnIntIntoCardValueChar(int k) {
        if (k < 0 || k > 13) {
            return '?';
        } else {
            return cardIValsConvertAssist.charAt(k);
        }
    }

    static char turnIntIntoCardSuitChar(int k) {
        if (k < 0 || k > 3) {
            return '?';
        } else {
            return suitValsConvertAssist.charAt(k);
        }
    }

    static Card.Suit turnIntIntoCardSuit(int k) {
        if (k < 0 || k > 3) {
            return null;
        } else {
            return suitConvertAssist[k];
        }
    }

    static Card.Suit turnIntIntoSuit(int k) {
        return suitConvertAssist[k];
    }

    static int valueAsInt(Card card) {
        int value = 0;
        String strvalue = String.valueOf(card.getValue());
        if (strvalue.equals("A"))
            value = 1;
        if (strvalue.equals("2"))
            value = 2;
        if (strvalue.equals("3"))
            value = 3;
        if (strvalue.equals("4"))
            value = 4;
        if (strvalue.equals("5"))
            value = 5;
        if (strvalue.equals("6"))
            value = 6;
        if (strvalue.equals("7"))
            value = 7;
        if (strvalue.equals("8"))
            value = 8;
        if (strvalue.equals("9"))
            value = 9;
        if (strvalue.equals("T"))
            value = 10;
        if (strvalue.equals("J"))
            value = 11;
        if (strvalue.equals("Q"))
            value = 12;
        if (strvalue.equals("k"))
            value = 13;

        return value;
    }

    static int suitAsInt(Card card) {
        int value = 0;
        CardIdentity.Suit suit = CardIdentity.Suit.spades;
        String strSuit = String.valueOf(card.getSuit());
        if (strSuit.equals("clubs"))
            value = 0;
        if (strSuit.equals("diamonds"))
            value = 1;
        if (strSuit.equals("hearts"))
            value = 2;
        if (strSuit.equals("spades"))
            value = 3;
        return value;
    }
}
