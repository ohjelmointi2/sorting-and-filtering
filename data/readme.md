# Scripts for modifying users and posts

This folder contains `users.json` and `posts.json` files with randomized timestamps.

## users.json

Each user now has a `registeredAt` timestamp:

> *"As part of our ongoing improvements to our platform, we've encountered a unique challenge with the `registeredAt` attribute in our user records. The `registeredAt` attribute stores the registration date for each user. However, we've noticed that different users have different data types for this attribute. Users who registered through our mobile app have an integer value representing the epoch timestamp, while users who registered through the web app have a string in ISO format. It's crucial that we sort all users in ascending order by their registration date, regardless of the data type inconsistency."*
>
> Fictional product manager Maxwell Goldgrabber (ChatGPT)

```diff
 [
   {
     "id": 1,
     "firstName": "Terry",
     "lastName": "Medhurst",
     "maidenName": "Smitham",
     "age": 50,
     "gender": "male",
     "userAgent": "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/12.0.702.0 Safari/534.24",
+    "registeredAt": "2022-07-16T22:57:59.361Z"
   },
   {
     "id": 2,
     "firstName": "Sheldon",
     "lastName": "Quigley",
     "maidenName": "Cole",
     "age": 28,
     "gender": "male",
     "userAgent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.30 (KHTML, like Gecko) Ubuntu/11.04 Chromium/12.0.742.112 Chrome/12.0.742.112 Safari/534.30",
+    "registeredAt": 1638589047
   }
 ]
```

## posts.json

Each post now has a `publishedAt` timestamp. A `deletedAt` timestamp has been added to random posts:

```diff
 [
   {
     "id": 4,
     "title": "All he wanted was a candy bar.",
     "body": "All he wanted was a candy bar. It didn't seem like a difficult request to comprehend, but the clerk remained frozen and didn't seem to want to honor the request. It might have had something to do with the gun pointed at his face.",
     "userId": 12,
     "tags": [
       "mystery",
       "english",
       "american"
     ],
     "reactions": 1,
+    "publishedAt": "2023-04-17T18:16:52.003Z"
   },
   {
     "id": 5,
     "title": "Hopes and dreams were dashed that day.",
     "body": "Hopes and dreams were dashed that day. It should have been expected, but it still came as a shock. The warning signs had been ignored in favor of the possibility, however remote, that it could actually happen. That possibility had grown from hope to an undeniable belief it must be destiny. That was until it wasn't and the hopes and dreams came crashing down.",
     "userId": 41,
     "tags": [
       "crime",
       "mystery",
       "love"
     ],
     "reactions": 2,
+    "publishedAt": "2023-06-01T08:07:20.410Z",
+    "deletedAt": "2023-06-14T02:16:08.513Z"
   }
 ]
```

## DummyJSON

The JSON files are a part of [DummyJSON](https://github.com/Ovi/DummyJSON/) project created by [Muhammad Ovi (Owais)](https://github.com/Ovi/). The files are licensed under the MIT license: [https://github.com/Ovi/DummyJSON/blob/master/LICENCE](https://github.com/Ovi/DummyJSON/blob/master/LICENCE).
