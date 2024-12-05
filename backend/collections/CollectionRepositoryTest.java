package org.proj.styleboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.proj.styleboard.entity.Collection;
import org.proj.styleboard.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CollectionRepositoryTest {

    @Autowired
    private CollectionRepository collectionRepository;

    private UserInfo testUser;

    @BeforeEach
    public void setUp() {
        testUser = new UserInfo();
        testUser.setId(1L); 
        testUser.setName("Test User");

        Collection collection1 = new Collection();
        collection1.setName("Collection 1");
        collection1.setUser(testUser);

        Collection collection2 = new Collection();
        collection2.setName("Collection 2");
        collection2.setUser(testUser);

        collectionRepository.save(collection1);
        collectionRepository.save(collection2);

        UserInfo otherUser = new UserInfo();
        otherUser.setId(2L);
        otherUser.setName("Other User");

        Collection otherCollection = new Collection();
        otherCollection.setName("Other Collection");
        otherCollection.setUser(otherUser);

        collectionRepository.save(otherCollection);
    }

    @Test
    public void testFindAllByUser() {
        List<Collection> collections = collectionRepository.findAllByUser(testUser);

        assertThat(collections).hasSize(2);
        assertThat(collections).extracting("name")
                .containsExactlyInAnyOrder("Collection 1", "Collection 2");
    }
}
