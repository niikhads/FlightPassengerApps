package org.example.NumberCard;


import org.example.NumberCard.repository.NumberCardRepository;
import org.example.NumberCard.repository.impl.NumberCardRepositoryImpl;

public class NumberCardMain {

    public static void main(String[] args) {

        NumberCardRepository numberCardRepository = NumberCardRepositoryImpl.getInstance();
        boolean delete = numberCardRepository.delete(6L);
        System.out.println("---------delete-------------");
        System.out.println(delete);

    }

}