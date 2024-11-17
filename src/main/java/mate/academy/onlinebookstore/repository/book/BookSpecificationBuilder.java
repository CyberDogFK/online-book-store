package mate.academy.onlinebookstore.repository.book;

import lombok.RequiredArgsConstructor;
import mate.academy.onlinebookstore.dto.BookSearchParametersDto;
import mate.academy.onlinebookstore.model.Book;
import mate.academy.onlinebookstore.repository.SpecificationBuilder;
import mate.academy.onlinebookstore.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.title() != null && !searchParameters.title().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager
                    .getSpecificationProvider(TitleSpecificationProvider.KEY)
                    .getSpecification(searchParameters.title()));
        }
        if (searchParameters.author() != null && !searchParameters.author().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager
                    .getSpecificationProvider(AuthorSpecificationProvider.KEY)
                    .getSpecification(searchParameters.author()));
        }
        if (searchParameters.isbn() != null && !searchParameters.isbn().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager
                    .getSpecificationProvider(IsbnSpecificationProvider.KEY)
                    .getSpecification(searchParameters.isbn()));
        }
        return spec;
    }
}
