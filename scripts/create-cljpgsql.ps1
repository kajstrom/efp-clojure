docker build -t cljpgsql .
docker run -d -p 5432:5432 --name cljpgsql cljpgsql