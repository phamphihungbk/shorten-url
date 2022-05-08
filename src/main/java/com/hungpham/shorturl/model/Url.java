package com.hungpham.shorturl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "urls")
public class Url {

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
	@Id
	private Integer id;

	@CassandraType(type = CassandraType.Name.TIMESTAMP)
	private Instant createdDate;

	@CassandraType(type = CassandraType.Name.TIMESTAMP)
	private Instant expiredDate;

	@CassandraType(type = CassandraType.Name.VARCHAR)
	private String originalUrl;

	@CassandraType(type = CassandraType.Name.VARCHAR)
	private String userID;
}
