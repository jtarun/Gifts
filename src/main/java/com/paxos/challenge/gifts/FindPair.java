package com.paxos.challenge.gifts;

import java.util.List;

public class FindPair {

    public static void main(String[] args) {

        if (args.length < 2) {
            throw new RuntimeException("Usage: FindPair fileName targetPrice");
        }

        List<Gift> gifts = InputParser.getGifts(args[0]);
        int targetPrice = InputParser.getPriceValue(args[1]);

        int n = gifts.size();
        int i = 0;
        int j = n - 1;
        int minDiff = Integer.MAX_VALUE;
        Gift gift1 = null, gift2 = null;

        while (i < j) {
            int sumOfPrices = gifts.get(i).getPrice() + gifts.get(j).getPrice();
            int diffFromTarget = targetPrice - sumOfPrices;

            if (diffFromTarget >= 0) {
                if (gift1 == null || diffFromTarget < minDiff) {
                    gift1 = gifts.get(i);
                    gift2 = gifts.get(j);
                    minDiff = diffFromTarget;
                    if (minDiff == 0) break;
                }
                i++;
            } else {
                j--;
            }
        }

        String res;
        if (gift1 == null) {
            res = "Not possible";
        } else {
            res = gift1 + ", " + gift2;
        }

        System.out.println(res);
    }

}
