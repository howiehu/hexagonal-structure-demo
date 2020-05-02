package dev.huhao.samples.ddd.blogservice.application.usecase;

import dev.huhao.samples.ddd.blogservice.domain.blogcontext.blog.Blog;
import dev.huhao.samples.ddd.blogservice.domain.blogcontext.blog.BlogDomainService;
import dev.huhao.samples.ddd.blogservice.domain.blogcontext.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class EditBlogUseCase {
    private final BlogDomainService blogDomainService;
    private final BlogRepository blogRepository;

    @Autowired
    public EditBlogUseCase(BlogRepository blogRepository) {
        this.blogDomainService = new BlogDomainService(blogRepository);
        this.blogRepository = blogRepository;
    }

    @Transactional
    public Blog createDraft(String title, String body, UUID authorId) {
        return blogDomainService.createDraft(title, body, authorId);
    }
}