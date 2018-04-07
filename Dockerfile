FROM postgres:latest
EXPOSE 5432
ENV POSTGRES_PASSWORD cljpgsql
ENV POSTGRES_USER cljpgsql
COPY scripts/efp-db.sql /docker-entrypoint-initdb.d/