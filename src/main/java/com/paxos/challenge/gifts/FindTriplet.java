package com.paxos.challenge.gifts;

import java.util.List;

public class FindTriplet {

    public static void main(String[] args) {

        if (args.length < 2) {
            throw new RuntimeException("Usage: FindTriplet fileName targetPrice");
        }

        List<Gift> gifts = InputParser.getGifts(args[0]);
        int targetPrice = InputParser.getPriceValue(args[1]);

        int n = gifts.size();
        int minDiff = Integer.MAX_VALUE;
        Gift gift1 = null, gift2 = null, gift3 = null;

        for (int i = 0; i < n-2; i++) {
            int j = i+1, k = n-1;

            while (j < k) {

                int pricesSum = gifts.get(i).getPrice() + gifts.get(j).getPrice()
                        + gifts.get(k).getPrice();

                int diffFromTarget = targetPrice - pricesSum;
                if (diffFromTarget >= 0) {
                    if (gift1 == null || diffFromTarget < minDiff) {
                        gift1 = gifts.get(i);
                        gift2 = gifts.get(j);
                        gift3 = gifts.get(k);
                        minDiff = diffFromTarget;
                        if (minDiff == 0) {
                            break;
                        }
                    }
                    j++;
                } else {
                    k--;
                }

            }

            if (minDiff == 0) break;
        }

        String res;
        if (gift1 == null) {
            res = "Not possible";
        } else {
            res = gift1 + ", " + gift2 + ", " + gift3;
        }

        System.out.println(res);
    }

}
