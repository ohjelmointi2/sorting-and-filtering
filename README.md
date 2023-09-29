# Filter, map ja sort

Tässä tehtävässä perehdytään filter- ja map-funktioihin sekä lajittelualgoritmeihin.

Tavoitteenamme on opetella tiettyjä ennalta valittuja algoritmeja sekä tietorakenteita sekä tehdä koodista testattavaa ja uudelleenkäytettävää.


## Tehtävien tarkastaminen

Tehtävät tarkastetaan automaattisesti [JUnit-yksikkötesteillä](./src/test/java/). Testeihin perehtyminen ei ole tehtävän suorittamiseksi välttämätöntä, mutta testit voivat auttaa hahmottamaan miten oman koodisi tulee toimia.

💡 *Saat kirjoittaa halutessasi lisää testejä, mutta älä muuta tai poista valmiiksi kirjoitettuja testejä.*

💡 *Tehtävänannossa määritettyjen metodien ja luokkien nimien, parametrien tai paluuarvojen muuttaminen ei ole sallittua testien toimivuuden varmistamiseksi.*


## Riippuvuuksien asentaminen

Koodieditorisi asentaa todennäköisesti projektin riippuvuudet automaattisesti, kun avaat projektin ensimmäistä kertaa. Voit asentaa riippuvuudet myös manuaalisesti komennolla:

```sh
./gradlew install       # Unix
gradlew.bat install     # Windows
```

Riippuvuudet sisältävät [JUnit-testaustyökalun](https://junit.org/) yksikkötestien suorittamiseksi sekä [`Gson`](https://github.com/google/gson/)-kirjaston JSON-tiedostojen käsittelemiseksi.


## Pääohjelman suorittaminen

Tehtäväpohjassa on valmiiksi toteutettu pääohjelma [TODO](./src/main/java/), joka tulostaa käyttäjiä ja postauksia. Tulosteet ovat alussa väärät ja esimerkiksi käyttäjien nimien jälkeen tulostuu aina samat otsikot. Tulosteet muuttuvat kuitenkin oikeiksi sitä mukaa, kun ratkot tehtävän osia. Voit suorittaa pääohjelman joko koodieditorisi run-painikkeella tai Gradle:n avulla:

```sh
./gradlew run       # Unix
gradlew.bat run     # Windows
```

Ohjelman tuloste on muodoltaan esim. seuraava:

```
# Samantha Stringdate (2022-07-16T22:57:59.361Z)
 - TypeScript for dummies
   2023-06-30T05:30:54.612Z 2023-07-13T14:36:48.159Z
 - This post was published in 2021 and deleted in 2023
   2021-07-11T05:33:06.104Z 2023-07-21T23:53:01.586Z

# Nelson Numericdate (1638589047)
 - There are different types of secrets.
   2023-09-01T10:02:19.997Z
 - This was published in 2023 and has not been deleted
   2023-07-13T09:33:37.100Z
```

Jokaisen käyttäjän tulosteen on siis tarkoitus olla seuraava:

```
# [Etunimi] [Sukunimi] ([rekisteröitymisaika])
 - [Postaus 1:n otsikko]
   [postedAt-aikaleima] [deletedAt-aikaleima, jos poistettu]
 - [Postaus 2:n otsikko]
   [postedAt-aikaleima]
```

Ohjelma on pilkottu useisiin erillisiin luokkiin ja metodeihin, jotta eri toiminnot saadaan yksikkötestattua, ja jotta niitä voidaan uudelleenkäyttää eri puolilla isompaa sovelluskokonaisuutta. Sinun tehtäväsi on jatkaa näiden luokkien ja metodien kehitystyötä fiktiivisen tuoteomistajan vaatimusten mukaisesti.

💡 *Sinun ei tarvitse muuttaa pääohjelmaa ratkaistessasi tätä tehtävää. Tiedoston muuttaminen esim. ohjelman toiminnan tutkimiseksi on kuitenkin halutessasi sallittua.*


## Tehtävän data

Tehtävässä hyödynnetään JSON-muotoista esimerkkidataa [dummyjson.com](https://dummyjson.com)-palvelusta. Tehtäväpohjan tiedostot [users.json](./data/users.json) sekä [posts.json](./data/posts.json) on ladattu tähän git-repositorioon DummyJSON-projektin [GitHub-repositoriosta](https://github.com/Ovi/DummyJSON/blob/master/src/data/).

Alkuperäiseen esimerkkidataan nähden `Post`-tietotyyppiin on tehty uudet attribuutit `publishedAt` sekä `deletedAt`:

```diff
 {
   "id": 5,
   "title": "Hopes and dreams were dashed that day.",
   "body": "Hopes and dreams were...",
   "userId": 41,
   "tags": [
     "crime",
     "mystery",
     "love"
   ],
   "reactions": 2,
+  "publishedAt": "2023-06-01T08:07:20.410Z",
+  "deletedAt": "2023-06-14T02:16:08.513Z"
 }
```

`User`-tietotyyppiin on lisäksi lisätty `registeredAt`-tieto.

```diff
 {
   "id": 1,
   "firstName": "Terry",
   "lastName": "Medhurst",
   "maidenName": "Smitham",
   "age": 50,
   "gender": "male",
   "userAgent": "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/12.0.702.0 Safari/534.24",
+  "registeredAt": "2022-07-16T22:57:59.361Z"
 }
```

Näitä JSON-tietotyyppejä vastaavat Java-luokat löytyvät valmiina [models-paketista](./src/main/java/models) . Tarkemmat tiedot uusista tiedoista selviävät alempaa.


## Tehtävä

Yrityksenne tuoteomistaja Maxwell Goldgrabber on kirjoittanut sinulle oheisen fiktiivisen saateviestin.

[TL;DR](https://en.wikipedia.org/wiki/TL;DR): Jos et jaksa lukea tarinaa, voit hypätä viestin yli suoraan tehtävän osiin.

> Subject: RE: RE: RE: RE: Users and posts
>
> Dear developer,
>
> I hope this message finds you well. We have some critical tasks ahead that require your immediate attention. These tasks are not only essential for our product's success but also for my quarterly bonus, which is directly tied to their successful completion.
>
> * Task 1: *filterOutDeletedPosts*
>
>   The first task is to implement the [*filterOutDeletedPosts* method](./src/main/java/). We've received complaints from our customers about deleted posts appearing in the listings. It's absolutely crucial that posts with a *deletedAt* timestamp are filtered out without fail.
>
> * Task 2: *combineUsersAndPosts*
>
>   The second task involves creating a [*combineUsersAndPosts* method](./src/main/java/). Having this functionality in a separate method helps our testers conduct unit tests and other teams to reuse the code.
>
> * Task 3: *sortPostsByPublishedDate*
>
>   Task three is to implement a [*sortPostsByPublishedDate* function](./src/sorting.ts). We need this function to sort posts by *publishedAt* by implementing [a sorting algorithm](https://en.wikipedia.org/wiki/Sorting_algorithm) ourselves.
>
> * Task 4: *sortUsersByRegistrationDate*
>
>   Finally, we need to implement a [*sortUsersByRegistrationDate* function](./src/sorting.ts). This function should sort users by their *registeredAt* date, accommodating different data types (integer and string) for this attribute. **Storing strings and intergers in the same field is a small piece of technical debt that we just need to accept for now**.
>
> The urgency of these tasks cannot be overstated.
>
> On a lighter note, I wanted to share some exciting news. I've already made a pre-order on a Tesla, and my bonus from this quarter is playing a significant role in making that dream a reality. So, you can understand the importance of these tasks!
>
> Your job and my quarterly bonus are at stake if we don't address these issues promptly and effectively. I have complete confidence in your abilities, and I know you can rise to this challenge. Please prioritize these tasks and reach out if you need any guidance or assistance along the way.
>
> Thank you for your dedication to our project, and I look forward to seeing these improvements implemented.
>
> Best regards,
>
> Maxwell Goldgrabber<br/>
> Product Manager<br/>
> Lampaala Group<br/>
> This email was written by ChatGPT

## Osa 1: `filterOutDeletedPosts` (10 % pisteistä)

Toteuta metodi `filterOutDeletedPosts`, jonka pohja löytyy tiedostosta [](). Metodin tulee hyödyntää `filter`-operaatiota ja palauttaa uusi lista, josta puuttuu kaikki sellaiset Post-oliot, joilla on asetettuna `deletedAt`-arvo.

Ratkaisullesi on kirjoitettu valmiit testit, jotka voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests TODO      # unix
gradlew.bat test --tests TODO    # windows
```

Valmiit testit varmistavat seuraavat tapaukset:

```
filtering posts
  ✓ active posts are included in the result
  ✓ posts marked as deleted are excluded from the result
  ✓ deleted posts are removed from the beginning, end and between active articles
  ✓ the function does not modify the original array
```

## Osa 2: `combineUsersAndPosts` (20 % pisteistä)

Tiedostossa [TODO](TODO) on pohja metodille, joka ottaa parametreinaan listat `User`- sekä `Post`-olioista. Tehtävänäsi on jatkokehittää tätä metodia siten, että se luo jokaista käyttäjää kohden uuden `UserWithPosts`-olion, johon on asetettu käyttäjä sekä lista hänen julkaisemistaan `Post`-olioista. Tuloksena metodi palauttaa listan `UserWithPosts`-olioita. `UserWithPosts` on määritetty [TODO](TODO)-tiedostossa. Käyttäjät yhdistetään Post-olioihin niiden id:n perusteella: jokaisella Post-oliolla on `userId`, joka vastaa yhden User-olion `id`:tä.

<!--Lue lisää map-metodista [MDN Web Docs -palvelussa](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map).-->

Ratkaisullesi on kirjoitettu valmiit testit, jotka voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests TODO      # unix
gradlew.bat test --tests TODO    # windows
```

Valmiit testit varmistavat seuraavat tapaukset:

```
combineUsersAndPosts
  ✓ posts are mapped with users correctly
  ✓ function does not modify given users
  ✓ empty input arrays are handled without errors
```

## Osa 3: `sortPostsByPublishedDate` (40 % pisteistä)

Tehtävän kolmannessa osassa sinun tulee **järjestää** eli **lajitella** kirjoitukset (Post) niiden julkaisuajan mukaan käyttäen **itse toteuttamaasi lajittelualgoritmia**.

Tiedostossa [TODO](TODO) on määriteltynä seuraava metodi:

```java
//TODO
 sortPostsByPublishedDate(posts: Post[])
```

Toteuta lajittelulogiikkasi tähän metodiin siten, että metodi palauttaa uuden listan, joka on lajiteltu Post-olioiden julkaisuajan mukaan kasvavassa järjestyksessä. **Voit halutessasi toteuttaa myös erillisiä apumetodeita.**

Huomaa, että koodisi tulee lajitella **kokonaisia Post-olioita**, eli et voi poimia aineistosta esimerkiksi pelkkiä otsikoita ja julkaisuaikoja. **Et saa myöskään muuttaa annettuja listaa tai sillä olevia olioita**.

Ratkaisullesi on kirjoitettu valmiit testit, jotka voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests TODO      # unix
gradlew.bat test --tests TODO    # windows
```

Valmiit testit varmistavat seuraavat tapaukset:

```
sorting posts by publishedAt
  ✓ post are returned in correct order
  ✓ sorting handles posts with identical dates correctly
  ✓ sorting an empty array should not throw exceptions
  ✓ sorting should not modify the original array
  ✓ sorting posts must not utilize Array.sort
```

🚨 **Tämän harjoituksen tavoitteena on opetella itse toteuttamaan jokin tunnettu lajittelualgoritmi, joten Javan valmiiden sort-toteutusten käyttämistä ei sallita.** 🚨

### Yleisimmät lajittelualgoritmit

Voit valita toteutettavan lajittelualgoritmin esimerkiksi seuraavista:

**Lisäyslajittelu eli Insertion Sort**

[https://en.wikipedia.org/wiki/Insertion_sort](https://en.wikipedia.org/wiki/Insertion_sort)

<a title="Simpsons contributor / CC BY-SA (https://creativecommons.org/licenses/by-sa/3.0)" href="https://commons.wikimedia.org/wiki/File:Insertion_sort.gif"><img height="150" alt="Insertion sort" src="https://upload.wikimedia.org/wikipedia/commons/4/42/Insertion_sort.gif"></a>

*Kuva: By Simpsons contributor - Own work, CC BY-SA 3.0, [https://commons.wikimedia.org/w/index.php?curid=17512147](https://commons.wikimedia.org/w/index.php?curid=17512147)*

**Lomituslajittelu eli Merge Sort**

[https://en.wikipedia.org/wiki/Merge_sort](https://en.wikipedia.org/wiki/Merge_sort)

<a title="Swfung8 / CC BY-SA (https://creativecommons.org/licenses/by-sa/3.0)" href="https://commons.wikimedia.org/wiki/File:Merge-sort-example-300px.gif"><img width="150" alt="Merge-sort-example-300px" src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif" style="border solid silver 1px;"></a>

*Kuva: By Swfung8 - Own work, CC BY-SA 3.0, [https://commons.wikimedia.org/w/index.php?curid=14961648](https://commons.wikimedia.org/w/index.php?curid=14961648)*

**Kuplalajittelu eli Bubble Sort**

[https://en.wikipedia.org/wiki/Bubble_sort](https://en.wikipedia.org/wiki/Bubble_sort)

<a href="https://commons.wikimedia.org/wiki/File:Bubble-sort-example-300px.gif#/media/File:Bubble-sort-example-300px.gif" title="By Swfung8 - Own work, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=14953478"><img src="https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif" alt="Bubble-sort-example-300px.gif" width="150" style="border solid silver 1px;"></a>

*Kuva: By Swfung8 - Own work, CC BY-SA 3.0, [https://commons.wikimedia.org/w/index.php?curid=14953478](https://commons.wikimedia.org/w/index.php?curid=14953478)*

**Pikalajittelu eli Quicksort**

[https://en.wikipedia.org/wiki/Quicksort](https://en.wikipedia.org/wiki/Quicksort)

<a href="https://commons.wikimedia.org/wiki/File:Sorting_quicksort_anim.gif#/media/File:Sorting_quicksort_anim.gif" title="By en:User:RolandH, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=1965827"><img src="https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif" alt="Sorting quicksort anim.gif" width="150" style="border solid silver 1px;"></a>

*Kuva: By en:User:RolandH, CC BY-SA 3.0, [https://commons.wikimedia.org/w/index.php?curid=1965827](https://commons.wikimedia.org/w/index.php?curid=1965827)*


### Algoritmin valintaperusteet

Voit valita itsellesi mieluisen algoritmin esimerkiksi tutustumalla ensin niiden tehokkuuteen. Voit myös hyvin valita sen, joka vaikuttaa toteutukseltaan sopivan yksinkertaiselta. Muista myös, että voit kysyä Teamsissa neuvoa mihin vain tehtävässä kohtaamaasi haasteeseen liittyen. Todennäköisesti samojen haasteiden parissa kamppailee myös moni muu kurssilainen.

**Huom!** Oikeassa ohjelmistoprojektissa käyttäisit Javan valmista lajittelulogiikkaa joko [Comparator](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Comparator.html)- tai [Comparable](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Comparable.html)-rajapinnan avulla. Tässä tehtävässä harjoittelemme kuitenkin algoritmin toteutusta, joten kirjoitamme lajittelun itse. Tehtävän seuraavassa osassa saat käyttää valmista metodia.



## Osa 4: `sortUsersByRegistrationDate` (30 % pisteistä)

Tehtävän viimeinen osa on toinen lajittelu, jossa lajiteltavan aineiston vaihtelevat tietotyypit edellyttävät hieman soveltamista:

> As part of our ongoing improvements to our platform, we've encountered a unique challenge with the `registeredAt` attribute in our user records. The `registeredAt` attribute stores the registration date for each user. However, we've noticed that different users have different data types for this attribute. **Users who registered through our mobile app have [a numeric value representing the epoch timestamp (in seconds)](https://en.wikipedia.org/wiki/Unix_time), while users who registered through the web app have [a date string in ISO format](https://en.wikipedia.org/wiki/ISO_8601)**. It's crucial that we sort all users in ascending order by their registration date, regardless of the data type inconsistency.
>
> In this case, you are allowed to utilize the pre-existing `sort` methods. However, I encourage you to reuse the sorting logic that you previously used when sorting posts.
>
> Thank you for your dedication to our project, and I look forward to seeing your solution in action.
>
> Maxwell Goldgrabber<br/>
> This email was written by ChatGPT
>
> P.S. Here are examples of the different types of `registeredAt` values for users:
>
> 1. **Epoch Timestamp (Integer)**:
>    - User 1: Registered at 1632218400 (Represents September 21, 2021, at 12:00:00 UTC)
>    - User 2: Registered at 1663754400 (Represents February 19, 2023, at 12:00:00 UTC)
>
> 2. **ISO Format (String)**:
>    - User 3: Registered at "2022-08-15T18:30:00Z" (Represents August 15, 2022, at 18:30:00 UTC)
>    - User 4: Registered at "2023-04-10T09:45:00Z" (Represents April 10, 2023, at 09:45:00 UTC)
>
> These examples demonstrate the variation in the `registeredAt` attribute's data types, with some users having numeric values (epoch timestamps) and others having string values (in ISO 8601 format). It's essential that your implementation handles the different data types (integer and string) for the *registeredAt* attribute **without modifying the user records**.

Käyttäjiä vertaillessasi siis sinun tulee siis huomioida, että niiden rekisteröitymisaika saattaa olla tallennettuna kahdella eri tavalla. Tässä voi olla hyödyksi toteuttaa erillinen apumetodi, joka palauttaa käyttäjästä riippumatta rekisteröitymisajan aina samassa muodossa. Lisäksi saatat hyötyä Java-tutoriaalin [The Date Time API](https://dev.java/learn/date-time/)-luvusta.

Ratkaisullesi on kirjoitettu valmiit testit, jotka voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests TODO      # unix
gradlew.bat test --tests TODO    # windows
```

Valmiit testit varmistavat seuraavat tapaukset:

```
sorting users by registration date
  ✓ users with Unix timestamps are sorted in correct order
  ✓ users with ISO dates are sorted in correct order
  ✓ users with both numeric and string dates are sorted in correct order
  ✓ sorting handles posts with identical dates without errors
  ✓ sorting an empty array must not throw exceptions
  ✓ sorting must not modify the users
  ✓ sorting must not modify the original array
```

## Pro task: Geneerinen lajittelumetodi 🚀

Vaikka saat käyttää tehtävän viimeisessä osassa valmista sort-metodia, edellisessä osassa toteuttamasi lajittelualgoritmin jatkokehittäminen ["geneeriseksi"](https://dev.java/learn/generics/intro/) voi olla opettavainen kokemus. Geneerisistä tyypeistä löydät lisätietoa esim. [dev.java-tutoriaalista](https://dev.java/learn/generics/intro/) tai lukuisista nettilähteistä.


## Pro task: Lajittelu streamien avulla 🚀

Tapoja aineiston lajittelemiseksi on lukuisia. Haasta itsesi ja toteuta tehtävän viimeisessä osassa lajittelu hyödyntäen [Javan Stream API:a](https://dev.java/learn/api/streams/intermediate-operation/).


## Lisenssi ja tekijät

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/).

Tehtävänannon, käsiteltävien tiedostojen sekä lähdekoodien toteutuksessa on hyödynnetty ChatGPT 3.5:ttä sekä GitHub copilot-tekoälyavustinta.


## DummyJSON

Tehtävässä hyödynnetyn [DummyJSON](https://github.com/Ovi/DummyJSON/)-palvelun on kehittänyt [Muhammad Ovi (Owais)](https://github.com/Ovi/) ja se on lisensoitu MIT-lisenssillä: [https://github.com/Ovi/DummyJSON/blob/master/LICENCE](https://github.com/Ovi/DummyJSON/blob/master/LICENCE).

