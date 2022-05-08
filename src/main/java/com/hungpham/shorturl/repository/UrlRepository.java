package com.hungpham.shorturl.repository;

import com.hungpham.shorturl.model.Url;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends ReactiveCassandraRepository<Url, Integer> {

}
