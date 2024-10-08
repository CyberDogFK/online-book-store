package mate.academy.onlinebookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    @NonNull
    public String title;
    @Column(nullable = false)
    @NonNull
    public String author;
    @Column(nullable = false, unique = true)
    @NonNull
    public String isbn;
    @Column(nullable = false)
    @NonNull
    public BigDecimal price;
    public String description;
    public String coverImage;
}
