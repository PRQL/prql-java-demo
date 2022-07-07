# Demo project of prql-java

Just testing out prql-java, a wrapper around the prql-compiler Rust crate.

## How to run

1. Compile and install prql-java locally. We may provide a release jar containing prebuilt binaries for many architectures in the future, but for now you should:
   1. clone the [prql repository](https://github.com/prql/prql)
   2. `cd prql-java/java`
   3. `mvn install` (which will also build the compiler crate for your architecture)

2. Run this maven project: `mvn exec:java`

Output on my machine:

```
➜  prql-demo mvn exec:java
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------------< org.prql-lang:prql-demo >-----------------------
[INFO] Building prql-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default-cli) > validate @ prql-demo >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default-cli) < validate @ prql-demo <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ prql-demo ---
SELECT
  EXTRACT(
    dow
    FROM
      created_at
  ) AS day_of_the_week,
  SUM(items_sum - promo_sum) AS total
FROM
  orders
GROUP BY
  EXTRACT(
    dow
    FROM
      created_at
  )
ORDER BY
  day_of_the_week
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.480 s
[INFO] Finished at: 2022-07-07T22:00:40+02:00
[INFO] ------------------------------------------------------------------------
```