package com.b4u.tinyfacebook.repository;

import com.b4u.tinyfacebook.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author: hzy
 * @since: 3.0
 */
@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsername(@Param("username") String username);
}
