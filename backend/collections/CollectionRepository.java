package org.proj.styleboard.repository;

import org.proj.styleboard.entity.Collection;
import org.proj.styleboard.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    List<Collection> findAllByUser(UserInfo user);
}