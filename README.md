# oeis-clj

A Clojure library for querying sequences on [oeis.org](http://oeis.org/).

**NEEDS SOME LOVE** 

*one of my first clojure/lein projects, need to revisit and revamp*

*(only returns single digits instead of '11' or '123')*

## Usage

*please see [oeis end-user agreement](http://oeis.org/wiki/The_OEIS_End-User_License_Agreement)*

*originally intended for repl work, retrofitting for a more useable library*

```clojure
user=> (use 'oeis-clj.core)
nil
user=> (take 7 (parse-oeis-page "A000045"))           ;; return first 7 numbers in fibonacci
(0 1 1 2 3 5 8)
```

## License

Copyright © 2013 Patrick Ryan - phiat

Distributed under the Eclipse Public License, the same as Clojure.
