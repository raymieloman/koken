package nl.acme.koken.trywithresources.exercise;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class DrawerTest {

    @InjectMocks
    private Drawer drawer; // class under test

    @Mock
    private Set<String> articles;

    @Test
    public void testOpenAndClose() {
        final Drawer mydrawer = drawer;
        Assertions.assertTrue(mydrawer.isOpen());
        try (mydrawer) {
            mydrawer.add("Donald Duck");
            mydrawer.add("Margriet");
            mydrawer.add("Eppo");
        }
        Assertions.assertFalse(mydrawer.isOpen());
    }

    @Test
    public void testUsingMockito() {
        // Given
        Mockito.when(this.articles.size()).thenReturn(5);

        // When
        int size = this.drawer.size();

        // Then
        Assertions.assertEquals(5, size);
    }
}