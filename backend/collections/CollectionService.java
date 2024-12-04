package org.proj.styleboard.service;
import org.proj.styleboard.entity.Pin;
import org.proj.styleboard.entity.UserInfo;
import org.proj.styleboard.entity.Collection;
import org.proj.styleboard.repository.PinRepository;
import org.proj.styleboard.repository.UserInfoRepository;
import org.proj.styleboard.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollectionsByUser(UserInfo user) {
        return CollectionRepository.findAllByUser(user);
    }

    // create collection

    public Collection createCollection(String name, UserInfo user) {
        Collection collection = new Collection(name, user);
        return collectionRepository.save(collection);
    }


    //delete collection

    public void deleteCollection(Long id) {
        collectionRepository.deleteById(id);
    }
}