package mate.academy.onlinebookstore.repository.book;

import jakarta.persistence.criteria.Predicate;
import mate.academy.onlinebookstore.model.Book;
import mate.academy.onlinebookstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    public static final String KEY = "author";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public Specification<Book> getSpecification(String param) {
        return (root, query, criteriaBuilder) -> {
            Predicate cb = criteriaBuilder.like(root.get(KEY), "% %".replace(" ", param));
            // return root.get(KEY).in(param);
            return cb;
        };
    }
}
