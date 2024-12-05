package org.proj.styleboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.proj.styleboard.entity.Collection;
import org.proj.styleboard.entity.UserInfo;
import org.proj.styleboard.repository.CollectionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CollectionServiceTest {

    @Mock
    private CollectionRepository collectionRepository;

    @InjectMocks
    private CollectionService collectionService;

    private UserInfo testUser;

    @BeforeEach
    public void setUp() {
        testUser = new UserInfo();
        testUser.setId(1L);
        testUser.setName("Test User");
    }

    @Test
    public void testGetAllCollectionsByUser() {
        Collection collection1 = new Collection("Collection 1", testUser);
        Collection collection2 = new Collection("Collection 2", testUser);
        when(collectionRepository.findAllByUser(testUser)).thenReturn(Arrays.asList(collection1, collection2));

        List<Collection> collections = collectionService.getAllCollectionsByUser(testUser);

        assertThat(collections).hasSize(2);
        assertThat(collections).extracting("name")
                .containsExactlyInAnyOrder("Collection 1", "Collection 2");
        verify(collectionRepository, times(1)).findAllByUser(testUser);
    }

    @Test
    public void testCreateCollection() {
        Collection collection = new Collection("New Collection", testUser);
        when(collectionRepository.save(any(Collection.class))).thenReturn(collection);

        Collection createdCollection = collectionService.createCollection("New Collection", testUser);

        assertThat(createdCollection.getName()).isEqualTo("New Collection");
        assertThat(createdCollection.getUser()).isEqualTo(testUser);
        verify(collectionRepository, times(1)).save(any(Collection.class));
    }

    @Test
    public void testDeleteCollection() {
        Long collectionId = 1L;
        doNothing().when(collectionRepository).deleteById(collectionId);

        collectionService.deleteCollection(collectionId);

        verify(collectionRepository, times(1)).deleteById(collectionId);
    }
}
