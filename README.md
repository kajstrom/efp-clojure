# Exercises for Programmers in Clojure

[Exercises for Programmers](https://pragprog.com/book/bhwb/exercises-for-programmers)

## Notes
pgsql postfixed modules the cljpgsql container must be running. 


Create and start cljpgsql container
```
scripts\create-cljpgsql.ps1
```

Update and start cljpgsql container

```
scripts\create-cljpgsql.ps1
```

On *nix machines rename the ps1 files to .sh.

Get bash to cljpgsql container:
```
docker container exec -it cljpgsql /bin/bash
```

## TODO

- Change to a more flexible way of updating/flushing the PgSQL database used.