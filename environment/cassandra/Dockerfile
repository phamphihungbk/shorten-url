FROM cassandra:3.11.12

COPY docker-entrypoint-initdb.d/*.cql /docker-entrypoint-initdb.d/
#COPY entrypoint.sh /entrypoint.sh
#RUN ["chmod", "+x", "/entrypoint.sh"]
#ENTRYPOINT ["/entrypoint.sh"]
#CMD ["cassandra", "-f"]
