package com.example.tp.domain.model.person.ability;

public interface PersonAbilities {

    boolean isAbleToAddNewBook();

    boolean isAbleToBorrowBook();

    Integer borrowBookTimeLimitInWeek();

    Integer borrowBookNumberLimitAtTheSameTime();
}
