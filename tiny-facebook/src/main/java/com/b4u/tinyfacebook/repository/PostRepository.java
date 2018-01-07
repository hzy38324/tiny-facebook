package com.b4u.tinyfacebook.repository;

import com.b4u.tinyfacebook.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
