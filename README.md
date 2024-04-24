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

## Gode hjelpere jeg har fått ja fra

- Christian Johansen har sagt ja til å navigere og til å være rådgiver når andre navigerer
- Olav har sagt tentativt ja til å demonstrere en babashka-funksjon
- Michiel Borkent har sagt ja til å være med på en halvtimes Q/A

## Gode hjelpere jeg ikke har spurt ennå

- Peter Strömberg -- ønsker å spørre om han vil navigere, og om han vil være rådgiver
- Erik Assum -- ønsker å spørre om han vil være rådgiver

## Guide til mob-programmering

Du kan få hjelp, hvis du vil!
