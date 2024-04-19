package org.example.NumberCard.repository;

import org.example.NumberCard.entity.NumberCard;

import java.util.List;

public interface NumberCardRepository {

    List<NumberCard> getAll();
    NumberCard getByNumber(Long number);
    boolean insert(NumberCard numberCard);
    boolean update(NumberCard numberCard );
    boolean delete(Long number);

}