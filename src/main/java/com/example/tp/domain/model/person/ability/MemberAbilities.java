package com.example.tp.domain.model.person.ability;

public class MemberAbilities implements PersonAbilities {
    @Override
    public boolean isAbleToAddNewBook() {
        return false;
    }

    @Override
    public boolean isAbleToBorrowBook() {
        return true;
    }

    @Override
    public Integer borrowBookTimeLimitInWeek() {
        return 4;
    }

    @Override
    public Integer borrowBookNumberLimitAtTheSameTime() {
        return 3;
    }
}
