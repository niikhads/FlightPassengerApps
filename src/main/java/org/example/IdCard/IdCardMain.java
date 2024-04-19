package org.example.IdCard;

import org.example.IdCard.model.IdCard;
import org.example.IdCard.repository.IdCardRepository;
import org.example.IdCard.repository.impl.IdCardRepositoryImpl;

public class IdCardMain {

    public static void main(String[] args) {
        IdCardRepositoryImpl idCardRepository = IdCardRepositoryImpl.getInstance();
        boolean delete = idCardRepository.delete(6L);
        System.out.println("---------delete-------------");
        System.out.println(delete);

    }

}