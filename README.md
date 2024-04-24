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

## Funksjoner fra `babashka/fs`, `babashka/cli` og `babashka/process`

Funksjoner jeg har brukt i et prosjekt:

``` clojure
$ clj-kondo --lint src --config '{:analysis true :output {:format :edn}}' | bb -e '(def ana (edn/read-string (slurp *in*))) (prn (->> ana :analysis :var-usages (filter #('"'"'#{babashka.fs babashka.process babashka.cli} (:to %))) (map (juxt :to :name)) frequencies (sort-by second) reverse))' | jet
([[babashka.fs file] 7]
 [[babashka.fs exists?] 6]
 [[babashka.fs file-name] 3]
 [[babashka.fs canonicalize] 3]
 [[babashka.fs last-modified-time] 3]
 [[babashka.fs list-dir] 3]
 [[babashka.process shell] 3]
 [[babashka.fs create-dirs] 2]
 [[babashka.cli coerce] 2]
 [[babashka.fs xdg-config-home] 2]
 [[babashka.fs which] 2]
 [[babashka.process process] 1]
 [[babashka.fs delete-if-exists] 1]
 [[babashka.cli dispatch] 1]
 [[babashka.process tokenize] 1]
 [[babashka.fs directory?] 1]
 [[babashka.fs file-time->millis] 1]
 [[babashka.fs glob] 1])
```
