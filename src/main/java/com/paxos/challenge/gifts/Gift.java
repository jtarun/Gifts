package com.paxos.challenge.gifts;

class Gift {
    private String id;
    private int price;

    public Gift(String id, int val) {
        this.id = id;
        this.price = val;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " " + price;
    }
}
