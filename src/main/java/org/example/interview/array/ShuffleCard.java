package org.example.interview.array;

import java.util.Random;

public class ShuffleCard {
    /*
    面试题 17.02. 洗牌。设计一个用来洗牌的函数。要求做到完美洗牌
    思路：对于每个元素i，将array[i]与0和i之间的一个随机元素进行交换。
    */
    public void  shuffleCards(int[] cards) {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int k = random.nextInt(i + 1);
            int tmp = cards[k];
            cards[k] = cards[i];
            cards[i] = tmp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }
}
