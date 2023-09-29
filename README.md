# Java & Gradle -projektipohja

Tämä repositorio sisältää valmiiksi määritellyt Gradle-skriptit sekä [.gitignore](./.gitignore)- ja [.gitattributes](./.gitattributes)-tiedostot Java-projektien pohjaksi. Projektipohjan käyttö edellyttää [Javan versiota 17 tai uudempaa](https://code.visualstudio.com/docs/java/java-tutorial#_installing-a-java-development-kit-jdk).


## Gradle ja "wrapper scripts"

[Gradle](https://gradle.org/) on suosittu "build automation"-työkalu, joka helpottaa projektin sekä sen riippuvuuksien hallintaa. Gradlew-skriptit (wrapper scripts) ovat osa Gradlea ja ne mahdollistavat Gradlen käytön ilman, että sinun tarvitsee asentaa Gradle erikseen. Voit ajaa projektiin liittyviä Gradle-tehtäviä suoraan näiden skriptien kautta.


### Gradlen käyttö

Skriptit löytyvät projektitiedostojen juuresta. Voit käyttää niitä esim. seuraavasti:

**Unix**:

```bash
./gradlew build    # kääntää projektin ja tuottaa suoritettavan JAR-tiedoston
./gradlew test     # suorittaa projektiin liittyvät testit
```

**Windows**:

```powershell
.\gradlew.bat build    # kääntää projektin ja tuottaa suoritettavan JAR-tiedoston
.\gradlew.bat test     # suorittaa projektiin liittyvät testit
```

Ensimmäisen komennon suorittamisen yhteydessä Gradle lataa tarvittavat riippuvuudet automaattisesti.


## .gitignore ja .gitattributes

Tämä pohja sisältää myös valmiiksi määritellyt `.gitignore`- ja `.gitattributes`-tiedostot. `.gitignore`:ssa on määritelty, mitkä tiedostot jätetään versionhallinnan ulkopuolelle, kun taas `.gitattributes`-tiedostossa on määritetty eri tiedostotyypeille yhtenäiset rivinvaihtomerkit.

Voit muokata näitä tiedostoja tarpeidesi mukaan.


## Miten käytän tätä pohjaa

1. Forkkaa tämä projekti omalle GitHub-tilillesi. Käytä "Fork" -painiketta tämän projektin GitHub-sivulla.

2. Kloonaa forkkaamasi projekti omalle tietokoneellesi:

   ```bash
   git clone https://github.com/OMA_KÄYTTÄJÄTUNNUKSESI/projekti.git
   ```

3. Muokkaa projektin tiedostoja ja koodia tarpeidesi mukaan.

4. Käytä Gradle-skriptejä suorittaaksesi erilaisia tehtäviä projektissasi.

5. Lisää oma koodisi ja muokatut tiedostot Git-versionhallintaan:

   ```bash
   git add tiedosto1 tiedosto2 tiedosto3
   git commit -m "Ensimmäinen commit"
   ```

6. Pushaa muutokset GitHubiin omalle forkkaamallesi projektille:

   ```bash
   git push origin master
   ```


## Projektin avaaminen Eclipsessä

1. Avaa Eclipse ja valitse `File -> Open Projects from File System...`.

2. Valitse `Directory...` ja valitse projektin kansio, jonka olet aiemmin kloonannut.

3. Klikkaa `Finish` avataksesi projektin Eclipse-ssä.


## Projektin avaaminen VS Codessa

1. Avaa Visual Studio Code ja valitse `File -> Open Folder...`.

2. Valitse projektin kansio, jonka olet aiemmin kloonannut ja klikkaa `Open`.

3. Voit nyt muokata, rakentaa ja suorittaa projektiasi Visual Studio Codessa.



## Lisätietoja

Lisätietoja Gradlesta ja sen käytöstä löydät [Gradlen virallisilta verkkosivuilta](https://gradle.org/).

Hyvää koodausta ja onnea projektisi kanssa!

-----

Tämän tiedoston luonnissa on hyödynnetty [GhatGPT 3.5](https://chat.openai.com/) -kielimallia.
