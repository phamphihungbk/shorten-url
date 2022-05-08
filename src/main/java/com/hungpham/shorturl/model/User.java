package com.hungpham.shorturl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table(value = "users")
public class User{

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
	@Id
	private UUID id;

	@CassandraType(type = CassandraType.Name.TIMESTAMP)
	private Instant createdDate;

	@CassandraType(type = CassandraType.Name.TIMESTAMP)
	private Instant lastLogin;

	@CassandraType(type = CassandraType.Name.VARCHAR)
	private String name;

	@CassandraType(type = CassandraType.Name.VARCHAR)
	private String email;
}
