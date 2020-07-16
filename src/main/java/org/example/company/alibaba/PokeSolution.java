package org.example.company.alibaba;


public class PokeSolution {
    public static void main(String[] args) throws InterruptedException {
        Card[] cards = new Card[54];
        String[] colors = {"♥","♠","♦","♣"};
        String[] values = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards[i * 13 + j] = new Card(colors[i], values[j]);
            }
        }
        cards[52] = new Card("", "joker");
        cards[53] = new Card("", "JOKER");

        shuffle(cards);

        for (Card card : cards)
            System.out.print(card.getValue() + " ");

    }

    public static void shuffle(Card[] cards) throws InterruptedException {
        // 不能使用random
        for (int j = 0; j < cards.length; j++) {
            for (int i = 0; i < cards.length; i++) {
                int a = (int) (System.currentTimeMillis() % (cards[i].hashCode() % cards.length));
                Thread.sleep(1);
                int b = (int) (System.currentTimeMillis() % (cards[cards.length - 1 - i].hashCode() % cards.length));
                Card tmp = cards[a];
                cards[a] = cards[b];
                cards[b] = tmp;
            }
        }
    }

}

class Card{
    String color;
    String value;
    public Card(String color,String value){
        this.color = color;
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public String getValue() {
        return value;
    }
}

