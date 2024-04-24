# Babashka i praksis

## Agenda

- Hva er Babashka?
  - Single binary, native compiled (graalvm)
- Hvordan du bruker Babashka
  - Eksempel 1, light: shebang, chmod +x, go!
  - Eksempel 2, heavy: clojure deps+bb-prosjekt, velg hvilken selv
- Forskjeller og likheter mellom JVM-Clojure og Babashka
  - Oppstartstid: JVM: ca 1 s, Babahska: ca 0 s.
  - Throughput: JVM vinner, bruk den.
    JVM Clojure er kompilert, kode du kjører med Babashka blir tolket.
  - Sammenliknet med Python: sammenliknbart.
    Loops er raskere enn i Python.
- En introduksjon til bibliotekene babashka/fs, babashka/process og babashka/cli
  - babashka/fs
    - fs/glob
    - fs/????
    - timestamp for når ting ble endret
    - fs/file
    - fs/absolutize
    - fs/expand-home
- og litt live-programmering.

- Mob-programmering

- Q/A, "hvis Michiel Borkent var med på video, hva ville du spurt om?"
