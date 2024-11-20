package org.example.d.member;

public class PremiumMember implements Member {
    private String name;

    public PremiumMember(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PremiumMember{" +
                "name='" + name + '\'' +
                '}';
    }
}
